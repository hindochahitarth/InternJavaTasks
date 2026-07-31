class MyThread extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("Inside run() method");
            System.out.println("Current State: " + Thread.currentThread().getState());

            System.out.println("Thread is going to sleep...");
            Thread.sleep(2000);

            System.out.println("Thread woke up.");
            System.out.println("Current State: " + Thread.currentThread().getState());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ThreadLifeCycle {

    public static void main(String[] args) throws InterruptedException {

        MyThread t1 = new MyThread();

        System.out.println("State after object creation: " + t1.getState());

        t1.start();
        System.out.println("State after start(): " + t1.getState());

        Thread.sleep(500);
        System.out.println("State while sleeping: " + t1.getState());

        t1.join();

        System.out.println("State after completion: " + t1.getState());
    }
}