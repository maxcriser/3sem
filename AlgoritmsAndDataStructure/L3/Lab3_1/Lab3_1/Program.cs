using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab3_1
{
    class Program
    {
        public static int gcd(int a, int b)
        {
            a = Math.Abs(a);
            b = Math.Abs(b);

            if (a == 0)
            {
                return b;
            }
            else if (b == 0)
            {
                return a;
            }
            else if (a == b)
            {
                return a;
            }
            else if (a % 2 == 0 && b % 2 == 0)
            {
                return 2 * gcd(a / 2, b / 2);
            }
            else if (a % 2 == 0 && b % 2 == 1)
            {
                return gcd(a / 2, b);
            }
            else if (a % 2 == 1 && b % 2 == 0)
            {
                return gcd(a, b / 2);
            }
            else if (a % 2 == 1 && b % 2 == 1)
            {
                if (a > b)
                {
                    return gcd((a - b) / 2, b);
                }
                else
                {
                    return gcd((b - a) / 2, a);
                }
            }
            else
            {
                return 0;
            }

        }


        static void Main(string[] args)
        {
            Console.Write("Input 'a':  ");
            int a = int.Parse(Console.ReadLine());
            Console.Write("Input 'b':  ");
            int b = int.Parse(Console.ReadLine());
            int result = gcd(a, b);
            Console.WriteLine("Result: " + result.ToString());
            Console.ReadKey();
        }
    }
}
