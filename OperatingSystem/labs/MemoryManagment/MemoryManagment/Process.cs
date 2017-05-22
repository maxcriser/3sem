using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MemoryManagment
{
    public class Process
    {
        private static int _id;
        public int Id { get; private set; }
        public int StartAddress;
        public int Size { get; private set; }

        public Process(int size)
        {
            Id = _id++;
            Size = size;
            StartAddress = -1;
        }

    }
}
