namespace MemoryManagment
{
    partial class AddProcessForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.label1 = new System.Windows.Forms.Label();
            this.size = new System.Windows.Forms.TextBox();
            this.addbutton = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(13, 13);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(56, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Enter size:";
            // 
            // size
            // 
            this.size.Location = new System.Drawing.Point(16, 30);
            this.size.Name = "size";
            this.size.Size = new System.Drawing.Size(181, 20);
            this.size.TabIndex = 1;
            // 
            // addbutton
            // 
            this.addbutton.Location = new System.Drawing.Point(16, 57);
            this.addbutton.Name = "addbutton";
            this.addbutton.Size = new System.Drawing.Size(181, 23);
            this.addbutton.TabIndex = 2;
            this.addbutton.Text = "Add";
            this.addbutton.UseVisualStyleBackColor = true;
            this.addbutton.Click += new System.EventHandler(this.addbutton_Click);
            // 
            // AddProcessForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(209, 90);
            this.Controls.Add(this.addbutton);
            this.Controls.Add(this.size);
            this.Controls.Add(this.label1);
            this.Name = "AddProcessForm";
            this.Text = "AddProcess";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox size;
        private System.Windows.Forms.Button addbutton;
    }
}