using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading;
using System.Media;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Runtime.InteropServices;

namespace Lab2OS
{
    public partial class Form1 : Form
    {
        [DllImport("kernel32.dll", SetLastError = true)]
        [return: MarshalAs(UnmanagedType.Bool)]
        static extern bool AllocConsole();
        volatile private int count = 0;
        volatile private int countBeeps = 0;

        public Form1()
        {
            InitializeComponent();
            AllocConsole();
        }

        public void Task1Petersen()
        {
            while (true)
            {
                Petersen.EnterRegion(0);
                //Console.WriteLine("#1 enter in critical section");
                if (countBeeps > count)
                {
                    Console.Beep();
                    count++;
                }
                Thread.Sleep(500);
                //Console.WriteLine("#1 leave from critical section");
                Petersen.LeaveRegion(0);
            }
        }

        public void Task2Petersen()
        {
            while (true)
            {
                Petersen.EnterRegion(1);
                //Console.WriteLine("#2 enter in critical section");
                if (countBeeps > count)
                {
                    SystemSounds.Beep.Play();
                    count++;
                }
                Thread.Sleep(500);
                //Console.WriteLine("#2 leave from critical section");
                Petersen.LeaveRegion(1);
            }

        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (textBox1.Text == string.Empty)
            {
                MessageBox.Show("Please, input number...");
            }
            else
            {
                countBeeps = Convert.ToInt32(textBox1.Text);
                Task.Factory.StartNew(() => { Task1Petersen(); });
                Task.Factory.StartNew(() => { Task2Petersen(); });
            }
        }
    }
}
