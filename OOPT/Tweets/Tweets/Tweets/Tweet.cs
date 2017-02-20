using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tweets
{
    class Tweet
    {
        String line;
        public Location location;
        public int unknownNumber;
        public String date;
        public String time;
        public String textTweet;

        public Tweet(String line)
        {
            this.line = line;
        }

    }
}
