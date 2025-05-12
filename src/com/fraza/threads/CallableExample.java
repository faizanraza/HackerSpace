package com.fraza.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample
{
	public static class SampleCallable implements Callable<String>
	{
		String name;
		int call_sequence = 0;

		SampleCallable(String given_name)
		{
			name = given_name;
		}

		public String call() throws InterruptedException
		{
			int delay = (int) (2000 * Math.random());
			call_sequence++;
			System.out.format("%s pauses %d microseconds on the %d-th invocation.\n", name, delay, call_sequence);
			Thread.sleep(delay);
			System.out.println(Thread.currentThread().getName() + " >> Time >> " + System.currentTimeMillis()/1000);
			return name;
		}
	}

	public static void main(String[] args) throws Exception
	{
		ExecutorService pool = Executors.newFixedThreadPool(2);
		SampleCallable player1 = new SampleCallable("player1");
		SampleCallable player2 = new SampleCallable("player2");
		System.out.println(Thread.currentThread().getName() + " >> Time >> " + System.currentTimeMillis()/1000);
//		for (int i = 2; i > 0; i--)
//		{
			Future future1 = pool.submit(player1);
			Future future2 = pool.submit(player2);
			System.out.println(Thread.currentThread().getName() + " >> Time >> " + System.currentTimeMillis()/1000);
			System.out.println((String) future1.get() + " <> " + (String) future2.get());
			System.out.println(Thread.currentThread().getName() + " >> Time >> " + System.currentTimeMillis()/1000);
//		}
		pool.shutdown();
	}
}
