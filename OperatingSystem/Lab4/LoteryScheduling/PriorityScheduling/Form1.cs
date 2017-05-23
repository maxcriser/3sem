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
        public List<int> allTickets;
        Random random = new Random();
        double startTimeThread = 0;

        [DllImport("kernel32.dll", SetLastError = true)]
        [return: MarshalAs(UnmanagedType.Bool)]
        static extern bool AllocConsole();

        public void firstFillingGrid()
        {
            grid.Rows.Add("", "", "", "", "", "", "", "", "", "");
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
            allTickets = new List<int>();
            allTickets.Clear();
            processes.Clear();

            for (int i = 0; i < 10; i++)
            {
                String runtime = grid.Rows[0].Cells[i].FormattedValue.ToString();
                if (!runtime.Equals(""))
                {
                    List<int> tickets = new List<int>();

                    for (int j = 1; j < grid.Rows.Count; j++)
                    {
                        String number = grid.Rows[j].Cells[i].FormattedValue.ToString();
                        if (!number.Equals(""))
                        {
                            int x = Int32.Parse(number);
                            tickets.Add(x);
                            allTickets.Add(x);
                        }
                    }

                    Process prc = new Process(Int32.Parse(runtime), tickets, i + 1);
                    processes.Add(prc);
                }
            }

            if (processes.Count != 0)
            {
                Run(processes);
            }
        }

        public void Run(List<Process> list)
        {
            thr2 = new Thread(() =>
            {
                Console.Clear();

                while (allTickets.Count != 0 && allow)
                {
                    int winIndex = random.Next(0, allTickets.Count);
                    Console.WriteLine(winIndex + " winIndex...");
                    int winNumber = allTickets[winIndex];
                    Console.WriteLine(winNumber + " winNumber...");
                    allTickets.RemoveAt(winIndex);

                    for (int i = 0; i < list.Count; i++)
                    {
                        if (list[i].canPlay & list[i].isWinner(winNumber) && allow)
                        {
                            Thread.Sleep(list[i].getRuntime());
                            Console.WriteLine(list[i].getId() + " EXECUTED...");
                            list[i].setAlreadyRun();
                            break;
                        }

                        if(list[i].isWinner(winNumber) && !list[i].canPlay)
                        {
                            Console.WriteLine(list[i].getId() + " already run...");
                        }
                    }
                }
                double endTime = (DateTime.Now.Millisecond + (DateTime.Now.Second * 1000)) - startTimeThread;
                Console.WriteLine("End Time:" + endTime);
            });

            thr2.Start();
        }

        private void stopButton_Click(object sender, EventArgs e)
        {
            if (thr2 != null)
            {
                thr2.Abort();
                thr2.Join();
                thr2 = null;
            }

            allow = false;
            runButton.Enabled = true;
            stopButton.Enabled = false;
            Console.WriteLine("Stopped...");
        }
    }
}
