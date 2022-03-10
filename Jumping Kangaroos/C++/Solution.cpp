#include "JumpingKangaroos.hpp"

bool JumpingKangaroos::isCompleteable(std::vector<int> nums){
    int n=nums.size();
    int i=0, reach=0;
    for(; i<n && i<=reach; i++)
        reach=max(reach, i+nums[i]);
    return reach+1>=n;
}

int JumpingKangaroos::getMinimalNumberOfJumps(std::vector<int> nums){
    int res = 0;
    int pos = 0;
    int des = 0;

    if (isCompleteable(nums) == false) {
        return res;
    }

    for(int i = 0;i<nums.size()-1;i++)
    {
        des = max(des,i + nums[i]);    
        if(pos == i)
        {
            res++;
            pos = des;
        }
    }
    return res;
}