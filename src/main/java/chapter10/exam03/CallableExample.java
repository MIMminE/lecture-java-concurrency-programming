package chapter10.exam03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallableExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Runnable runnableTask = () -> {
            System.out.println(Thread.currentThread().getName()+" : 작업 수행!");
        };

        executorService.execute(runnableTask);
        executorService.execute(runnableTask);
        executorService.shutdown();
    }
}
