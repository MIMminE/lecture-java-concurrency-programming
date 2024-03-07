package chapter10;

import java.util.concurrent.Executor;


public class SyncExecutorExample {

    public static void main(String[] args) {
        Executor syncExecutor = new SyncExecutor();

        syncExecutor.execute(() -> {
            System.out.println(Thread.currentThread().getName() + " : 동기 작업 1 수행 중 ...!");

            // 작업

            System.out.println(Thread.currentThread().getName() + " : 동기 작업 1 완료");
        });

        syncExecutor.execute(() -> {
            System.out.println(Thread.currentThread().getName() + " : 동기 작업 2 수행 중 ...!");

            System.out.println(Thread.currentThread().getName() + " : 동기 작업 2 완료");
        });

    }


    static class SyncExecutor implements Executor {

        @Override
        public void execute(Runnable runnable) {
            runnable.run();
        }
    }
}
