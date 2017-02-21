using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tweets
{
    class Location
    {
        public String x;
        public String y;

        public Location(String location)
        {
            String[] split = location.Split(new Char[] { '[', ']', ' ', ',' });
            x = split[1];
            y = split[3];
        }
    }
}
