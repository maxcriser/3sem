using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Swapping
{
    public interface ICache
    {
        Page GetPage(int id);

        Page GetRandomExistingPage();

        void Live();

        bool IsInCache(int id);
    }
}
