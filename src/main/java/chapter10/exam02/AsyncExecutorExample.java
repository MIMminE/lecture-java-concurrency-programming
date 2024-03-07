package chapter10.exam02;

import java.util.concurrent.Executor;

public class AsyncExecutorExample {
    public static void main(String[] args) {
        Executor asyncExecutor = new AsyncExecutor();

        asyncExecutor.execute(() -> {
            System.out.println(Thread.currentThread().getName() + " : 비동기 작업 1 수행 중 ...!");

            // 작업

            System.out.println(Thread.currentThread().getName() + " : 비동기 작업 1 완료");
        });

        asyncExecutor.execute(() -> {
            System.out.println(Thread.currentThread().getName() + " : 비동기 작업 2 수행 중 ...!");

            System.out.println(Thread.currentThread().getName() + " : 비동기 작업 2 완료");
        });

    }

    // 이 부분이 스레드 풀이라고 생각할 수 있음
    // 즉, 메인 스레드에서 스레드를 직접 생성하는 방식보다는
    // 작업(Runnable)을 생성하여 스레드 풀의 작업 큐에 전달하는 방식으로
    // 하는 것이 Executor 프레임워크가 제공해주는 안정성을 적용받는 것이다.
    static class AsyncExecutor implements Executor {

        @Override
        public void execute(Runnable runnable) {
            new Thread(runnable).start();
        }
    }
}
