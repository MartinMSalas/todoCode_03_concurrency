package service;

/*
 * Author: M
 * Date: 22-Mar-26
 * Project Name: Concurrency
 * Description: beExcellent
 */
public class SecondThreadExample implements Runnable {

    @Override
    public void run() {
        long sum = 0;
        for (int i = 1; i <= 900_000_000; i++) {
            sum += i;
        }
    }
}
