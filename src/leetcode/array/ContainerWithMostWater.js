var maxArea = function(height) {
    const n = height.length;
    let max = 0;
    for (let left = 0, right = n - 1; left < right; ) {

        const area = (right - left) * Math.min(height[right], height[left]);
        max = Math.max(area, max);

        if(height[left] > height[right]) right--;
        else left++;
    }

    return max;
};