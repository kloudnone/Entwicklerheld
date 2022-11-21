using System;
using System.Collections.Generic;
using System.Linq;

namespace ChristmasBoxesImplementation
{
    class WeightComparer : IComparer<ChristmasBox>
    {
        public int Compare(ChristmasBox a, ChristmasBox b)
        { 
            if (a.Weight > b.Weight) {
                return -1;
            } else if (a.Weight < b.Weight) {
                return 1;
            } else {
                return 0;
            }
        }
    }
  

    public static class ChristmasBoxService
    {
        public static IEnumerable<ChristmasBox> GetShuffledPresentList(this List<ChristmasBox> boxList)
        {
            List<ChristmasBox> tmpList = boxList.ToList();

            // sort list first
            WeightComparer comparer = new WeightComparer();
            tmpList.Sort(comparer);

            for (int i = 0; i < boxList.Count; i++) {
                if ((i + 1) % 4 == 2) {
                    ChristmasBox firstBox = tmpList.First();
                    boxList[i] = firstBox;
                    tmpList.Remove(firstBox);
                } else {
                    ChristmasBox lastBox = tmpList.Last();
                    boxList[i] = lastBox;
                    tmpList.Remove(lastBox);
                }
            }
            
            return boxList;
        }
    }
    
}