class PetersonBeep {

    private static boolean[] in = {false, false};
    private static volatile boolean turn = false;

    public static void main(String[] args) {
        Task1Petersen(3);
        Task2Petersen(3);
    }

    private static void Task1Petersen(int a) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Petersen.EnterRegion(0);
                    System.out.println("Task1Petersen - > Enter in critical section");
                    System.out.println("Task1Petersen - > method");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Task1Petersen - > Leave from critical section");
                    turn = true;
                    Petersen.LeaveRegion(0);
                }
            }
        });
    }

    private static void Task2Petersen(int a) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Petersen.EnterRegion(1);
                    System.out.println("Task2Petersen - > Enter in critical section");
                    System.out.println("Task2Petersen - > method");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Task2Petersen - > Leave from critical section");
                    turn = true;
                    Petersen.LeaveRegion(1);
                }
            }
        });
    }
}