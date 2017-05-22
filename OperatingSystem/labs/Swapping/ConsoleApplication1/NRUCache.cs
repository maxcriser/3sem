using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Swapping
{
    class NRUCache : AbstractCache, ICache
    {
        private List<Page> Pages;
        private int MaxPages;

        public NRUCache(int max)
        {
            MaxPages = max;
            Pages = new List<Page>();
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
                return GetPageWithIdFromDisk(id);
            }
            else
            {
                return ReplacePageAndGetFromDisk(id);
            }
        }

        protected override Page GetPageFromMemory(int id)
        {
            for (int i = 0; i < Pages.Count; i++)
            {
                if (Pages[i].Id == id)
                {
                    Pages[i].Read();
                    return Pages[i];
                }
            }
            return null;
        }

        protected override Page ReplacePageAndGetFromDisk(int id)
        {
            Page pageC0 = null;
            Page pageC1 = null;
            Page pageC2 = null;
            Page pageC3 = null;
            foreach (var page in Pages)
            {
                if (pageC0 != null && pageC1 != null && pageC2 != null && pageC3 != null)
                {
                    break;
                }
                if (pageC0 == null && page.GetClass() == Page.PageClass.C0)
                {
                    pageC0 = page;
                }
                if (pageC1 == null && page.GetClass() == Page.PageClass.C1)
                {
                    pageC1 = page;
                }
                if (pageC2 == null && page.GetClass() == Page.PageClass.C2)
                {
                    pageC2 = page;
                }
                if (pageC3 == null && page.GetClass() == Page.PageClass.C3)
                {
                    pageC3 = page;
                }
            }
            if (pageC0 != null) return LoadPage(id, pageC0);
            if (pageC1 != null) return LoadPage(id, pageC1);
            if (pageC2 != null) return LoadPage(id, pageC2);
            if (pageC3 != null) return LoadPage(id, pageC3);

            //unreachable statement
            return null;
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
