using System;
namespace JumpingKangaroosImplementation
{
    public class JumpingKangaroos
    {

        public static bool IsCompletable(int[] nums)
        {
            int farthest = nums[0];
        
            for(int i = 0; i < nums.Length; i++)
            {
                if(i > farthest)
                    return false;
                
                farthest = Math.Max(farthest, i + nums[i]);
                if(farthest > nums.Length)
                    return true;
            }
        
            return true;
        }

        public static int GetMinimalNumberOfJumps(int[] nums)
        {
            int n = nums.Length;
            int jumpCount = 0, reach = 0, next = 0;
            
            if (IsCompletable(nums) == false) {
                return jumpCount;
            }

            for (int i = 0; i < n && reach < n - 1; i++)
            {
                next = Math.Max(next, nums[i] + i);
                
                if (i == reach)
                {
                    reach = next;
                    jumpCount++;
                }
            }
            
            return jumpCount;
        }
        
    }
}