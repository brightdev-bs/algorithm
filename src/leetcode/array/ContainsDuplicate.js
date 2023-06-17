var containsDuplicate = function(nums) {
    let map = new Map();
    for(const num of nums) {
        if(map.has(num)) return true;
        map.set(num, (map.get(num) || 0) + 1);
    }
    return false;
};

console.log(containsDuplicate([1, 2, 3, 1]));

var containsDuplicate2 = function(nums) {
    let map = new Set();
    for(const num of nums) {
        if(map.has(num)) return true;
        map.add(num);
    }
    return false;
};
