using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MThreadsWF
{
    public class Model
    {
        public double countThreads;
        public double N;
        public double K;
        public double time;

        public Model() { }

        public double getN()
        {
            return N;
        }

        public double getK()
        {
            return K;
        }

        public double getTime()
        {
            return time;
        }

        public double getCountThreads()
        {
            return countThreads;
        }

        public void setN(double N)
        {
            this.N = N;
        }

        public void setK(double K)
        {
            this.K = K;
        }

        public void setTime(double time)
        {
            this.time = time;
        }

        public void setCountThreads(double countThreads)
        {
            this.countThreads = countThreads;
        }
    }
}
