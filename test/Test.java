package test;

import java.util.Random;

public class Test {

    private static final int STUDENT_NUMBER = 19204615;
    private static final int NUM_RUNS = 10;

    public static void main(String[] args) {
        int[] N = {10, 50, 100, 200, 500, 1000, 2000, 5000, 10000, 50000};

        System.out.printf("%10s %20s %20s\n", "n", "average(height)", "average(diameter)");

        for (int i = 0; i < N.length; i++) {
            int sumHeight = 0;
            int sumDiameter = 0;

            for (int j = 0; j < NUM_RUNS; j++) {
                Random rnd = new Random();
                rnd.setSeed(STUDENT_NUMBER + j); // Use a different seed for each run
                LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<>();
                bt.constructRandom(N[i]);
                sumHeight += bt.findHeight(bt.root);
                sumDiameter += bt.findDiameter(bt.root);
            }

            double avgHeight = (double) sumHeight / NUM_RUNS;
            double avgDiameter = (double) sumDiameter / NUM_RUNS;

            System.out.printf("%10d %15.3f %15.3f\n", N[i], avgHeight, avgDiameter);
        }
    }
}
