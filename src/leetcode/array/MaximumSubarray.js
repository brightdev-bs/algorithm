var maxSubArray = function(nums) {
    let curMax = Number.MIN_SAFE_INTEGER, sumMax = Number.MIN_SAFE_INTEGER;

    for (const num of nums) {
        curMax = Math.max(num, num + curMax);
        sumMax = Math.max(sumMax, curMax);
    }

    return sumMax;
};

console.log(maxSubArray([-2,1,-3,4,-1,2,1,-5,4]));
console.log(maxSubArray([-1]));