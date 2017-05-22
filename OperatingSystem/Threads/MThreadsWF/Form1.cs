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
using System.IO;

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

            double timeThread = 0;
            double startTimeThread = DateTime.Now.Millisecond + (DateTime.Now.Second * 1000);

            for (int i = 0; i < countCycles; i++)
            {
                double[] a = new double[N];
                double[] b = new double[N];

                for (int p = 0; p < a.Length; p++)
                {
                    for (int j = 0; j < K; j++)
                    {
                        b[p] += Math.Pow(a[p], 1.789);
                    }
                }
            }

            timeThread = (DateTime.Now.Millisecond + (DateTime.Now.Second * 1000)) - startTimeThread;
            resultThread = "1:" + K + ":" + N + ":" + timeThread;

            /////////////////////////////////

            double timeMultiThread = 0;
            double startTimeMultiThread = DateTime.Now.Millisecond + (DateTime.Now.Second * 1000);

            for (int i = 0; i < countCycles; i++)
            {
                double[] a = new double[N];
                double[] b = new double[N];

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
                        for (int p = start; p < end; p++)
                        {
                            for (int j = 0; j < K; j++)
                            {
                                b[p] += Math.Pow(a[p], 1.789);
                            }
                        }
                    });

                    thr2.Start();

                    if (c == countThreads - 1)
                    {
                        thr2.Join();
                    }
                }
            }
            timeMultiThread = (DateTime.Now.Millisecond + (DateTime.Now.Second * 1000)) - startTimeMultiThread;
            resultMultiThreads = countThreads + ":" + K + ":" + N + ":" + timeMultiThread;

            using (System.IO.StreamWriter file =
            new System.IO.StreamWriter(@"D:\GitHubProjects\threads.txt", true))
            {
                file.WriteLine(resultMultiThreads);
                file.WriteLine(resultThread);
            }

            chartFilling();
        }

        public void chartFilling()
        {
            List<Model> list = new List<Model>();
            String line;

            System.IO.StreamReader file = new System.IO.StreamReader(@"D:\\GitHubProjects\\threads.txt");
            while ((line = file.ReadLine()) != null)
            {
                Model model = new Model();
                String[] array = line.Split(':');
                model.setCountThreads(Double.Parse(array[0]));
                model.setK(Double.Parse(array[1]));
                model.setN(Double.Parse(array[2]));
                model.setTime(Double.Parse(array[3]));
                list.Add(model);
            }
            file.Close();

            chart2.Series["Line"].Points.Clear();
            chart1.Series["Thread"].Points.Clear();
            chart1.Series["MultiThreads"].Points.Clear();


            for (int i = 0; i < list.Count; i++)
            {
                Model model = list[i];
                if(model.getCountThreads() > 1 && model.getK() == 1000 && model.getN() == 1000)
                {
                    chart2.Series["Line"].Points.AddXY(model.getCountThreads(), model.getTime());
                }
                
                if(model.getCountThreads() == 1 && model.getN() == 1000)
                {
                    chart1.Series["Thread"].Points.AddXY(model.getK(), model.getTime());
                }

                if(model.getCountThreads() > 1 && model.getN() == 1000)
                {
                    chart1.Series["MultiThreads"].Points.AddXY(model.getK(), model.getTime());
                }
            }
        }
    }
}
