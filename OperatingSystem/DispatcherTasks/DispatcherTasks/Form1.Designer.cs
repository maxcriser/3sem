namespace DispatcherTasks
{
    partial class Form1
    {
        /// <summary>
        /// Обязательная переменная конструктора.
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
        /// Требуемый метод для поддержки конструктора — не изменяйте 
        /// содержимое этого метода с помощью редактора кода.
        /// </summary>
        private void InitializeComponent()
        {
            this.grid = new System.Windows.Forms.DataGridView();
            this.name = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.ID = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.user = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.memory = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.priority = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.streams = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.streams_info = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.label1 = new System.Windows.Forms.Label();
            this.total_label = new System.Windows.Forms.Label();
            this.processes_btn = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.grid)).BeginInit();
            this.SuspendLayout();
            // 
            // grid
            // 
            this.grid.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.grid.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.name,
            this.ID,
            this.user,
            this.memory,
            this.priority,
            this.streams,
            this.streams_info});
            this.grid.Location = new System.Drawing.Point(12, 46);
            this.grid.Name = "grid";
            this.grid.Size = new System.Drawing.Size(630, 249);
            this.grid.TabIndex = 0;
            // 
            // name
            // 
            this.name.HeaderText = "Name";
            this.name.Name = "name";
            // 
            // ID
            // 
            this.ID.HeaderText = "ID";
            this.ID.Name = "ID";
            this.ID.Width = 50;
            // 
            // user
            // 
            this.user.HeaderText = "User";
            this.user.Name = "user";
            this.user.Width = 80;
            // 
            // memory
            // 
            this.memory.HeaderText = "Memory";
            this.memory.Name = "memory";
            // 
            // priority
            // 
            this.priority.HeaderText = "Priority";
            this.priority.Name = "priority";
            this.priority.Width = 30;
            // 
            // streams
            // 
            this.streams.HeaderText = "Streams";
            this.streams.Name = "streams";
            this.streams.Width = 60;
            // 
            // streams_info
            // 
            this.streams_info.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.Fill;
            this.streams_info.HeaderText = "Streams info [ id / priority ]";
            this.streams_info.Name = "streams_info";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F);
            this.label1.Location = new System.Drawing.Point(567, 18);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(44, 17);
            this.label1.TabIndex = 1;
            this.label1.Text = "Total:";
            // 
            // total_label
            // 
            this.total_label.AutoSize = true;
            this.total_label.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F);
            this.total_label.Location = new System.Drawing.Point(604, 18);
            this.total_label.Name = "total_label";
            this.total_label.Size = new System.Drawing.Size(16, 17);
            this.total_label.TabIndex = 2;
            this.total_label.Text = "0";
            // 
            // processes_btn
            // 
            this.processes_btn.Location = new System.Drawing.Point(12, 12);
            this.processes_btn.Name = "processes_btn";
            this.processes_btn.Size = new System.Drawing.Size(75, 23);
            this.processes_btn.TabIndex = 3;
            this.processes_btn.Text = "Processes";
            this.processes_btn.UseVisualStyleBackColor = true;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(654, 307);
            this.Controls.Add(this.processes_btn);
            this.Controls.Add(this.total_label);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.grid);
            this.Name = "Form1";
            this.Text = "Form1";
            ((System.ComponentModel.ISupportInitialize)(this.grid)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.DataGridView grid;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label total_label;
        private System.Windows.Forms.Button processes_btn;
        private System.Windows.Forms.DataGridViewTextBoxColumn name;
        private System.Windows.Forms.DataGridViewTextBoxColumn ID;
        private System.Windows.Forms.DataGridViewTextBoxColumn user;
        private System.Windows.Forms.DataGridViewTextBoxColumn memory;
        private System.Windows.Forms.DataGridViewTextBoxColumn priority;
        private System.Windows.Forms.DataGridViewTextBoxColumn streams;
        private System.Windows.Forms.DataGridViewTextBoxColumn streams_info;
    }
}

