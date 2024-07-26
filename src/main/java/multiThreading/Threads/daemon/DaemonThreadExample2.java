package multiThreading.Threads.daemon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DaemonThreadExample2 {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();

        List<MyThread> threads = new ArrayList<>(Arrays.asList(t1, t2, t3));

//        setting thread 1 as daemon
        t1.setDaemon(true);

//        starting threads
        for(MyThread t: threads){
            t.start();
        }
    }

    public static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.print(Thread.currentThread().getName() + " ");
            if(Thread.currentThread().isDaemon()){
                //checking for daemon thread
                System.out.println("Daemon thread working...");
            }else {
                System.out.println("Thread Working...");
            }
        }
    }
}
