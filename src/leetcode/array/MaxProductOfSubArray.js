var maxProduct = function(nums) {

    let maxI = Number.MIN_SAFE_INTEGER;
    let prod = 1;

    for (let i = 0; i < nums.length; i++) {
        prod *= nums[i];
        maxI = Math.max(prod, maxI);
        if(prod == 0) prod = 1;
    }

    prod = 1;
    for(let i = nums.length - 1; i >= 0; i--) {
        prod *= nums[i];

        maxI = Math.max(prod, maxI);
        if(prod == 0) prod = 1;
    }

    return maxI;
};