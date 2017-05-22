using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Diagnostics;

namespace Scheduling
{
    class QueueScheduler
    {
        private delegate void RunMachine(int time);
        private Stopwatch watch;
        private RunMachine run;
        private Queue<Job> jobsQueue = new Queue<Job>();
        private Job currentJob = null;
        public int CurrentJob = 0;
        private Thread controlThread;
        public delegate void OnCurrentJobChanged();
        public delegate void OnJobsEnded();
        public event OnCurrentJobChanged CurrentJobChanged;
        public event OnJobsEnded JobsEnded;

        public QueueScheduler(List<Job> jobs)
        {
            foreach (Job job in jobs)
            {
                AddJob(job);
            }
            run = (int executeTime) => {
                this.watch = Stopwatch.StartNew();
                while (watch.ElapsedMilliseconds < executeTime);
            };
        }

        public void Execute()
        {
            if (currentJob != null)
            {
                currentJob.JobThread.Resume();
                watch.Start();
            }
            else
            {
                controlThread = new Thread(() =>
                {
                    while (jobsQueue.Count != 0)
                    {
                        currentJob = jobsQueue.Dequeue();
                        CurrentJob += 1;
                        CurrentJobChanged();
                        currentJob.JobThread.Start();
                        while (currentJob.JobThread.IsAlive) ;
                    }
                    currentJob = null;
                    CurrentJob = 0;
                    JobsEnded();
                });
                controlThread.Start();
            }
        }
        
        public void Suspend()
        {
            if (currentJob != null)
            {
                if (currentJob.JobThread.IsAlive)
                {
                    currentJob.JobThread.Suspend();
                    watch.Stop();
                }
            }
        }

        public void AddJob(Job job)
        {
            job.JobThread = new Thread(() =>
            {
                run(job.ExecuteTime);
            });
            jobsQueue.Enqueue(job);
        }
    }
}
