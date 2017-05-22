using Scheduling;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace RoundRobinScheduling
{
    public partial class MainForm : Form
    {
        private RoundRobinScheduler scheduler;
        public static List<Job> DefaultJobs = new List<Job>();
        public static List<Job> UserJobs = new List<Job>();
        private List<Job> Jobs = new List<Job>();
        private int defaultExecuteTime = 7000;
        private int defaultQuantum = 3000;

        public MainForm()
        {
            InitializeComponent();
            jobCB.Enabled = true;
            jobCountTB.Enabled = false;
            executeButton.Enabled = true;
            suspendButton.Enabled = false;
            executeTimeTB.Enabled = false;
            DefaultJobs.Add(new Job(defaultExecuteTime));
            DefaultJobs.Add(new Job(defaultExecuteTime));
            Jobs.Add(DefaultJobs[0]);
            Jobs.Add(DefaultJobs[1]);
            jobCB.Items.Add("1");
            jobCB.Items.Add("2");
            jobCountTB.Text = DefaultJobs.Count.ToString();
            quantumTB.Text = defaultQuantum.ToString();
            scheduler = new RoundRobinScheduler(DefaultJobs, defaultQuantum);
            scheduler.CurrentJobChanged += () =>
            {
                currentJobTB.Invoke((Action) delegate
                {
                    currentJobTB.Text = "Job #" + scheduler.CurrentJob.Id.ToString();
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
                quantumTB.Invoke((Action)delegate
                {
                    quantumTB.Enabled = true;
                });
            };
        }
        
        private void initQueue()
        {
            try {
                int time = Int32.Parse(quantumTB.Text);
                if (time <= 0) throw new Exception();
                scheduler.ExecutionQuantum = time;
                scheduler.AddJobs(DefaultJobs);
            } catch(Exception e){
                MessageBox.Show(this, "Positive integer required!", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void addJobButton_Click(object sender, EventArgs e)
        {
            FormAddJob form = new FormAddJob();            
            form.FormClosed += (object obj, FormClosedEventArgs ea) =>
            {
                foreach (var job in UserJobs)
                {
                    Jobs.Add(job);
                }
                scheduler.AddJobs(UserJobs);
                refreshUI();
                UserJobs = new List<Job>();
            };
            form.Show(this);
        }

        public void refreshUI()
        {
            int newCount = Jobs.Count;
            jobCountTB.Text = newCount.ToString();
            jobCB.Items.Clear();
            for (int i = 0; i < newCount; i++)
            {
                jobCB.Items.Add((i + 1).ToString());
            }
        }

        private void jobCB_SelectedIndexChanged(object sender, EventArgs e)
        {
            executeTimeTB.Text = Jobs[jobCB.SelectedIndex].ExecuteTime.ToString();
        }

        private void executeButton_Click(object sender, EventArgs e)
        {
            if (statusTB.Text.Equals("JOBS ENDED"))
            {
                initQueue();
            }
            addJobButton.Enabled = false;
            executeButton.Enabled = false;
            suspendButton.Enabled = true;
            quantumTB.Enabled = false;
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

        private void MainForm_FormClosing(object sender, FormClosingEventArgs e)
        {
            scheduler.Abort();
        }
    }
}
