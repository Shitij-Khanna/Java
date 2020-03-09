package com.study.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
 
class MyMath {
   public static int add(int a, int b) {
       return a + b;
   }
}
 
public class CallableTest {
  
   public static void main(String[] args) throws Exception {
	
	int x = 10;
	int y = 20;
		
	ExecutorService executor =
               Executors.newFixedThreadPool(1);
	
       // Submit a Callable task and use the Future
       // object to fetch the result.	
	Future<Integer> future =
                   executor.submit(
		        new Callable<Integer>() {
			    public Integer call() {
			        return MyMath.add(x, y);
			    }
			});
	
	 // do some parallel task
	 // Inefficient to simply wait,
        // instead you can release the CPU 
        // by calling Thread.yield() inside
        // the while loop.	
	 while( ! future.isDone())
		; // wait
	
        // fetch the result 	
	 int z = future.get();
		
	 System.out.println( "Result is " + z );
   }
}
