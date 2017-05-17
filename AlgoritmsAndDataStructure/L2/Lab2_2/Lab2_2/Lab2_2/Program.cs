using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Diagnostics;
using System.Threading;

namespace Lab_2_2
{
    class Program
    {
        public static Random rand = new Random();

        // O(n log(n))
        public static void sortingMethod(List<int> arrays, int start, int end)
        {
            int i = start, j = end;

            int searchSymbol = arrays[(start + end) / 2];

            while (i <= j)
            {
                while (arrays[i].CompareTo(searchSymbol) < 0)
                {
                    i++;
                }

                while (arrays[j].CompareTo(searchSymbol) > 0)
                {
                    j--;
                }

                if (i <= j)
                {
                    int tmp = arrays[i];
                    arrays[i] = arrays[j];
                    arrays[j] = tmp;

                    i++;
                    j--;
                }
            }

            if (start < j)
            {
                sortingMethod(arrays, start, j);
            }

            if (i < end)
            {
                sortingMethod(arrays, i, end);
            }
        }

        static void Main(string[] args)
        {
            int numberOfArrays;
            int sizeOfArray;
            int maxRandom = 100;

            List<List<int>> lisOfLists = new List<List<int>>();
            List<int> arrays = new List<int>();
            List<int> currentArray;

            Console.Write("Size of array:  ");
            sizeOfArray = Convert.ToInt32(Console.ReadLine());
            Console.Write("Number of arrays:  ");
            numberOfArrays = Convert.ToInt32(Console.ReadLine());
            
            for (int i = 0; i < numberOfArrays; i++)
            {
                currentArray = new List<int>();
                currentArray.Clear();

                for (int j = 0; j < sizeOfArray; j++)
                {
                    currentArray.Add(rand.Next(0, maxRandom));
                }

                currentArray.Sort();
                lisOfLists.Add(currentArray);
            }

            for (int i = 0; i < numberOfArrays; i++)
            {
                arrays = arrays.Concat(lisOfLists[i]).ToList();

                Console.WriteLine("\nArray number " + (i + 1));

                foreach (int number in lisOfLists[i])
                {
                    Console.Write(number + " ");
                }

                Console.WriteLine();
            }

            Console.WriteLine("\nBefore sorting");

            foreach (int number in arrays)
            {
                Console.Write(number + " ");
            }

            sortingMethod(arrays, 0, arrays.Count - 1);

            Console.WriteLine("\n\nAfter sorting");

            foreach (int number in arrays)
            {
                Console.Write(number + " ");
            }
            
            Console.ReadKey();
        }
    }
}
