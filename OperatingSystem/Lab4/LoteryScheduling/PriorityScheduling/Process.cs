using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PriorityScheduling
{
    public class Process
    {
        public int runtime;
        public int id;
        public List<int> tickets;
        public Boolean canPlay = true;

        public Process(int runtime, List<int> tickets, int id)
        {
            this.runtime = runtime;
            this.id = id;
            this.tickets = tickets;
        }

        public Boolean isCanPlay()
        {
            return this.canPlay;
        }

        public void setAlreadyRun()
        {
            this.canPlay = false;
        }

        public Boolean isWinner(int number)
        {
            if (this.tickets != null)
            {
                return this.tickets.Contains(number);
            } else
            {
                return false;
            }
        }

        public List<int> getTikets()
        {
            return this.tickets;
        }

        public int getId()
        {
            return this.id;
        }

        public int getRuntime()
        {
            return this.runtime;
        }
    }
}
