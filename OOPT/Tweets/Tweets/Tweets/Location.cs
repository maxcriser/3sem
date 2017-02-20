using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tweets
{
    class Location
    {

        public double x;
        public double y;
        String nameLocation;

        Location(double x, double y)
        {
            this.x = x;
            this.y = y;

        }

        String getLocation()
        {
            nameLocation = ""; // set
            return nameLocation;
        }
    }
}
