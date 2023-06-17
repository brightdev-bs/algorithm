var twoSum = function(nums, target) {

    let map = new Map();
    for(let i = 0; i < nums.length; i++) {
        let num = target - nums[i];
        if(map.has(num)) {
            return new Array(i, map.get(num));
        }
        map.set(nums[i], i);
    }
};

console.log(twoSum(new Array(2, 7, 11, 15), 9));
