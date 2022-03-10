export function isCompletable(nums){
    let last = nums.length - 1;
    for (let i = last - 1; i >= 0; i--) {
        if (i + nums[i] >= last) {
            last = i;
        };
    };
    return last === 0;
}

export function getMinimalNumberOfJumps(nums){
    let globalMax = 0;
    let localMax = 0;
    let step = 0;

    for (let i = 0; i < nums.length - 1; i++) {
        if (localMax < i) {
            return -1;
        }
        if (localMax > nums.length - 1) {
            break;
        }
        const cur = i + nums[i];
        globalMax = Math.max(globalMax, cur);
        if (localMax == i) {
            localMax = globalMax;
            step++;
        }
    }

    if (isCompletable(nums) === false) {
        return 0;
    }

    return step;
}