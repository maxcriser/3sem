using Scheduling;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RoundRobinScheduling
{
    class JobAction
    {
        public Job RelatedJob { get; private set; }
        public int ExecutionTime { get; private set; }

        public JobAction(Job job, int time)
        {
            RelatedJob = job;
            ExecutionTime = time;
        }
    }
}
