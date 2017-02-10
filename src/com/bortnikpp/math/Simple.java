package com.bortnikpp.math;

import com.bortnikpp.Consumer;

/**
 * Created by admin on 10.02.2017.
 */
public class Simple extends Thread {
    private int[] arr;
    private Consumer[] consumers;

    public Simple(int[] arr, Consumer[] consumers) {
        this.arr = arr;
        this.consumers = consumers;
    }

    @Override
    public void run() {
        for (int i = 0; i < arr.length; i++) {
            consumers[i%2].mes(0, 0, arr[i]);
        }
    }
}
