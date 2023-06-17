var findMin = function(nums) {
    let l = 0;
    let r = nums.length - 1;

    while(l < r) {
        const m = Math.floor((l + r) / 2);

        if (nums[m] < nums[r]) r = m;
        else l = m + 1;
    }
    return nums[l];
};

console.log(findMin([3, 4, 5, 1, 2]));