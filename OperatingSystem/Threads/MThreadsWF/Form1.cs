using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;
using System.Windows.Forms;

namespace MThreadsWF
{
    public partial class Form1 : Form
    {
        private int N;
        private int K;
        private int countThreads;
        private int countCycles = 10;

        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            String resultMultiThreads = "";
            String resultThread = "";

            N = Int32.Parse(textBox1.Text);
            K = Int32.Parse(textBox3.Text);
            countThreads = Int32.Parse(textBox2.Text);

            int timeThread = 0;

            for (int i = 0; i < countCycles; i++)
            {
                double[] a = new double[N];
                double[] b = new double[N];

                int startTime = DateTime.Now.Millisecond;

                for (int p = 0; p < a.Length; p++)
                {
                    for (int j = 0; j < K; j++)
                    {
                        b[i] += Math.Pow(a[i], 1.789);
                    }
                }

                timeThread += DateTime.Now.Millisecond - startTime;
            }

            timeThread /= countCycles;
            resultThread = "1:" + K + ":" + N + ":" + timeThread;

            /////////////////////////////////

            int timeMultiThread = 0;

            for (int i = 0; i < countCycles; i++)
            {
                double[] a = new double[N];
                double[] b = new double[N];

                int startTime = DateTime.Now.Millisecond;

                for (int c = 0; c < countThreads; c++)
                {
                    int start = c * N / countThreads;
                    int end = 0;

                    if (c == countThreads - 1)
                    {
                        end = N;
                    }
                    else
                    {
                        end = (c + 1) * N / countThreads;
                    }

                    Thread thr2 = new Thread(() =>
                    {
                        for (int i = start; i < end; i++)
                        {
                            for (int j = 0; j < K; j++)
                            {
                                b[i] += Math.Pow(a[i], 1.789);
                            }
                        }
                    });

                    thr2.Start();

                    if (c == countThreads - 1)
                    {
                        thr2.Join();
                    }
                }
                timeMultiThread += DateTime.Now.Millisecond - startTime;
            }
            timeMultiThread /= countCycles;
            resultMultiThreads = countThreads + ":" + K + ":" + N + ":" + timeMultiThread;



            // write to file
        }
    }
}
