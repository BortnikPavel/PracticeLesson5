package com.bortnikpp;

import com.bortnikpp.math.Cub;
import com.bortnikpp.math.Simple;
import com.bortnikpp.math.Square;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Consumer[] consumers = { new Consumer(), new Consumer() };
        int[] arr = {5, 6, 7};
        Cub cub = new Cub(arr, consumers);
        Square square = new Square(arr, consumers);
        Simple simple = new Simple(arr, consumers);

        simple.start();
        square.start();
        cub.start();

        simple.join();
        square.join();
        cub.join();

        System.out.println("Result: " + consumers[0].getSum());
    }
}
