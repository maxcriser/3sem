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

        volatile private static Boolean flag = false;
        volatile private static int countBeeps;
        volatile private static int count = 0;

        public Form1()
        {
            InitializeComponent();
            AllocConsole();
        }

        private static void someMethod(String threadName)
        {
            if (countBeeps < count)
            {
                Console.WriteLine(threadName + " thread...");
                if (threadName.Equals("1st"))
                {
                    Console.Beep();
                }
                else
                {
                    SystemSounds.Beep.Play();
                }
                count++;
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

                new Thread(() =>
                {
                    while (true)
                    {
                        while (flag) ;
                        someMethod("2nd");
                        flag = true;
                    }
                }).Start();

                new Thread(() =>
                {
                    while (true)
                    {
                        while (!flag) ;
                        someMethod("1st");
                        flag = false;
                    }
                }).Start();
            }
        }
    }
}
