using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tweets
{
    class Tweet
    {
        public String locationStr;
        public Location location;
        public String unknownNumber;
        public String date;
        public String textTweet;

        public Tweet(String line)
        {
            parseLine(line);
            
        }

        void parseLine(String line)
        {
            String[] split = line.Split(new Char[] { '\t' });
            location = new Location(split[0]);
            unknownNumber = split[1];
            date = split[2];
            textTweet = split[3];
        }

    }
}
