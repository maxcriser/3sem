using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace Tweets
{
    class Reader
    {
        public static List<Tweet> readFromToList(String path)
        {
            List<Tweet> tweets = new List<Tweet>();
            tweets.Clear();
            StreamReader stream = new StreamReader(path, Encoding.GetEncoding(1251));
            while (!stream.EndOfStream)
            {
                String line = stream.ReadLine();
                Tweet tweet = new Tweet(line);
                tweets.Add(tweet);
            };  
            stream.Close();
            return tweets;
        }
    }
}
