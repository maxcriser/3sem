using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Swapping
{
    public class ClockCache : AbstractCache, ICache
    {
        private int MaxPages;
        private int PointerIndex;
        private RingList<Page> Pages;

        public ClockCache(int max)
        {
            MaxPages = max;
            Pages = new RingList<Page>();
            PointerIndex = -1;
        }

        public Page GetPage(int id)
        {
            Page page = GetPageFromMemory(id);
            if (page != null)
            {
                return page;
            }
            else if (Pages.Count < MaxPages)
            {
                PointerIndex = 0;
                return GetPageWithIdFromDisk(id);
            }
            else
            {
                return ReplacePageAndGetFromDisk(id);
            }
        }

        protected override Page GetPageFromMemory(int id)
        {
            if (Pages.Count == 0) return null;
            for(int i = 0; i < Pages.Count; i++){
                if (Pages[i].Id == id)
                {
                    return Pages[i];
                }
            }
            return null;
        }

        protected override Page ReplacePageAndGetFromDisk(int id)
        {
            Page returnPage = null;
            Pages.RingRestart += (int times) => { return times >= 1; };
            Pages.Iterate((Page page, int index) =>
            {
                if (!Pages[index].IsReadRecently())
                {
                    returnPage = LoadPage(id, Pages[index]);    
                    return true;
                }
                PointerIndex = index;
                return false;                
            }, PointerIndex);
            if (returnPage == null)
            {
                returnPage = LoadPage(id, Pages[PointerIndex]);
            }
            return returnPage;
        }

        protected override Page LoadPage(int id, Page page)
        {
            SaveAndRemovePage(page);
            return GetPageWithIdFromDisk(id);
        }

        protected override void SaveAndRemovePage(Page page)
        {
            if (page.IsModified())
            {
                SavePage(page);
            }
            for (int i = 0; i < Pages.Count; i++)
            {
                if (page.Id == Pages[i].Id)
                {
                    Pages.RemoveAt(i);
                    break;
                }
            }
        }

        protected override Page GetPageWithIdFromDisk(int id)
        {
            //load page with Id = id and return
            Page page = new Page(id);
            Pages.Add(page);
            return page;
        }

        protected override void SavePage(Page page)
        {
            //saved
        }

        public Page GetRandomExistingPage()
        {
            if (Pages.Count > 0)
            {
                Random random = new Random();
                return Pages[random.Next(Pages.Count)];
            }
            else
            {
                return null;
            }
        }

        public void Live()
        {
            for (int i = 0; i < Pages.Count; i++)
            {
                Pages[i].Live();
            }
        }

        public bool IsInCache(int id)
        {
            for (int i = 0; i < Pages.Count; i++)
            {
                if (id == Pages[i].Id)
                {
                    return true;
                }
            }
            return false;
        }
    }
}