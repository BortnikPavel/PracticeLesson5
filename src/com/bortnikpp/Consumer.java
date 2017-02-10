package com.bortnikpp;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by admin on 10.02.2017.
 */
public class Consumer {
        private volatile static int sum = 0;
        private volatile boolean lockCub = false;
        private volatile boolean lockSquare = false;
        private volatile boolean lockSimple = false;

        public void mes(int cub, int square, int simple) {
            if (cub != 0) {
                lockAndAdd(lockCub, cub);
            } else if (square != 0) {
                lockAndAdd(lockSquare, square);
            } else if (simple != 0) {
                lockAndAdd(lockSimple, simple);
            }
        }

        public int getSum() {
            return sum;
        }

        private void lockAndAdd(boolean lock, int value) {
            while (lock) {
                Thread.yield();
            }
            if(!lock) {
                lock = true;
                sum += value;
                System.out.println("Current value: " + sum);
                lock = false;
            }
        }
}
