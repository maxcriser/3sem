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
            int N = 10000;
            int K = 1000;
            double[] a = new double[N];
            double[] b = new double[N];
           
            Console.WriteLine("Start: " + DateTime.Now.Millisecond.ToString());
            for (int i = 0; i < a.Length; i++)
            {
                for (int j = 0; j < K; j++)
                {
                    b[i] += Math.Pow(a[i], 1.789);
                }
            }
            Console.WriteLine("Stop: " + DateTime.Now.Millisecond.ToString());
            Console.ReadKey();
        }
    }
}
