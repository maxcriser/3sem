using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Swapping
{
    class RingList<T>
    {
        public delegate bool Predicate(T t, int index);
        public delegate bool OnRingRestart(int times);
        public event OnRingRestart RingRestart;
        private List<T> elements;
        public int Count {
            get
            {
                return elements.Count;
            }
        }

        public RingList()
        {
            elements = new List<T>();
        }

        public void Add(T t)
        {
            elements.Add(t);
        }

        public void RemoveAt(int i)
        {
            elements.RemoveAt(i);
        }

        public void Iterate(Predicate p)
        {
            Iterate(p, 0);
        }

        public void Iterate(Predicate p, int index)
        {
            int times = 0;
            int count = 0;
            while (true)
            {
                if (p(elements[index], index))
                {
                    break;
                }
                index++;
                count++;
                if (index >= elements.Count)
                {
                    index = 0;
                }
                if (count >= elements.Count)
                {
                    times++;
                    count = 0;
                    if (RingRestart(times))
                    {
                        break;
                    }
                }
            }
            CleanUpEvent();
        }

        public T this[int i]
        {
            get { return elements[i]; }
            set { elements[i] = value; }
        }

        private void CleanUpEvent()
        {
            Delegate[] delegs = RingRestart.GetInvocationList();
            foreach (var d in delegs)
            {
                RingRestart -= (OnRingRestart) d;
            }
        }
    }
}
