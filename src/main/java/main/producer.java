/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author Emil
 */
public class producer extends Thread {

    private final BlockingQueue a;
    public static ArrayList array = new ArrayList();
    private int worker;

    public producer(BlockingQueue a) {
        this.a = a;
    }

    @Override
    public void run() {
        worker = (int) getint(a);
        while (worker != 0&&!a.isEmpty()) {
            array.add(this.fib(worker));
            worker = (int) getint(a);
            
        }

    }
    private static synchronized int getint(BlockingQueue a){
        if(!a.isEmpty()){
        return (int) a.poll();
        }
        else{
            return 0;
        }
    }

    private long fib(long n) {
        if ((n == 0) || (n == 1)) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

}
