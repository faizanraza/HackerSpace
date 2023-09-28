package com.fraza.algo.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * B1-R1-B2-C1-C2
 *  \ / \| \  / \
 *  R2 - B3 B5  /
 *   \____\ /__/
 *         B4
 * 
 * Solution is {(B1),(R1, R2),(B2,B3,B4,B5),(C1,C2)}
 */
public class SimilarCluster 
{
	static Node[] nodes = new Node[9];
	static Wedge[] wedges = new Wedge[16];
//	static List<Cluster> clusters = new ArrayList<Cluster>();
	
	static void getInput(String[] args)
	{
		nodes[0] = new Node("B1");
		nodes[1] = new Node("B2");
		nodes[2] = new Node("B3");
		nodes[3] = new Node("B4");
		nodes[4] = new Node("B5");
		nodes[5] = new Node("R1");
		nodes[6] = new Node("R2");
		nodes[7] = new Node("C1");
		nodes[8] = new Node("C2");
		
		wedges[0] = new Wedge(nodes[0], nodes[5]); //B1R1
		wedges[1] = new Wedge(nodes[0], nodes[6]); //B1R2
		wedges[2] = new Wedge(nodes[5], nodes[6]); //R1R2
		wedges[3] = new Wedge(nodes[5], nodes[1]); //R1B2
		wedges[4] = new Wedge(nodes[5], nodes[2]); //R1B3
		wedges[5] = new Wedge(nodes[1], nodes[2]); //B2B3
		wedges[6] = new Wedge(nodes[6], nodes[1]); //R2B2
		wedges[7] = new Wedge(nodes[6], nodes[3]); //R2B4
		wedges[8] = new Wedge(nodes[2], nodes[3]); //B3B4
		wedges[9] = new Wedge(nodes[3], nodes[4]); //B4B5
		wedges[10] = new Wedge(nodes[3], nodes[8]); //B4C2
		wedges[11] = new Wedge(nodes[4], nodes[1]); //B5B2
		wedges[12] = new Wedge(nodes[4], nodes[8]); //B5C2
		wedges[13] = new Wedge(nodes[4], nodes[7]); //B5C1
		wedges[14] = new Wedge(nodes[1], nodes[7]); //B2C1
		wedges[15] = new Wedge(nodes[7], nodes[8]); //C1C2
	}

	public static void main(String[] args) 
	{
		getInput(args);
		solve();
		printSolution();
	}
	
	static void solve()
	{
		for( Node p1: nodes )
		{
			ClusterGroup cg = ClusterGroup.getClusterGroup(p1);

			Node p2 = null;
			for( Wedge w: wedges )
			{
				p2 = w.getOtherNode(p1);
				if(p2 != null && p2.getType() == p1.getType() ) 
					break;
			}
			cg.addNode(p1, p2);
		}
	}
	
	static void printSolution()
	{
		for(ClusterGroup cg: ClusterGroup.clusterGroups.values())
		{
			for(Cluster cluster: cg.clusters)
			{
				for(Node node: cluster.nodes)
				{
					System.out.print( node.name + ",");
				}
				System.out.println();
			}
		}
	}
}

class Node
{
	Node( String name )
	{
		this.name = name;
	}
	String name;
	char getType()
	{
		return this.name.charAt(0);
	}
}

class Wedge
{
	Node p1;
	Node p2;
	
	Wedge(Node p1, Node p2)
	{
		this.p1 = p1;
		this.p2 = p2;
	}
	Node getOtherNode(Node p)
	{
		if( p.name == p1.name ) return p2;
		if( p.name == p2.name ) return p1;
		return null;
	}
}

class ClusterGroup
{
	static Map<Character, ClusterGroup> clusterGroups = new HashMap<Character, ClusterGroup>();
	static ClusterGroup getClusterGroup(Node n)
	{
		ClusterGroup c = clusterGroups.get(n.getType());
		if( null == c )
		{
			c = new ClusterGroup(n.getType());
			clusterGroups.put(n.getType(), c);
		}
		return c;
	}
	
	char type;
	Set<Cluster> clusters = new HashSet<Cluster>();
	ClusterGroup(char type)
	{
		this.type = type;
	}
	void addNode(Node n1, Node n2)
	{
//		if(n.getType() != type) throw new Exception( "Invalid addition to cluster." );
		Cluster foundC = null;
		for( Cluster c: clusters )
		{
			if(c.contains(n2))
				foundC = c;
		}
		if( null == foundC )
		{
			foundC = new Cluster(n1.getType());
			clusters.add(foundC);
			if(null != n2)
				foundC.addNode(n2);
		}
		foundC.addNode(n1);
	}
}

class Cluster
{
	char type;
	Set<Node> nodes = new HashSet<Node>();
	Cluster(char type)
	{
		this.type = type;
	}
	void addNode(Node n)
	{
		nodes.add(n);
	}
	boolean contains(Node n)
	{
		return nodes.contains(n);
	}
}