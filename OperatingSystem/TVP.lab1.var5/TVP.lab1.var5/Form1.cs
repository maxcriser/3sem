using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace TVP.lab1.var5
{
	
	public partial class Form1 : Form
	{

		List<Proccess> stack = new List<Proccess>();
		Color activeColor = Color.GreenYellow;
		Color defColor = SystemColors.Control;

		private void noActive()
		{
			foreach (Control Button in Controls["Alghoritms"].Controls)
			{
				Button.BackColor = defColor;
			}
		}

		public Form1()
		{
			InitializeComponent();
		}

		private bool CreateProccess()
		{
			string[] names = {"A", "B", "C", "D", "E"};
			stack.Clear();


			int number = 1;
			foreach (string name in names)
			{
				Control Input = Controls["InputData"];
				try
				{
					stack.Add(new Proccess(	name, number++,
											Convert.ToInt32(Input.Controls[name + "_start"].Text),
											Convert.ToInt32(Input.Controls[name + "_twork"].Text),
											Convert.ToInt32(Input.Controls[name + "_priority"].Text))
					);
				}
				catch
				{
					MessageBox.Show("Введены не все значения!");
					return false;
				}
					
			}

			return true;
		}


		private void FCFS_Click(object sender, EventArgs e)
		{
			if (!CreateProccess())
				return;

			noActive();
			FCFS.BackColor = activeColor;

			stack.Sort(
					delegate(Proccess P1, Proccess P2)
					{ return P1.start_ready_tact.CompareTo(P2.start_ready_tact); }
			);

			int count_ready_proccess = 0;
			int tact = 0;
			while(count_ready_proccess < 5)
			{
				Proccess curProc = null;
				for (int i = 0; i < stack.Count; i++)
				{
					if (stack[i].tacts_to_ready <= 0 && stack[i].end_work_tact == 0)
					{
						curProc = stack[i];
						break;
					}
						
				}

				if (curProc == null)
				{
					tact++;
					continue;
				}


				curProc.start_work_tact = tact;
				curProc.tacts_of_wait = curProc.start_work_tact -
										curProc.start_ready_tact;

				if (curProc.start_ready_tact > tact)
					tact += curProc.start_ready_tact;
				tact += curProc.tacts_of_work;

				curProc.end_work_tact = tact;

				for (int i = 0; i < stack.Count; i++)
				{
					stack[i].tacts_to_ready -= curProc.tacts_of_work;
				}
				count_ready_proccess++;
			}

			drowResultDiagramm(tact);
		}


		private void PriorityPlaninig_Click(object sender, EventArgs e)
		{
			if (!CreateProccess())
				return;

			noActive();
			PriorityPlaninig.BackColor = activeColor;

			int tact;
			List<Proccess> readyProccess = new List<Proccess>();
			int count_ready_proccess = 0;
			for (tact = 0; count_ready_proccess < 5;)
			{
				for (int i = 0; i < stack.Count; i++)
				{
					if (stack[i].tacts_to_ready <= 0 && stack[i].end_work_tact == 0)
						readyProccess.Add(stack[i]);
				}

				if (readyProccess.Count > 1)
					readyProccess.Sort(delegate(Proccess P1, Proccess P2)
					{ return P1.priority.CompareTo(P2.priority); });
				else if (readyProccess.Count == 0)
				{
					tact++;
					for (int i = 0; i < stack.Count; i++)
					{
						stack[i].tacts_to_ready--;
					}
					continue;
				}

				Proccess curProc = stack.Find(delegate(Proccess proc) { return proc.name == readyProccess[0].name; });
				readyProccess.Clear();

				curProc.start_work_tact = tact;
				curProc.tacts_of_wait = tact - curProc.start_ready_tact;

				tact += curProc.tacts_of_work;

				curProc.end_work_tact = tact;

				for (int i = 0; i < stack.Count; i++)
				{
					stack[i].tacts_to_ready -= curProc.tacts_of_work;
				}

				count_ready_proccess++;
			}

			drowResultDiagramm(tact);
		}

		private void HRRN_Click(object sender, EventArgs e)
		{
			if (!CreateProccess())
				return;

			noActive();
			HRRN.BackColor = activeColor;

			int tact;
			List<Proccess> readyProccess = new List<Proccess>();
			int count_ready_proccess = 0;
			for (tact = 0; count_ready_proccess < 5; )
			{
				for (int i = 0; i < stack.Count; i++)
				{
					if (stack[i].tacts_to_ready <= 0 && stack[i].end_work_tact == 0)
						readyProccess.Add(stack[i]);
				}

				if (readyProccess.Count > 1)
				{
					readyProccess.Sort(delegate(Proccess P1, Proccess P2)
					{
						float r1 = -P1.tacts_to_ready / P1.tacts_of_work + 1;
						float r2 = -P2.tacts_to_ready / P2.tacts_of_work + 1;
						return r2.CompareTo(r1);
					});
				}
				else if (readyProccess.Count == 0)
				{
					tact++;
					for (int i = 0; i < stack.Count; i++)
						stack[i].tacts_to_ready--;
					continue;
				}

				Proccess curProc = stack.Find(delegate(Proccess proc) { return proc.name == readyProccess[0].name; });
				readyProccess.Clear();

				curProc.start_work_tact = tact;
				curProc.tacts_of_wait = tact - curProc.start_ready_tact;

				tact += curProc.tacts_of_work;

				curProc.end_work_tact = tact;

				for (int i = 0; i < stack.Count; i++)
				{
					stack[i].tacts_to_ready -= curProc.tacts_of_work;
				}

				count_ready_proccess++;
			}

			drowResultDiagramm(tact);
		}

		private void drowResultDiagramm(int curTact)
		{
			int k = 20;
			int xmax = curTact + 1;
			int ymax = stack.Count + 2;
			//Diagramm.
			Diagramm.Width = xmax * k;
			Diagramm.Height = ymax * k;
			Diagramm.Refresh();
			debug.Text = "";

			Graphics diagramma = Diagramm.CreateGraphics();

			Pen gridPen = new Pen(Color.Black, 1);
			gridPen.DashStyle = System.Drawing.Drawing2D.DashStyle.Dash;
			for (int i = 0; i <= ymax; i++)
			{
				diagramma.DrawLine(gridPen, 0, k * i, k * xmax, k * i);
			}
			for (int i = 0; i <= xmax; i++)
			{
				diagramma.DrawLine(gridPen, k * i, 0, k * i, k * ymax);
			}

			Pen borderPen = new Pen(Color.Black, 3);
			diagramma.DrawLine(borderPen, 0, k * ymax, k * xmax, k * ymax);
			diagramma.DrawLine(borderPen, 0, 0, 0, k * ymax);

			Pen readyPen = new Pen(Color.Red, 2);
			foreach (Proccess P in stack)
			{
				diagramma.DrawLine(readyPen, k * P.start_ready_tact, k * (ymax - 1), k * P.start_ready_tact, k * (ymax - P.number-1));
				diagramma.DrawLine(readyPen, k * P.start_work_tact, k * (ymax - 1), k * P.start_work_tact, k * (ymax - P.number-1));
				diagramma.DrawLine(readyPen, k * P.start_ready_tact, k * (ymax - P.number-1), k * P.start_work_tact, k * (ymax - P.number-1));
			}

			Pen workPen = new Pen(Color.Blue, 5);
			foreach (Proccess P in stack)
			{
				diagramma.DrawLine(workPen, k * P.start_work_tact, k * (ymax - 1), k * P.start_work_tact, k * (ymax - P.number-1));
				diagramma.DrawLine(workPen, k * P.end_work_tact, k * (ymax - 1), k * P.end_work_tact, k * (ymax - P.number-1));
				diagramma.DrawLine(workPen, k * P.start_work_tact, k * (ymax - P.number-1), k * P.end_work_tact, k * (ymax - P.number-1));
			}


			float sum_time_work = 0;
			float sum_time_wait = 0;
			string hr =		"+------+-------+-------+------+-----+\n";
			debug.Text += hr;
			debug.Text +=	"| Proc | Ready | Start | Work | End |\n";
			debug.Text += hr;
			foreach (Proccess P in stack)
			{
				debug.Text  +=
					String.Format("| \"{0,1}\"  |  {1,2}   |  {2,2}   |  {3,2}  | {4,2}  |\n",
									P.name, P.start_ready_tact, P.start_work_tact, (P.end_work_tact - P.start_work_tact), P.end_work_tact);
				sum_time_work += P.end_work_tact - P.start_work_tact;
				sum_time_wait += P.tacts_of_wait;
			}
			debug.Text += hr;
			debug.Text +=	"\n среднее время выполнения = " + (sum_time_work / stack.Count) +
							"\n среднее время   ожидания = " + (sum_time_wait / stack.Count);
		}

		
	}
}
