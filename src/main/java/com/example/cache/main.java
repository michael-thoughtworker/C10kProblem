package com.example.cache;

public class main {
    private static final int ARRAY_SIZE = 64 * 1024 * 1024;
    public static void main(String[] args){
        int[] array = new int[ARRAY_SIZE];
        long startTime = System.nanoTime();
        for (int i = 0, n = array.length; i < n; i++) {
            array[i] *= 3;
        }
        final long duration = System.nanoTime() - startTime;
        System.out.println(duration);

        array = new int[ARRAY_SIZE];
        startTime = System.nanoTime();
        for (int i = 0, n = array.length; i < n; i+=16) {
            array[i] *= 3;
        }
        final long duration1 = System.nanoTime() - startTime;
        System.out.println(duration1);
    }
}
