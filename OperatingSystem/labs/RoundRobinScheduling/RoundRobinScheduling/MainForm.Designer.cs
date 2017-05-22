namespace RoundRobinScheduling
{
    partial class MainForm
    {
        /// <summary>
        /// Требуется переменная конструктора.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Освободить все используемые ресурсы.
        /// </summary>
        /// <param name="disposing">истинно, если управляемый ресурс должен быть удален; иначе ложно.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Код, автоматически созданный конструктором форм Windows

        /// <summary>
        /// Обязательный метод для поддержки конструктора - не изменяйте
        /// содержимое данного метода при помощи редактора кода.
        /// </summary>
        private void InitializeComponent()
        {
            this.label1 = new System.Windows.Forms.Label();
            this.jobCountTB = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.jobCB = new System.Windows.Forms.ComboBox();
            this.label3 = new System.Windows.Forms.Label();
            this.executeTimeTB = new System.Windows.Forms.TextBox();
            this.quantumTB = new System.Windows.Forms.TextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.statusTB = new System.Windows.Forms.TextBox();
            this.executeButton = new System.Windows.Forms.Button();
            this.suspendButton = new System.Windows.Forms.Button();
            this.addJobButton = new System.Windows.Forms.Button();
            this.label6 = new System.Windows.Forms.Label();
            this.currentJobTB = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(13, 13);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(81, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Number of jobs:";
            // 
            // jobCountTB
            // 
            this.jobCountTB.Location = new System.Drawing.Point(16, 30);
            this.jobCountTB.Name = "jobCountTB";
            this.jobCountTB.ReadOnly = true;
            this.jobCountTB.Size = new System.Drawing.Size(121, 20);
            this.jobCountTB.TabIndex = 1;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(16, 57);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(63, 13);
            this.label2.TabIndex = 2;
            this.label2.Text = "Choose job:";
            // 
            // jobCB
            // 
            this.jobCB.FormattingEnabled = true;
            this.jobCB.Location = new System.Drawing.Point(16, 74);
            this.jobCB.Name = "jobCB";
            this.jobCB.Size = new System.Drawing.Size(121, 21);
            this.jobCB.TabIndex = 3;
            this.jobCB.SelectedIndexChanged += new System.EventHandler(this.jobCB_SelectedIndexChanged);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(16, 102);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(100, 13);
            this.label3.TabIndex = 4;
            this.label3.Text = "Execute time of job:";
            // 
            // executeTimeTB
            // 
            this.executeTimeTB.Location = new System.Drawing.Point(19, 119);
            this.executeTimeTB.Name = "executeTimeTB";
            this.executeTimeTB.ReadOnly = true;
            this.executeTimeTB.Size = new System.Drawing.Size(118, 20);
            this.executeTimeTB.TabIndex = 5;
            // 
            // quantumTB
            // 
            this.quantumTB.Location = new System.Drawing.Point(156, 30);
            this.quantumTB.Name = "quantumTB";
            this.quantumTB.Size = new System.Drawing.Size(116, 20);
            this.quantumTB.TabIndex = 6;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(156, 13);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(53, 13);
            this.label4.TabIndex = 7;
            this.label4.Text = "Quantum:";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(159, 57);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(40, 13);
            this.label5.TabIndex = 8;
            this.label5.Text = "Status:";
            // 
            // statusTB
            // 
            this.statusTB.Location = new System.Drawing.Point(156, 74);
            this.statusTB.Name = "statusTB";
            this.statusTB.ReadOnly = true;
            this.statusTB.Size = new System.Drawing.Size(116, 20);
            this.statusTB.TabIndex = 9;
            // 
            // executeButton
            // 
            this.executeButton.BackColor = System.Drawing.Color.Lime;
            this.executeButton.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.executeButton.Location = new System.Drawing.Point(19, 181);
            this.executeButton.Name = "executeButton";
            this.executeButton.Size = new System.Drawing.Size(118, 81);
            this.executeButton.TabIndex = 10;
            this.executeButton.Text = "Execute!";
            this.executeButton.UseVisualStyleBackColor = false;
            this.executeButton.Click += new System.EventHandler(this.executeButton_Click);
            // 
            // suspendButton
            // 
            this.suspendButton.BackColor = System.Drawing.Color.Red;
            this.suspendButton.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.suspendButton.ForeColor = System.Drawing.SystemColors.Control;
            this.suspendButton.Location = new System.Drawing.Point(156, 181);
            this.suspendButton.Name = "suspendButton";
            this.suspendButton.Size = new System.Drawing.Size(116, 81);
            this.suspendButton.TabIndex = 11;
            this.suspendButton.Text = "Suspend!";
            this.suspendButton.UseVisualStyleBackColor = false;
            this.suspendButton.Click += new System.EventHandler(this.suspendButton_Click);
            // 
            // addJobButton
            // 
            this.addJobButton.Location = new System.Drawing.Point(19, 152);
            this.addJobButton.Name = "addJobButton";
            this.addJobButton.Size = new System.Drawing.Size(253, 23);
            this.addJobButton.TabIndex = 12;
            this.addJobButton.Text = "Add Job";
            this.addJobButton.UseVisualStyleBackColor = true;
            this.addJobButton.Click += new System.EventHandler(this.addJobButton_Click);
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(159, 97);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(61, 13);
            this.label6.TabIndex = 13;
            this.label6.Text = "Current job:";
            // 
            // currentJobTB
            // 
            this.currentJobTB.Location = new System.Drawing.Point(156, 119);
            this.currentJobTB.Name = "currentJobTB";
            this.currentJobTB.ReadOnly = true;
            this.currentJobTB.Size = new System.Drawing.Size(116, 20);
            this.currentJobTB.TabIndex = 14;
            // 
            // MainForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(284, 274);
            this.Controls.Add(this.currentJobTB);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.addJobButton);
            this.Controls.Add(this.suspendButton);
            this.Controls.Add(this.executeButton);
            this.Controls.Add(this.statusTB);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.quantumTB);
            this.Controls.Add(this.executeTimeTB);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.jobCB);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.jobCountTB);
            this.Controls.Add(this.label1);
            this.Name = "MainForm";
            this.Text = "Form1";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.MainForm_FormClosing);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox jobCountTB;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.ComboBox jobCB;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox executeTimeTB;
        private System.Windows.Forms.TextBox quantumTB;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.TextBox statusTB;
        private System.Windows.Forms.Button executeButton;
        private System.Windows.Forms.Button suspendButton;
        private System.Windows.Forms.Button addJobButton;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.TextBox currentJobTB;
    }
}

