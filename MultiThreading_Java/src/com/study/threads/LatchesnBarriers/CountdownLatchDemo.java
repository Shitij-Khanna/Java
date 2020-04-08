package com.study.threads.LatchesnBarriers;

import java.util.concurrent.CountDownLatch;

public class CountdownLatchDemo {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(4);
		Thread first = new Worker(latch, "Thread 1", 1);
		Thread second = new Worker(latch, "Thread 2", 2);
		Thread third = new Worker(latch, "Thread 3", 3);
		Thread fourth = new Worker(latch, "Thread 4", 4);
		
		first.start();
        second.start();
        third.start();
        fourth.start();
		
		// Main thread will wait until all thread finished 
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		System.out.println(Thread.currentThread().getName() + " has finished");

	}
}

class Worker extends Thread {
	
	private int delay;
	private String name;
	CountDownLatch latch;
	
	public Worker(CountDownLatch latch, String name, int delay) {
		super(name);
		this.delay = delay;
		this.name = name;
		this.latch=latch;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(delay);
			latch.countDown();
			System.out.println(Thread.currentThread().getName() + " has finished");
		}catch (InterruptedException  e) {
			e.printStackTrace();
		}
	}
}

// Reference : https://javarevisited.blogspot.com/2012/07/countdownlatch-example-in-java.html