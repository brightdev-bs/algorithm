var maxProfit = function(prices) {
    let max = 0;
    let minNum = prices[0];
    for (let i = 0; i < prices.length; i++) {
        minNum = Math.min(minNum, prices[i]);
        max = Math.max(max, prices[i] - minNum);
    }
};

console.log(maxProfit([7, 1, 5, 3, 6, 4]));