import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import jdk.crac.Context;
import jdk.crac.Core;
import jdk.crac.Resource;

public class CRaCRestore {
  private ScheduledExecutorService executor;
  private long startTime = System.currentTimeMillis();
  private int counter = 0;

  class CRaCRestoreResource implements Resource {
    @Override
    public void beforeCheckpoint(Context<? extends Resource> context) throws Exception {
      executor.shutdown();
      System.out.println("Handle checkpoint");
    }

    @Override
    public void afterRestore(Context<? extends Resource> context) throws Exception {
      System.out.println(this.getClass().getName() + " restore.");
      CRaCRestore.this.startTask();
    }
  }

  public static void main(String args[]) throws InterruptedException {
    CRaCRestore CRaC = new CRaCRestore();
    Core.getGlobalContext().register(CRaC.new CRaCRestoreResource());
    CRaC.startTask();
  }

  private void startTask() throws InterruptedException {
    executor = Executors.newScheduledThreadPool(1);
    executor.scheduleAtFixedRate(() -> {
      long currentTimeMillis = System.currentTimeMillis();
      System.out.println("Counter: " + counter + "(passed " + (currentTimeMillis - startTime) + " ms)");
      startTime = currentTimeMillis;
      counter++;
    }, 1, 1, TimeUnit.SECONDS);
    Thread.sleep(1000 * 30);
    executor.shutdown();
  }

}