using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading;
using System.Timers;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Runtime.InteropServices;

namespace PriorityScheduling
{
    public partial class Form1 : Form
    {
        public System.Windows.Forms.Timer timer = new System.Windows.Forms.Timer();
        public Boolean allow = true;
        public Thread thr2;
        double startTimeThread = 0;

        [DllImport("kernel32.dll", SetLastError = true)]
        [return: MarshalAs(UnmanagedType.Bool)]
        static extern bool AllocConsole();

        public void firstFillingGrid()
        {
            grid.Rows.Add("", "", "", "", "", "", "", "", "", "");
            grid.Rows.Add("", "", "", "", "", "", "", "", "", "");
        }

        public List<Process> sortListByPriority(List<Process> listProcess)
        {
            List<Process> pr = listProcess;

            for (int write = 0; write < pr.Count(); write++)
            {
                for (int sort = 0; sort < pr.Count() - 1; sort++)
                {
                    if (pr[sort].getPriority() < pr[sort + 1].getPriority())
                    {
                        Process temp = pr[sort + 1];
                        pr[sort + 1] = pr[sort];
                        pr[sort] = temp;
                    }
                }
            }

            return pr;
        }

        public Form1()
        {
            InitializeComponent();
            firstFillingGrid();
            AllocConsole();
        }

        private void runButton_Click(object sender, EventArgs e)
        {
            startTimeThread = DateTime.Now.Millisecond + (DateTime.Now.Second * 1000);

            allow = true;
            runButton.Enabled = false;
            stopButton.Enabled = true;

            List<Process> processes = new List<Process>();
            processes.Clear();

            for (int i = 0; i < 10; i++)
            {
                String runtime = grid.Rows[0].Cells[i].FormattedValue.ToString();
                String priority = grid.Rows[1].Cells[i].FormattedValue.ToString();

                if (!runtime.Equals("") && !priority.Equals(""))
                {
                    Process prc = new Process(Int32.Parse(runtime), Int32.Parse(priority), i + 1);
                    processes.Add(prc);
                }
            }

            if (processes.Count != 0)
            {
                processes = sortListByPriority(processes);
                Run(processes);
            }
        }

        public void Run(List<Process> list)
        {
            thr2 = new Thread(() =>
            {
                Console.Clear();

                for (int i = 0; i < list.Count(); i++)
                {
                    if (allow)
                    {
                        Thread.Sleep(list[i].getRuntime());
                        Console.WriteLine(list[i].getId() + " execute...");
                    }
                }

                double endTime = (DateTime.Now.Millisecond + (DateTime.Now.Second * 1000)) - startTimeThread;
                Console.WriteLine("End Time: " + endTime);
            });

            thr2.Start();
        }

        private void stopButton_Click(object sender, EventArgs e)
        {
            thr2.Abort();
            thr2.Join();
            thr2 = null;
            allow = false;
            runButton.Enabled = true;
            stopButton.Enabled = false;
            Console.WriteLine("Stopped...");
        }
    }
}
