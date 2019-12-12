package com.java;

/**
 * thinking()
 * pick up the left fork
 * pick up the right fork
 * eat
 * put down right fork
 * put down left fork
 *
 * Not hungry any more back to thinking
 **/
public class Philosopher implements Runnable {

    private Object leftfork;
    private Object rightfork;

    public Philosopher(Object leftfork, Object rightfork ) {
        this.leftfork = leftfork;
        this.rightfork = rightfork;
    }

    @Override
    public void run() {

        try{
            while( true ) {
                System.out.println(Thread.currentThread().getName() + " : Thinking");

                Thread.sleep((int)Math.random() * 100);

                synchronized(this.leftfork) {
                    System.out.println(Thread.currentThread().getName() + " : Left Fork Picked");
                    synchronized(this.rightfork) {
                        System.out.println(Thread.currentThread().getName() + " : Right Fork Picked ");
                        System.out.println(Thread.currentThread().getName() + " : Eating");
                        Thread.sleep((int)Math.random() * 100);
                        System.out.println(Thread.currentThread().getName() + " : Right Fork Dropped ");
                    }
                    System.out.println(Thread.currentThread().getName() + " : Left Fork Dropped ");
                }
                System.out.println(Thread.currentThread().getName() + " : Back to Thinking");
                Thread.sleep((int)Math.random() * 100);
            }

        } catch( InterruptedException ie ) {
            Thread.currentThread().interrupt();
            return;
        }

    }

}
