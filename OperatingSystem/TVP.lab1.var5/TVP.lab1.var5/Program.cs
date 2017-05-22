using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace TVP.lab1.var5
{
	static class Program
	{
		/// <summary>
		/// Главная точка входа для приложения.
		/// </summary>
		[STAThread]
		static void Main()
		{
			Application.EnableVisualStyles();
			Application.SetCompatibleTextRenderingDefault(false);
			Application.Run(new Form1());
		}
	}

	public class Proccess
	{
		/*input data*/
		public string name;
		public int start_ready_tact;
		public int tacts_of_work;
		public int priority;
		public int number;

		/*calculated data*/
		public int start_work_tact;
		public int end_work_tact;
		public int tacts_of_wait;

		public int tacts_to_ready = 0;
		public Proccess(string new_name, int new_number, int new_start_ready_tact, int new_tacts_of_work, int new_priority)
		{
			name = new_name;
			number = new_number;
			start_ready_tact = new_start_ready_tact;
			tacts_of_work = new_tacts_of_work;
			priority = new_priority;
			tacts_to_ready = start_ready_tact;
		}
	}
}
