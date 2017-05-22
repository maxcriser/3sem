namespace MemoryManagment
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
            this.memorySize = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.segmentSize = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.processChoose = new System.Windows.Forms.ComboBox();
            this.label4 = new System.Windows.Forms.Label();
            this.startAddress = new System.Windows.Forms.TextBox();
            this.endAddress = new System.Windows.Forms.TextBox();
            this.label5 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.label7 = new System.Windows.Forms.Label();
            this.virtualAddress = new System.Windows.Forms.TextBox();
            this.label8 = new System.Windows.Forms.Label();
            this.physicalAddress = new System.Windows.Forms.TextBox();
            this.addProcess = new System.Windows.Forms.Button();
            this.deleteProcess = new System.Windows.Forms.Button();
            this.emulate = new System.Windows.Forms.Button();
            this.label9 = new System.Windows.Forms.Label();
            this.currentProcess = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(13, 13);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(68, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Memory size:";
            // 
            // memorySize
            // 
            this.memorySize.Location = new System.Drawing.Point(16, 29);
            this.memorySize.Name = "memorySize";
            this.memorySize.Size = new System.Drawing.Size(100, 20);
            this.memorySize.TabIndex = 1;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(13, 58);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(73, 13);
            this.label2.TabIndex = 2;
            this.label2.Text = "Segment size:";
            // 
            // segmentSize
            // 
            this.segmentSize.Location = new System.Drawing.Point(16, 74);
            this.segmentSize.Name = "segmentSize";
            this.segmentSize.Size = new System.Drawing.Size(100, 20);
            this.segmentSize.TabIndex = 3;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(148, 13);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(48, 13);
            this.label3.TabIndex = 4;
            this.label3.Text = "Process:";
            // 
            // processChoose
            // 
            this.processChoose.FormattingEnabled = true;
            this.processChoose.Location = new System.Drawing.Point(151, 29);
            this.processChoose.Name = "processChoose";
            this.processChoose.Size = new System.Drawing.Size(121, 21);
            this.processChoose.TabIndex = 5;
            this.processChoose.SelectedIndexChanged += new System.EventHandler(this.processChoose_SelectedIndexChanged);
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(148, 58);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(72, 13);
            this.label4.TabIndex = 6;
            this.label4.Text = "Start address:";
            // 
            // startAddress
            // 
            this.startAddress.Location = new System.Drawing.Point(151, 74);
            this.startAddress.Name = "startAddress";
            this.startAddress.ReadOnly = true;
            this.startAddress.Size = new System.Drawing.Size(100, 20);
            this.startAddress.TabIndex = 7;
            // 
            // endAddress
            // 
            this.endAddress.Location = new System.Drawing.Point(151, 113);
            this.endAddress.Name = "endAddress";
            this.endAddress.ReadOnly = true;
            this.endAddress.Size = new System.Drawing.Size(100, 20);
            this.endAddress.TabIndex = 8;
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(148, 97);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(69, 13);
            this.label5.TabIndex = 9;
            this.label5.Text = "End address:";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(13, 159);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(39, 13);
            this.label6.TabIndex = 10;
            this.label6.Text = "Virtual:";
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(13, 198);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(49, 13);
            this.label7.TabIndex = 11;
            this.label7.Text = "Physical:";
            // 
            // virtualAddress
            // 
            this.virtualAddress.Location = new System.Drawing.Point(16, 175);
            this.virtualAddress.Name = "virtualAddress";
            this.virtualAddress.ReadOnly = true;
            this.virtualAddress.Size = new System.Drawing.Size(100, 20);
            this.virtualAddress.TabIndex = 12;
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(12, 140);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(130, 13);
            this.label8.TabIndex = 13;
            this.label8.Text = "Current command address";
            // 
            // physicalAddress
            // 
            this.physicalAddress.Location = new System.Drawing.Point(16, 215);
            this.physicalAddress.Name = "physicalAddress";
            this.physicalAddress.ReadOnly = true;
            this.physicalAddress.Size = new System.Drawing.Size(100, 20);
            this.physicalAddress.TabIndex = 14;
            // 
            // addProcess
            // 
            this.addProcess.Location = new System.Drawing.Point(151, 140);
            this.addProcess.Name = "addProcess";
            this.addProcess.Size = new System.Drawing.Size(121, 52);
            this.addProcess.TabIndex = 15;
            this.addProcess.Text = "Add process";
            this.addProcess.UseVisualStyleBackColor = true;
            this.addProcess.Click += new System.EventHandler(this.addProcess_Click);
            // 
            // deleteProcess
            // 
            this.deleteProcess.Location = new System.Drawing.Point(151, 199);
            this.deleteProcess.Name = "deleteProcess";
            this.deleteProcess.Size = new System.Drawing.Size(121, 51);
            this.deleteProcess.TabIndex = 16;
            this.deleteProcess.Text = "Delete process";
            this.deleteProcess.UseVisualStyleBackColor = true;
            this.deleteProcess.Click += new System.EventHandler(this.deleteProcess_Click);
            // 
            // emulate
            // 
            this.emulate.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(192)))), ((int)(((byte)(0)))));
            this.emulate.Location = new System.Drawing.Point(16, 241);
            this.emulate.Name = "emulate";
            this.emulate.Size = new System.Drawing.Size(100, 52);
            this.emulate.TabIndex = 17;
            this.emulate.Text = "Emulate";
            this.emulate.UseVisualStyleBackColor = false;
            this.emulate.Click += new System.EventHandler(this.emulate_Click);
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.Location = new System.Drawing.Point(15, 97);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(95, 13);
            this.label9.TabIndex = 18;
            this.label9.Text = "Current process id:";
            // 
            // currentProcess
            // 
            this.currentProcess.Location = new System.Drawing.Point(16, 117);
            this.currentProcess.Name = "currentProcess";
            this.currentProcess.ReadOnly = true;
            this.currentProcess.Size = new System.Drawing.Size(100, 20);
            this.currentProcess.TabIndex = 19;
            // 
            // MainForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(284, 308);
            this.Controls.Add(this.currentProcess);
            this.Controls.Add(this.label9);
            this.Controls.Add(this.emulate);
            this.Controls.Add(this.deleteProcess);
            this.Controls.Add(this.addProcess);
            this.Controls.Add(this.physicalAddress);
            this.Controls.Add(this.label8);
            this.Controls.Add(this.virtualAddress);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.endAddress);
            this.Controls.Add(this.startAddress);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.processChoose);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.segmentSize);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.memorySize);
            this.Controls.Add(this.label1);
            this.Name = "MainForm";
            this.Text = "Memory Managment";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.MainForm_FormClosing);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox memorySize;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox segmentSize;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.ComboBox processChoose;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.TextBox startAddress;
        private System.Windows.Forms.TextBox endAddress;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.TextBox virtualAddress;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.TextBox physicalAddress;
        private System.Windows.Forms.Button addProcess;
        private System.Windows.Forms.Button deleteProcess;
        private System.Windows.Forms.Button emulate;
        private System.Windows.Forms.Label label9;
        private System.Windows.Forms.TextBox currentProcess;
    }
}

