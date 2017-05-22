using RoundRobinScheduling;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Scheduling
{
    public partial class FormAddJob : Form
    {
        public FormAddJob()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            try
            {
                int time = Int32.Parse(textBox1.Text);
                if (time <= 0) throw new Exception();
                MainForm.UserJobs.Add(new Job(time));
            }
            catch (Exception ex)
            {
                MessageBox.Show(this, "Time must be a positive integer", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }
    }
}
