using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab2OS
{
    class Petersen
    {
        public static int turn;
        public static bool[] interested = new bool[2];

        public static void EnterRegion(int thread)
        {
            int other;
            other = 1 - thread;
            interested[thread] = true;
            turn = thread;
            while (turn == thread && interested[other]) ; // активное ожидание
        }

        public static void LeaveRegion(int thread)
        {
            interested[thread] = false;
        }
    }
}