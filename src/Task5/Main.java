package Task5;

public class Main {
    public static void main(String[] args) {
        First t1 = new First();
        Second t2 = new Second();
        t1.setThread(t2);
        t2.setThread(t1);
        t1.start();
        t2.start();

    }
}
class First extends Thread{
    Thread t1;
    public void setThread(Thread t1) { this.t1 = t1; }

    @Override
    public void run() {
        System.out.println("First Thread start");

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("First Thread interrupting");
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("We won't see finishing");
    }

}
class Second extends Thread{
    Thread t2;

    public void setThread(Thread t2) {this.t2 = t2; }

    @Override
    public void run() {
        System.out.println("Second Thread start");
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Second Thread Interrupting");
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("We won't see finishing");
    }
}
