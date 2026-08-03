import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Counter {
    int count = 0;

    public synchronized void increment() {
        count++;
    }
}

public class SynchronizedDemo {

    public static void main(String[] args) throws InterruptedException {

        
        Counter counter = new Counter();

        ExecutorService executor = Executors.newFixedThreadPool(20); // pool with 2 threads

        Runnable task = () -> {
            for (int i = 0; i < 100000; i++) {
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

    }
}