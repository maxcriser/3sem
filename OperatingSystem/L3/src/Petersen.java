class Petersen {
    private static int turn;
    private static boolean[] interested = new boolean[2];

    static void EnterRegion(int thread) {
        int other;
        other = 1 - thread;
        interested[thread] = true;
        turn = thread;
        while (turn == thread && interested[other]) ; // активное ожидание
    }

    static void LeaveRegion(int thread) {
        interested[thread] = false;
    }
}