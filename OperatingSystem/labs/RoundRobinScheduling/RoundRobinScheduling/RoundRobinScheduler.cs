using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Diagnostics;
using RoundRobinScheduling;

namespace Scheduling
{
    class RoundRobinScheduler
    {
        private Queue<JobAction> actionQueue = new Queue<JobAction>();
        public Job CurrentJob {get; private set;}
        public delegate void OnCurrentJobChanged();
        public delegate void OnJobsEnded();
        public event OnCurrentJobChanged CurrentJobChanged;
        public event OnJobsEnded JobsEnded;
        public int ExecutionQuantum;
        private Thread executionThread;

        public RoundRobinScheduler(List<Job> jobs, int quantum)
        {
            ExecutionQuantum = quantum;
            CurrentJob = null;
            AddJobs(jobs);
            executionThread = null;
        }

        public void processJobs(List<JobAction> jobActions)
        {
            List<JobAction> croppedJobs = new List<JobAction>();
            foreach (JobAction jobAction in jobActions)
            {
                if (jobAction.ExecutionTime > ExecutionQuantum)
                {
                    actionQueue.Enqueue(new JobAction(jobAction.RelatedJob, ExecutionQuantum));
                    croppedJobs.Add(new JobAction(jobAction.RelatedJob, jobAction.ExecutionTime - ExecutionQuantum));
                }
                else
                {
                    actionQueue.Enqueue(new JobAction(jobAction.RelatedJob, jobAction.ExecutionTime));
                }
            }
            if (croppedJobs.Count != 0)
            {
                processJobs(croppedJobs);
            }
        }

        private void createExecutionThread()
        {
            executionThread = new Thread(() =>
            {
                while (actionQueue.Count != 0)
                {
                    JobAction action = actionQueue.Dequeue();
                    CurrentJob = action.RelatedJob;
                    CurrentJobChanged();
                    Thread.Sleep(action.ExecutionTime);
                }
                executionThread = null;
                JobsEnded();
            });
        }

        public void Execute()
        {
            if (executionThread == null)
            {
                createExecutionThread();
                executionThread.Start();
            }
            if (executionThread.ThreadState == System.Threading.ThreadState.Suspended)
            {
                executionThread.Resume();
            } 
        }
        
        public void Suspend()
        {
            executionThread.Suspend();
        }

        public void AddJobs(List<Job> jobs)
        {
            List<JobAction> jobActions = new List<JobAction>();
            foreach (Job job in jobs)
            {
                jobActions.Add(new JobAction(job, job.ExecuteTime));
            }
            processJobs(jobActions);
        }

        public void Abort()
        {
            if (executionThread != null)
            {
                executionThread.Abort();
                executionThread = null;
            }
        }
    }
}
