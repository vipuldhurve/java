package multiThreading.threads.create;

public class ThreadCreation {

    public static void main(String[] args) throws InterruptedException {
//        Thread Creation 1 : by passing an object to Thread class that implements runnable interface
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from " + Thread.currentThread().getName());
                System.out.println("New Worker thread priority is " + Thread.currentThread().getPriority());
            }
        });
        System.out.println("We are in thread: " + Thread.currentThread() + " before running thread1" );

        thread1.setName("New Worker thread");
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread1.start();

        thread1.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("A critical error happened in thread " + t.getName()
                        + " the error is: " + e.getMessage());
            }
        });

        System.out.println("We are in thread: " + Thread.currentThread() + " after running thread1" );

//        Thread Creation 2 : by extending Thread class
        Thread thread2 = new NewThread();
        thread2.start();
    }

    private static class NewThread extends Thread{
        @Override
        public void run(){
            System.out.println("Hello from New Thread " + Thread.currentThread().getName());
            System.out.println("New thread priority is " + Thread.currentThread().getPriority());
        }
    }
}
