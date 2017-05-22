using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Swapping
{
    public abstract class AbstractCache
    {
        protected abstract Page GetPageFromMemory(int id);

        protected abstract Page ReplacePageAndGetFromDisk(int id);

        protected abstract Page LoadPage(int id, Page page);

        protected abstract void SaveAndRemovePage(Page page);

        protected abstract Page GetPageWithIdFromDisk(int id);

        protected abstract void SavePage(Page page);
    }
}
