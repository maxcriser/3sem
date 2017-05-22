using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace Scheduling
{
    public class Job
    {
        public int ExecuteTime;
        public Thread JobThread;

        public Job(int executeTime)
        {
            ExecuteTime = executeTime;
        }        
    }
}
