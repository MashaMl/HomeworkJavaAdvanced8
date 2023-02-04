package Task2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread main = Thread.currentThread();
        main.setName("Main");
        Thread first = new Thread(new First());
        first.setName("First");
        Thread second = new Thread(new Second());
        second.setName("Second");

        first.start();
        second.start();
        for(int i = 0; i < 5; ++i) {
            Thread.sleep(500);
            System.out.println(Thread.currentThread().getName() + " is running " + i);
        }
        System.out.println(Thread.currentThread().getName() + " is finished");

    }
}

class First extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 5; ++ i) {
            try {
                sleep(500);
                System.out.println(Thread.currentThread().getName() + " is running " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " is finished");
    }
}

class Second extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 5; ++i) {
            try {
                sleep(500);
                System.out.println(Thread.currentThread().getName() + " is running " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println(Thread.currentThread().getName() + " is finished");
    }
}


