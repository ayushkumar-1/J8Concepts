package com.concepts.programs;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;

public class SemaphoreMutex {

	static Semaphore semaphore = new Semaphore(1);

	public static void main(String[] args) {

		ExecutorService executor = Executors.newFixedThreadPool(6);
		// Callable class
		 callableProcessExecution(executor);
		 String str = new String();

		// Runnable with Workers
		//runnableWorkerExecution(executor);

	}

	private static void runnableWorkerExecution(ExecutorService executor) {

		for (int i = 0; i < 10; i++) {
			Runnable worker = new Worker(semaphore);
			executor.execute(worker);
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
		}
		System.out.println("All Threads Finished");

	}

	private static void callableProcessExecution(ExecutorService executor) {

		MyProcess process = new MyProcess(semaphore);
		// List to hold the future objects of Callable
		List<Future<String>> list = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			Future<String> future = executor.submit(process);
			list.add(future);
		}

		// to get the list of future objects
		try {
			for (Future<String> future : list) {
				System.out.println("Future: " + future.get());
			}
		} catch (InterruptedException | ExecutionException e) {
			e.getMessage();
		}

		executor.shutdown();

	}

}

class Worker implements Runnable {

	Semaphore semaphore;

	Worker(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	@Override
	public void run() {
		try {
			System.out.println("Acquiring Lock - Acquisitions Left - " + semaphore.availablePermits());
			System.out.println("Acquiring semaphore: ");
			semaphore.acquire();
			System.out.println(Thread.currentThread().getName() + " - Got permit");
		} catch (InterruptedException e) {
			e.getMessage();
		} finally {
			System.out.println(Thread.currentThread().getName() + "- Releasing the lock");
			semaphore.release();
		}

		System.out.println("Thread - " + Thread.currentThread().getName() + "running...");
		process();
		System.out.println("Thread - " + Thread.currentThread().getName() + " - work completed.");
	}

	private void process() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Thread - " + Thread.currentThread().getName() + " working...");

		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}

class MyProcess implements Callable<String> {

	Semaphore semaphore;

	MyProcess(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	@Override
	public String call() {
		Random random = new Random();
		int i = random.nextInt();
		//try {
			System.out.println("Acquiring Lock - Acquisitions Left - " + semaphore.availablePermits());
			System.out.println("Acquiring semaphore: ");
			//semaphore.acquire();
			System.out.println(Thread.currentThread().getName() + " - Got permit");

		/*} catch (InterruptedException e) {
			e.getMessage();
		} finally {
			System.out.println(Thread.currentThread().getName() + " - Releasing the lock.");
			semaphore.release();

		}*/
		return "string:" + String.valueOf(i);

	}
}