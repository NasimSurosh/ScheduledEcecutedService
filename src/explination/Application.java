package explination;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Application {

  public static void main(String[] args) {
    
    ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
    
    Runnable repeatedTask = new Runnable() {

      @Override
      public void run() {
        System.out.println("Beep");
        
      }
      
    };
    
    Runnable singleTask = new Runnable() {

      @Override
      public void run() {
        System.out.println("One-time task");
        
      }
      
    };
    
    // schedule the repeated task to run every 2 seconds with two seconds delay.
    executor.scheduleAtFixedRate(repeatedTask, 2, 2, TimeUnit.SECONDS);
    
    
    executor.schedule(singleTask, 15, TimeUnit.SECONDS);
    
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    executor.shutdown();
    try {
      executor.awaitTermination(1, TimeUnit.HOURS);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }

}
