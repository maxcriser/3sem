using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Scheduling
{
    public partial class MainForm : Form
    {
        private QueueScheduler scheduler;
        public static List<Job> Jobs = new List<Job>();
        private int defaultExecuteTime = 2000;

        public MainForm()
        {
            InitializeComponent();

            jobCB.Enabled = true;
            jobCountTB.Enabled = false;
            executeButton.Enabled = true;
            suspendButton.Enabled = false;
            executeTimeTB.Enabled = false;
            Jobs.Add(new Job(defaultExecuteTime));
            Jobs.Add(new Job(defaultExecuteTime));
            jobCB.Items.Add("1");
            jobCB.Items.Add("2");
            jobCountTB.Text = Jobs.Count.ToString();
            scheduler = new QueueScheduler(Jobs);
            scheduler.CurrentJobChanged += () =>
            {
                currentJobTB.Invoke((Action)delegate
                {
                    currentJobTB.Text = scheduler.CurrentJob.ToString();
                });
            };
            scheduler.JobsEnded += () =>
            {
                executeButton.Invoke((Action)delegate
                {
                    executeButton.Enabled = true;
                });
                suspendButton.Invoke((Action)delegate
                {
                    suspendButton.Enabled = false;
                });
                statusTB.Invoke((Action)delegate
                {
                    statusTB.Text = "JOBS ENDED";
                });
                foreach(Job job in Jobs){
                    scheduler.AddJob(job);
                }
            };
        }

        private void initQueue()
        {
            foreach (Job job in Jobs)
            {
                scheduler.AddJob(job);
            }
        }

        private void addJobButton_Click(object sender, EventArgs e)
        {
            FormAddJob form = new FormAddJob();            
            form.FormClosed += (object obj, FormClosedEventArgs ea) =>
            {
                refreshUI();
                scheduler.AddJob(Jobs[Jobs.Count - 1]);
            };
            form.Show(this);
        }

        public void refreshUI()
        {
            jobCountTB.Text = Jobs.Count.ToString();
            jobCB.Items.Add(Jobs.Count.ToString());
        }

        private void jobCB_SelectedIndexChanged(object sender, EventArgs e)
        {
            executeTimeTB.Text = Jobs[jobCB.SelectedIndex].ExecuteTime.ToString();
        }

        private void executeButton_Click(object sender, EventArgs e)
        {
            addJobButton.Enabled = false;
            executeButton.Enabled = false;
            suspendButton.Enabled = true;
            statusTB.Text = "EXECUTING";            
            scheduler.Execute();
        }

        private void suspendButton_Click(object sender, EventArgs e)
        {
            addJobButton.Enabled = true;
            executeButton.Enabled = true;
            suspendButton.Enabled = false;
            statusTB.Text = "SUSPENDED";
            scheduler.Suspend();
        }
    }
}
