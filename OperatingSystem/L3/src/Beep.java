import java.awt.*;

public class Beep {

    volatile private static boolean flag = false;
    volatile private static int countBeeps = 2;
    volatile private static int count = 0;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    while (!flag) ;
                    someMethod("1st");
                    flag = false;
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    while (flag) ;
                    someMethod("2nd");
                    flag = true;
                }
            }
        }).start();
    }

    private static void someMethod(final String threadName) {
        if(countBeeps < count) {
            System.out.println(threadName + " thread...");
            java.awt.Toolkit tk = Toolkit.getDefaultToolkit();
            tk.beep();
            count++;
        }
    }
}