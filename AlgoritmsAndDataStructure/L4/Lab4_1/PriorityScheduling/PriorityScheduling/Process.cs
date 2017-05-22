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
        public int priority;
        public int id;

        public Process(int runtime, int priority, int id)
        {
            this.runtime = runtime;
            this.priority = priority;
            this.id = id;
        }

        public int getId()
        {
            return this.id;
        }

        public int getRuntime()
        {
            return this.runtime;
        }

        public int getPriority()
        {
            return this.priority;
        }
    }
}
