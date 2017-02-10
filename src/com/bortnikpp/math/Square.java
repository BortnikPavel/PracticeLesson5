package com.bortnikpp.math;

import com.bortnikpp.Consumer;

/**
 * Created by admin on 10.02.2017.
 */
public class Square extends Thread{
    private final int[] arr;
    private final Consumer[] consumers;

    public Square(int[] arr, Consumer[] consumers) {
        this.arr = arr;
        this.consumers = consumers;
    }

    @Override
    public void run() {
        for (int i = 0; i < arr.length; i++) {
            int sq = arr[i] * arr[i];
            consumers[i%2].mes(0, sq, 0);
        }
    }
}
