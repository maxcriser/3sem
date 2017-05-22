import java.awt.*;

public class StrictBeep {

    volatile public static boolean flag = false;
    volatile public static int countBeeps = 3;
    volatile public static int count = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {
                    while (!flag) ;
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    someMethod("1st");
                    flag = false;
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    while (flag) ;
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    someMethod("2nd");
                    flag = true;
                }
            }
        });

        t1.start();
        t2.start();
    }

    public static void someMethod(final String threadName) {
        if(countBeeps > count) {
            System.out.println(threadName + " thread...");
            java.awt.Toolkit tk = Toolkit.getDefaultToolkit();
            tk.beep();
            count++;
        }
    }
}