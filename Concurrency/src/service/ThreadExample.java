package service;

/*
 * Author: M
 * Date: 22-Mar-26
 * Project Name: Concurrency
 * Description: beExcellent
 */
public class ThreadExample extends Thread{

    public void run() {
        long sum = 0;
        for (int i = 1; i <= 900_000_000; i++) {
            sum += i;
        }
    }
}
