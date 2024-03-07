package chapter10.exam03;

import java.util.concurrent.*;

public class RunnableExample {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);


        Callable<Integer> callableTask = () -> {
            System.out.println(Thread.currentThread().getName() + " : Callable 작업 수행!");

            return 42;
        };

        Future<Integer> future = executorService.submit(callableTask);
        Integer integer;
        try {
            integer = future.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Callable 결과 반환 값 : " + integer);
        executorService.shutdown();
    }
}
