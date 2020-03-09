package com.study.threads.Producer_Consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// Changed from MessageQueue to BlockingQueue.

class ProducerThreadBQ extends Thread {
	BlockingQueue<String> queue;

	public ProducerThreadBQ(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			String msg = "Hello-" + i;

			// Blocks the thread until the space is available.
			try {
				queue.put(msg);
				System.out.println("Produced - " + msg);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}

class ConsumerThreadBQ extends Thread {
	BlockingQueue<String> queue;

	public ConsumerThreadBQ(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			String message = null;

			// Blocks the thread until the element is available.
			try {
				message = queue.take();
				System.out.println("Consumed - " + message);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}

public class ProducerConsumerWithBlockingQueue {
	public static void main(String[] args) throws InterruptedException {
		final BlockingQueue<String> queue = new ArrayBlockingQueue<String>(3);
		new ProducerThreadBQ(queue).start();
		new ConsumerThreadBQ(queue).start();
	}
}
