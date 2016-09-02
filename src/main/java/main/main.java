/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emil
 */
public class main {

    static BlockingQueue str;

    public static void main(String[] args) {

        str = new ArrayBlockingQueue(8, false, fillout());
        producer p1 = new producer(str);
        producer p2 = new producer(str);
        producer p3 = new producer(str);
        producer p4 = new producer(str);
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        try {
            p1.join();
            p2.join();
            p3.join();
            p4.join();
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        ArrayList arr = producer.array;
        for (Object object : arr) {
            System.out.println((long) object);
        }
    }
    private static ArrayList fillout(){
        ArrayList b = new ArrayList<>();
        b.add(4);
        b.add(5);
        b.add(8);
        b.add(12);
        b.add(21);
        b.add(22);
        b.add(34);
        b.add(35);
        
        return b;
    }

}
