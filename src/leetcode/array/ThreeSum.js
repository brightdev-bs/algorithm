var threeSum = function(nums) {
    nums.sort();
    let target = 0;
    let s = [];

    for (let i = 0; i < nums.length; i++) {
        let j = i + 1;
        let k = nums.length - 1;
        while(j < k) {
            let sum = nums[i] + nums[j] + nums[k];
            if(sum == target) {
                s.push([nums[i], nums[j], nums[k]]);
                j++;
                k--;
            } else if(sum < target) {
                j++;
            } else {
                k--;
            }
        }

        return new Array(s);
    }
};

console.log(threeSum([-1,0,1,2,-1,-4]));