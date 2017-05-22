using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Swapping
{
    public class Page
    {
        private bool R;
        private bool M;
        public int LiveTime { get; private set; }
        private static int _id;
        public int Id { get; private set; }

        public enum PageClass
        {
            C0, C1, C2, C3
        }

        public Page()
        {
            R = M = false;
            LiveTime = 0;
            Id = _id++;
        }

        public Page(int id)
            : base()
        {
            Id = id;
        }

        public PageClass GetClass()
        {
            if (!R && !M) return PageClass.C0;
            else if (!R && M) return PageClass.C1;
            else if (R && !M) return PageClass.C2;
            else return PageClass.C3;
        }

        public void Read()
        {
            R = true;
        }

        public void Modify()
        {
            M = true;
        }

        public bool IsReadRecently()
        {
            return R;
        }

        public bool IsModified()
        {
            return M;
        }

        public void ResetReadBit()
        {
            R = false;
        }

        public void Live()
        {
            LiveTime++;
        }

        public void ResetAll()
        {
            R = M = false;
            LiveTime = 0;
        }

        public String GetClassAsString()
        {
            PageClass pageClass = GetClass();
            switch (pageClass)
            {
                case PageClass.C0:
                    return "C0";
                case PageClass.C1:
                    return "C1";
                case PageClass.C2:
                    return "C2";
                case PageClass.C3:
                    return "C3";
                default:
                    return "Unknown";
            }
        }
    }
}
