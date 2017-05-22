using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Diagnostics;

namespace Scheduling
{
    public class Job
    {
        public int ExecuteTime;
        private static int idCounter = 0;
        public int Id;
        
        public Job(int executeTime)
        {
            ExecuteTime = executeTime;
            Id = ++idCounter;
        }
    }
}
