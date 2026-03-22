import service.SecondThreadExample;
import service.ThreadExample;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() throws InterruptedException {
    int threadCount = 10;

    long threadTime = testExtendsThread(threadCount);
    long runnableTime = testImplementsRunnable(threadCount);

    IO.println("Extends Thread time: " + threadTime + " ms");
    IO.println("Implements Runnable time: " + runnableTime + " ms");
}

    long testExtendsThread(int threadCount) throws InterruptedException {
        List<ThreadExample> threads = new ArrayList<>();

        long start = System.nanoTime();

        for (int i = 0; i < threadCount; i++) {
            ThreadExample t = new ThreadExample();
            threads.add(t);
            t.start();
        }

        for (ThreadExample t : threads) {
            t.join();
        }

        long end = System.nanoTime();
        return (end - start) / 1_000_000;
    }

    long testImplementsRunnable(int threadCount) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        long start = System.nanoTime();

        for (int i = 0; i < threadCount; i++) {
            Thread t = new Thread(new SecondThreadExample());
            threads.add(t);
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }

        long end = System.nanoTime();
        return (end - start) / 1_000_000;
    }
