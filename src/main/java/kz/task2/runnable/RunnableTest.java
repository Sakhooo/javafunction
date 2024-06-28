package kz.task2.runnable;

public class RunnableTest {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        });

        Thread t2 = new Thread(() -> System.out.println("world"));

    }
}
