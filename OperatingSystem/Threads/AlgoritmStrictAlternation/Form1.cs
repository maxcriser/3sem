using System;
using System.ComponentModel;
using System.Collections.Generic;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace AlgoritmStrictAlternation
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            label1.Text = "0";
            initThreads();
        }

        public void initThreads()
        {
            int turn = 0;

            Thread thr1 = new Thread(() =>
            {
                while (true)
                {
                    while (turn != 0) ;
                    //critical_region();
                    turn = 1;
                    //noncritical_region();
                }
            });

            Thread thr2 = new Thread(() =>
            {
                while (true)
                {
                    while (turn != 1) ;
                    //critical_region();
                    turn = 0;
                    //noncritical_region();
                }
            });
        }
    }
}
