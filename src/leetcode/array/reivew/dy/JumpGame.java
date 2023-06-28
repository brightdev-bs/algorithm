package leetcode.array.reivew.dy;

// pass
public class JumpGame {

    public boolean canJump(int[] nums) {
        int idx = 0;
        int max = 0;
        int len = nums.length;
        while(idx <= max && idx < len) {
            max = Math.max(max, idx + nums[idx]);
            if(max >= len - 1) return true;
            idx++;
        }

        return false;
    }
}
