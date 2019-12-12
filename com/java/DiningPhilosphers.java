package com.java;

public class DiningPhilosphers {

    public static void main(String[] args) {

        System.out.println("5 Philosphers on Table with 5 Forks - Thinking, Eating, Thinking .....");

        Philosopher[] philosphers = new Philosopher[5];
        Object[] forks = new Object[5];

        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Object();
        }

        for( int j = 0; j < philosphers.length; j++) {

            Object leftfork = forks[j];
            Object rightfork = forks[ (j+1) % forks.length ];

            if( j == philosphers.length - 1 ) {
                philosphers[j] = new Philosopher(rightfork, leftfork);
            } else {
                philosphers[j] = new Philosopher(leftfork, rightfork);
            }
            Thread t = new Thread( philosphers[j], "Philosopher " + ( j + 1 ) );
            t.start();

        }


    }
}
