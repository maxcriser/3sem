using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Diagnostics;

namespace DispatcherTasks
{
    public partial class Form1 : Form
    {
        Timer timer = new Timer();

        public Form1()
        {
            InitializeComponent();
            timer.Interval = 1000;
            timer.Tick += new EventHandler(refreshData);
            timer.Start();
        }

        void refreshData(object sender, EventArgs e)
        {
            init();
        }

        void init()
        {
            Process currentProcess = Process.GetCurrentProcess();
            Process[] localAll = Process.GetProcesses();
            fillingDataGridView(localAll); 
        }

        void fillingDataGridView(Process[] processes)
        {
            grid.Rows.Clear();
            if (processes.Count() != 0) {
                total_label.Text = processes.Count().ToString();
            for (int i = 0; i < processes.Count(); i++) {
                    String idPriority = String.Empty;
                    ProcessThreadCollection ptc = processes[i].Threads;
                    for (int j = 0; j < ptc.Count; j++) {
                        idPriority += "[ " + ptc[j].Id + " / " + ptc[j].BasePriority + " ]\n"; 
                    }
                    grid.Rows.Add(processes[i].ProcessName, processes[i].Id, processes[i].StartInfo.EnvironmentVariables["USERNAME"],
                        processes[i].WorkingSet64, processes[i].BasePriority, processes[i].Threads.Count.ToString(), idPriority);
                }
            }
        }
    }
}
