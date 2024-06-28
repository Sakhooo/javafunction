package kz.cuncurent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ConcurrentDemo {
  public static void main(String[] args) throws InterruptedException, ExecutionException {

    int x = 1337;
    Future<Integer> f(x)





    exect2();


    exect1();

  }

  private static void exect2() throws InterruptedException, ExecutionException {
    ExecutorService service = Executors.newFixedThreadPool(2);

    int x = 1337;
    Future<Integer> f = service.submit(() -> f(x));
    Future<Integer> g = service.submit(() -> g(x));
    System.out.println(g.get() + f.get());
    service.shutdown();
  }

  private static void exect1() throws InterruptedException {
    int x = 1337;

    Result result = new Result();
    Thread thread = new Thread(() -> {
      result.left = f(x);
    });
    Thread thread1 = new Thread(() -> {
      result.right = g(x);
    });
    thread.start();
    thread1.start();
    thread.join();
    thread1.join();
    System.out.println(result.left + result.right);
  }

  private static void extracted() {
    long sum = 0;
    long[] status = new long[1_000_000];
    for (int i = 0; i < 1_000_000; i++) {
      sum+= status[i];
    }
    System.out.println();
  }


//  public static Future<Integer> f1(int x) {
//    return new Future<Integer>() {
//    };
//  }


  public static int f(int x) {
      int sum = 0;
      int[] status = new int[x];
      for (int i = 0; i < x; i++) {
        sum+= i;
      }
      return sum;
    }

  public static int g(int x) {
    int sum = 0;
    int[] status = new int[x];
    for (int i = 0; i < x; i++) {
      sum+= i;
    }
    return sum;
  }





}
