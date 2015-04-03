package dj.multithread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class MyThreadPool extends ThreadPoolExecutor
{

  public MyThreadPool (int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue)
  {
    super (corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    // TODO Auto-generated constructor stub
  }



  public MyThreadPool (int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory)
  {
    super (corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    // TODO Auto-generated constructor stub
  }



  public MyThreadPool (int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler)
  {
    super (corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    // TODO Auto-generated constructor stub
  }



  public MyThreadPool (int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler)
  {
    super (corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    // TODO Auto-generated constructor stub
  }



  /**
   * @param args
   */
  public static void main (String[] args)
  {
    // TODO Auto-generated method stub

  }

}
