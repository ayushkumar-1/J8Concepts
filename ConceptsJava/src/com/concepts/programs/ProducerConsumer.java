package com.concepts.programs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class ProducerConsumer {

	static boolean timeSpanned = false;

	public static void main(String[] args) {
		
		//resolveUsingWaitAndNotify();
		
		resolveUsingBlockingQueue();

	}

	private static void resolveUsingBlockingQueue() {
		//size = 10
		BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(50);
		
		Thread producer = new Thread(new NewProducer(bq));
		Thread consumer = new Thread(new NewConsumer(bq));
		
		producer.start();
		consumer.start();
		
	}

	private static void resolveUsingWaitAndNotify() {
		
		Queue<Integer> queue = new LinkedList<>();
		int maxSize = 10;

		long startTime = System.currentTimeMillis();
		Producer myProducer = new Producer(queue, maxSize, startTime);
		Consumer myConsumer = new Consumer(queue, maxSize, startTime);
		
		Thread producer = new Thread(myProducer);
		Thread consumer = new Thread(myConsumer);

		
		consumer.start();
		producer.start();
		
		//Stopping a Thread
		//myConsumer.stop();
		//myProducer.stop();
		
	}

}

class NewProducer implements Runnable {
	
	private BlockingQueue<Integer> bq;
	
	NewProducer(BlockingQueue bq){
		this.bq = bq;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 50; i++) {
			try {
				System.out.println(Thread.currentThread().getName()+" - Producing the element: "+i);
				bq.put(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class NewConsumer implements Runnable {
	
	private BlockingQueue<Integer> bq;
	
	NewConsumer(BlockingQueue bq){
		this.bq = bq;
	}
	
	@Override
	public void run() {
		while(null != bq.peek() && bq.peek() != 49) {
			try {
				System.out.println(Thread.currentThread().getName()+" - consuming the element: "+bq.peek());
				bq.take();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}


class Producer implements Runnable {

	Queue<Integer> queue;
	int maxSize;
	long startTime;
	private volatile boolean exit = false;

	public Producer(Queue queue, int maxsize, long startTime) {
		this.queue = queue;
		this.maxSize = maxsize;
		this.startTime = startTime;
	}

	@Override
	public void run() {
		AtomicBoolean timeSpanned = new AtomicBoolean(false);
		while (!timeSpanned.get() && !exit) {
			synchronized (queue) {
				while (queue.size() == maxSize) {
					try {
						System.out.println("Queue is full so Producer waiting...");
						queue.wait();
					} catch (Exception e) {
						throw new CustomException(e.getMessage());
					}
				}

				Random random = new Random();
				System.out.println("Producer produced a data in queue");
				queue.add(random.nextInt());
				System.out.println("notification sent for consumption");
				queue.notifyAll();

				if ((System.currentTimeMillis() - startTime) > 10000) {
					timeSpanned.set(true);
				}
				/*try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			}
		}

	}
	
	public void stop() {
		exit = true;
	}

}

class Consumer implements Runnable {

	Queue<Integer> queue;
	int maxSize;
	long startTime;
	private volatile boolean exit = false;

	public Consumer(Queue queue, int maxSize, long startTime) {
		this.queue = queue;
		this.maxSize = maxSize;
		this.startTime = startTime;
	}

	@Override
	public void run() {
		AtomicBoolean timeSpanned = new AtomicBoolean(false);
		while (!timeSpanned.get() && !exit) {
			synchronized (queue) {
				while (queue.isEmpty()) {
					try {
						System.out.println("Queue is empty, so Consumer waiting...");
						queue.wait();
					} catch (InterruptedException e) {
						throw new CustomException(e.getMessage());
					}
				}

				System.out.println("Consumer consumed an elemnet");
				queue.remove();
				System.out.println("notification sent to producer for production");
				queue.notifyAll();
				// to check spanned Time
				if ((System.currentTimeMillis() - startTime) > 10000) {
					timeSpanned.set(true);
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
	
	public void stop() {
		exit = true;
	}

}