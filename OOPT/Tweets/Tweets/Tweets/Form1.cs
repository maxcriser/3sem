using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Tweets
{
    public partial class Form1 : Form
    {
        List<Tweet> tweets;
        String path = @"D:\GitHubProjects\3sem\OOPT\Tweets\Tweets\Tweets\texas.txt";
        public Form1()
        {
            InitializeComponent();
            tweets = Reader.readFromToList(path);
            fillDataGridView(tweets);
        }

        void fillDataGridView(List<Tweet> tweets)
        {
            if (tweets.Count != 0)
            {
                for(int i = 0; i < tweets.Count; i++) {
                    grid.Rows.Add(tweets[i].location.x, tweets[i].location.y, tweets[i].unknownNumber, tweets[i].date, tweets[i].textTweet);
                }
            }
        }

    }
}
