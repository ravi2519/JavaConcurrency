import java.util.Arrays;



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

class Philosopher implements Runnable {

  private Object leftfork;
  private Object rightfork;

  public Philosopher(Object leftfork, Object rightfork ) {
    this.leftfork = leftfork;
    this.rightfork = rightfork;
  }

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

class Main {

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

      if( j == philosphers.length - 1){
        philosphers[j] = new Philosopher(rightfork, leftfork);
      } else {
        philosphers[j] = new Philosopher(leftfork, rightfork);
      }

      Thread t = new Thread( philosphers[j], "Philosopher " + ( j + 1 ) );
      t.start();
      
    }
    
    
  }
}