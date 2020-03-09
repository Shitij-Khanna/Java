package com.study.threads;


//2. Implementing the Runnable interface,
//This marks this class as Runnable and 
//assures that this class contains the run()
//method. Because any class implementing the
//interface should define the abstract method
//of the interface, otherwise it becomes abstract.
class MyRunnableTask implements Runnable {

// Thread execution begins here.
@Override
public void run() {
	// DO THAT TASK HERE.
	for(int i=0; i <= 1000; i++) {
	    System.out.print("-");
	}
}
}

public class CreateThreads {
    // Will run with in the main thread.
    public static void main(String[] args) {
		
	// Because MyThread extends the Thread
	// class, you can call the start() method
	// directly, as it is also a member of this
	// class, courtesy inheritance relation.
	MyThread thr = new MyThread();
	thr.start();
		
	// MyTask is a Runnable task and not a 
	// Thread and hence we need to create a 
	// Thread object and assign it the task 
	// Note here we are calling the start 
	// method over Thread object and not on 
	// task object.
	MyRunnableTask task = new MyRunnableTask();
	Thread thr2 = new Thread(task);
	thr2.start();
		
	for(int i=0; i <= 1000; i++) {
	    System.out.print("M");
	}	
    }
}


class MyThread extends Thread {
	
	// Thread execution begins here.
	public void run() {
		// DO THAT TASK HERE.
		for(int i=0; i <= 1000; i++) {
			System.out.print("T");
		}
	}
	
}
