using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace MemoryManagment
{
    public partial class MainForm : Form
    {
        private int SLEEP_TIME = 2000;
        private List<Process> processList = new List<Process>();
        private PageMatrix matrix;
        public static Process InComeProcess = null;
        private Thread thread;

        public MainForm()
        {
            InitializeComponent();
        }

        private void loadProcessList()
        {
            foreach (Process process in processList)
            {
                loadProcess(process);
            }
        }

        private void loadProcess(Process process)
        {
            if (!matrix.loadProcess(process))
            {
                string message = "Cannot add process with id " + process.Id + "."
                                + "Not enough memory. Process of loading other jobs is interrupted";
                MessageBox.Show(this, message, "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }
            else
            {
                processChoose.Invoke((Action)delegate
                {
                    processChoose.Items.Add(process.Id.ToString());
                });
            }
         
        }

        private void deleteProcessList()
        {
            for (int i = 0; i < processList.Count; i++)
            {
                deleteItem(i);
            }
        }

        private bool initMatrix()
        {
            if (matrix != null)
            {
                return true;
            }
            try
            {
                int memory = Int32.Parse(memorySize.Text);
                int segment = Int32.Parse(segmentSize.Text);
                matrix = new PageMatrix(memory, segment);
            }
            catch (Exception e)
            {
                string message = "Memory and segment sizes must be declared and greater then zero";
                MessageBox.Show(this, message, "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return false;
            }
            return true;
        }

        private void emulate_Click(object sender, EventArgs e)
        {
            emulate.Enabled = false;
            addProcess.Enabled = false;
            deleteProcess.Enabled = false;
            memorySize.Enabled = false;
            segmentSize.Enabled = false;
            if (!initMatrix())
            {
                return;
            }
            thread = new Thread(() => {
                foreach (Process process in processList)
                {
                    currentProcess.Invoke((Action)delegate
                    {
                        currentProcess.Text = process.Id.ToString();
                    });
                    for (int i = 0; i < process.Size; i++)
                    {
                        virtualAddress.Invoke((Action)delegate{
                            virtualAddress.Text = i.ToString();
                        });
                        physicalAddress.Invoke((Action)delegate
                        {
                            physicalAddress.Text = matrix.MapVirtualOntoPhysical(process, i).ToString();
                        });
                        Thread.Sleep(SLEEP_TIME);
                    }
                    matrix.deleteProcess(process);
                }
                deleteProcessList();
                loadProcessList();
                emulate.Invoke((Action)delegate
                {
                    emulate.Enabled = true;
                });
                deleteProcess.Invoke((Action)delegate
                {
                    deleteProcess.Enabled = true;
                });
                memorySize.Invoke((Action)delegate
                {
                    memorySize.Enabled = true;
                });
                segmentSize.Invoke((Action)delegate
                {
                    segmentSize.Enabled = true;
                });
                addProcess.Invoke((Action)delegate
                {
                    addProcess.Enabled = true;
                });
            });
            thread.Start();
        }

        private void addProcess_Click(object sender, EventArgs e)
        {
            AddProcessForm form = new AddProcessForm();
            form.FormClosed += (object o, FormClosedEventArgs args) =>
            {
                if (!initMatrix())
                {
                    return;
                }
                if (InComeProcess != null)
                {
                    processList.Add(InComeProcess);
                    loadProcess(InComeProcess);
                    InComeProcess = null;
                }
            };
            form.Show();
        }

        private void deleteProcess_Click(object sender, EventArgs e)
        {
            int pid = processChoose.SelectedIndex;
            deleteItem(pid);
            startAddress.Text = string.Empty;
            endAddress.Text = string.Empty;
        }

        private void deleteItem(int pid)
        {
            if (!initMatrix())
            {
                return;
            }
            Process process = processList[pid];
            processList.RemoveAt(pid);
            matrix.deleteProcess(process);
            processChoose.Invoke((Action)delegate
            {
                processChoose.Items.RemoveAt(pid);
            });
        }

        private void processChoose_SelectedIndexChanged(object sender, EventArgs e)
        {
            int pid = processChoose.SelectedIndex;
            Process process = processList[pid];
            startAddress.Text = process.StartAddress.ToString();
            endAddress.Text = (process.StartAddress + process.Size).ToString();
        }

        private void MainForm_FormClosing(object sender, FormClosingEventArgs e)
        {
            if (thread != null && thread.IsAlive)
            {
                thread.Abort();
            }
        }
    }
}
