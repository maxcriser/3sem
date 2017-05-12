using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace Threads
{
    class Program
    {
        static void Main(string[] args)
        {
            int turn = 1;
            int x = 0;
            Console.WriteLine(x);

            Thread thr1 = new Thread(() =>
            {
                while (true)
                {
                    while (turn != 0) ;
                    x += 1;
                    Console.WriteLine(x);

                    //critical_region();
                    turn = 1;
                    //noncritical_region();
                }
            });

            while (true)
            {
                while (turn != 1) ;
                x += 1;
                Console.WriteLine(x);

                //critical_region();
                turn = 0;
                //noncritical_region();
            }
            Console.ReadKey();
        }
    }
}
