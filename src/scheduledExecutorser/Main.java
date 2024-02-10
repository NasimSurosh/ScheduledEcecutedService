package scheduledExecutorser;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

  public static void main(String[] args) {
    
    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    
    Runnable delayTask = new Runnable() {

      @Override
      public void run() {
        
        System.out.println("Delayed task.");
        
      }
    };

    executor.schedule(delayTask, 2, TimeUnit.SECONDS);
    
    Runnable repeatedTask = new Runnable() {

      @Override
      public void run() {
        
        System.out.println("Repeated task.");
      }
      
    };
    executor.scheduleAtFixedRate(repeatedTask, 0, 5, TimeUnit.SECONDS);
    
    
    try {
      Thread.sleep(15000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    executor.shutdown();
    try {
      executor.awaitTermination(1, TimeUnit.HOURS);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
