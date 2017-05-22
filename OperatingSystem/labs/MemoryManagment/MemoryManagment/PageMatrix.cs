using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MemoryManagment
{
    class PageMatrix
    {
        public Page[] Pages { get; private set; }
        public int PageSize { get; private set; }
        public int Occupied { get; private set; }

        public PageMatrix(int memory, int pageSize)
        {
            int size = memory / pageSize;
            Pages = new Page[size];
            for (int i = 0; i < size; i++)
            {
                Pages[i] = new Page();
            }
            Occupied = 0;
            PageSize = pageSize;
        }

        public bool loadProcess(Process process)
        {
            int pagesToOccupy = process.Size / PageSize + (process.Size % PageSize == 0 ? 0 : 1);
            return setPages(process, pagesToOccupy);
        }

        public void deleteProcess(Process process)
        {
            foreach (var page in Pages)
            {
                if (page.Id == process.Id)
                {
                    page.Id = -1;
                    Occupied--;
                }
            }
        }

        public int MapVirtualOntoPhysical(Process process, int virtualAddress)
        {
            int reminder = virtualAddress % PageSize;
            int virtualPage = virtualAddress / PageSize;
            int physicalPage = 0;
            foreach (var page in Pages)
            {
                if (process.Id == page.Id)
                {
                    virtualPage--;
                    if (virtualPage < 0)
                    {
                        return physicalPage * PageSize + reminder + 1;
                    }
                }
                physicalPage++;
            }
            return -1;
        }

        private bool setPages(Process process, int count)
        {
            if (count > Pages.Length - Occupied)
            {
                return false;
            }
            int startPage = 0;
            foreach (var page in Pages)
            {
                if (page.Id == -1)
                {
                    if (process.StartAddress == -1)
                    {
                        process.StartAddress = startPage * PageSize + 1;
                    }
                    page.Id = process.Id;
                    count--;
                    Occupied++;

                    if (count <= 0)
                    {
                        break;
                    }
                }
                startPage++;
            }
            return true;
        }
    }
}
