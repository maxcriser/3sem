using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace MemoryManagment
{
    public partial class AddProcessForm : Form
    {
        public AddProcessForm()
        {
            InitializeComponent();
        }

        private void addbutton_Click(object sender, EventArgs e)
        {
            //try
            //{
                int s = Int32.Parse(size.Text);
                MainForm.InComeProcess = new Process(s);
                this.Close();
            //}
            //catch (Exception ex)
            //{
            //    MessageBox.Show(this, "Size must be greater or equal zero", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            //}
        }
    }
}
