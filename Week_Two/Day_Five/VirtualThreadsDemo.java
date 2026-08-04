 package Week_Two.Day_Five;

 import java.util.concurrent.ExecutorService;
 import java.util.concurrent.Executors;
 import java.util.concurrent.TimeUnit;

 class Counter {
     int count = 0;

     public synchronized void increment() {
         count++;
     }
 }

 public class VirtualThreadsDemo {
     public static void main(String[] args) {
         Counter counter = new Counter();

         try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
             Runnable task = () -> {
                 for (int i = 0; i < 10; i++) {
                     counter.increment();
                 }
             };

             executor.submit(task);
             executor.submit(task);

             // shutdown executor and wait
             executor.shutdown();

             System.out.println(executor.getClass());

             if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
                 System.out.println("Final Count = " + counter.count);
             } else {
                 System.out.println("Tasks did not finish within the timeout period.");
             }
         } catch (InterruptedException e) {
             Thread.currentThread().interrupt();
             System.out.println("Interrupted while waiting for virtual threads.");
         }

     }

 }
