var productExceptSelf = function(nums) {
    let answer = new Array();
    for (let i = 0; i < nums.length; i++) {
        let pro = 1;
        for (let j = 0; j < nums.length; j++) {
            if(i == j) continue;
            pro *= nums[j];
        }
        answer[i] = pro;
    }
    return answer;
};

var productExceptSelf2 = function(nums) {
    let n = nums.length;
    let ans = [];
    let pro = 1;
    for(const num of nums) {
        pro *= num;
    }

    for (let i = 0; i < n; i++) {
        ans[i] = pro / nums[i];
    }
    return ans;
};


console.log(productExceptSelf2([1, 2, 3, 4]));
console.log(productExceptSelf2([-1, 1, 0, -3, 3]));

var productExceptSelf3 = function(nums) {
    const n = nums.length;
    let pre = [];
    let suf = [];
    pre[0] = 1;
    suf[n - 1] = 1;

    for(let i = 1; i < n; i++) {
        pre[i] = pre[i - 1] * nums[i - 1];
    }

    for(let i = n - 2; i >= 0; i--) {
        suf[i] = suf[i + 1] * nums[i + 1];
    }

    let ans = [];
    for(let i = 0; i < n; i++) {
        ans[i] = pre[i] *suf[i];
    }
    return ans;

};
console.log(productExceptSelf3([1, 2, 3, 4]));
console.log(productExceptSelf3([-1, 1, 0, -3, 3]));

var productExceptSelf4 = function(nums) {
    const n = nums.length;
    let ans = new Array(n).fill(1);
    let cur = 1;

    for(let i = 0; i < n; i++) {
        ans[i] *= cur;
        cur *= nums[i];
    }

    cur = 1;
    for(let i = n - 1; i >= 0; i--) {
        ans[i] *= cur;
        cur *= nums[i];
    }

    return ans;

};

console.log(productExceptSelf4([1, 2, 3, 4]));
console.log(productExceptSelf4([-1, 1, 0, -3, 3]));