var search = function(nums, target) {
    const n = nums.length;
    let lt = 0, rt = n - 1;
    while(lt <= rt) {
        const m = Math.floor((lt + rt) / 2);
        if(nums[m] == target) return m;
        if(nums[lt] <= nums[m]) {
            if(nums[lt] <= target && nums[m] >= target) rt = m - 1;
            else lt = m + 1;
        } else {
            if(nums[rt] >= target && nums[m] <= target) lt = m + 1;
            else rt = m - 1;
        }
    }

    return lt;
};

console.log(search([4, 5, 6, 7, 0, 1, 2], 0));