using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace Swapping
{
    class Program
    {
        private static int INTERVAL_TIME = 1000;
        private static int MAX_PAGES = 2;
        private static Random random = new Random();

        static void Main(string[] args)
        {
            int tick = 1;
            ClockCache cache = new ClockCache(MAX_PAGES);
            Timer timer = new Timer((object state) =>
            {
                Console.WriteLine("=====================");
                Console.WriteLine("Tick #" + tick);
                checkCache(cache);
                GC.Collect();
                tick++;
            }, null, 0, INTERVAL_TIME);
            Console.ReadLine();
            timer.Change(Timeout.Infinite, Timeout.Infinite);
            Console.ReadLine();
        }

        private static void RandomModify(Page page)
        {
            if (DoubleChoice())
            {
                Console.Write(" MODIFY");
                page.Modify();
            }    
        }

        private static void RandomRead(Page page)
        {
            if (DoubleChoice())
            {
                Console.Write(" READ");
                page.Read();
            }
        }

        private static bool DoubleChoice()
        {
            return random.Next() % 2 == 0;
        }

        private static void checkCache(ICache cache)
        {
            Page page = cache.GetRandomExistingPage();
            if (page != null)
            {
                Console.Write("[IN-MEMORY] " + page.Id + " " + page.GetClassAsString());
                RandomRead(page);
                RandomModify(page);
                Console.WriteLine();
            }
            if (DoubleChoice())
            {
                int id = random.Next(30);
                Console.WriteLine((cache.IsInCache(id) ? "[IN-MEMORY]" : "[EXTERNAL]") + " " + id);
                page = cache.GetPage(id);
            }
            cache.Live();
        }
    }
}
