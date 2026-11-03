class Solution {

    public int robbery(int[] nums, int index, int[] dp) {

        if (index >= nums.length) {
            return 0;
        }
        else if (dp[index] != -1) {
            return dp[index];
        }

        int rob = robbery(nums, index + 2, dp);
        int nonRob = robbery(nums, index + 1, dp);

        int ans = Math.max(nums[index] + rob, nonRob);

        dp[index] = ans;
        return ans;
    }

    public int rob(int[] nums) {

        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }

        return dp[nums.length];
    }
}