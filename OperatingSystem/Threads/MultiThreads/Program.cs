using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace MultiThreads
{
    class Program
    {
        private static void calculate()
        {

        }

        static void Main(string[] args)
        {
            int N = 100000;
            int K = 10000;
            int countThreads = 4;

            double[] a = new double[N];
            double[] b = new double[N];

            Console.WriteLine("Start: " + DateTime.UtcNow.ToString("HH:mm:ss.fff", CultureInfo.InvariantCulture));

            for (int c = 0; c < countThreads; c++)
            {
                int start = c * N / countThreads;
                int end = 0;

                if (c == countThreads - 1)
                {
                    end = N;
                }
                else
                {
                    end = (c + 1) * N / countThreads;
                }

                Thread thr2 = new Thread(() =>
                {
                    for (int i = start; i < end; i++)
                    {
                        for (int j = 0; j < K; j++)
                        {
                            b[i] += Math.Pow(a[i], 1.789);
                        }
                    }
                });

                thr2.Start();

                if (c == countThreads - 1)
                {
                    thr2.Join();
                }
            }

            Console.WriteLine("Stop: " + DateTime.UtcNow.ToString("HH:mm:ss.fff", CultureInfo.InvariantCulture));

            Console.ReadKey();
        }
    }
}
