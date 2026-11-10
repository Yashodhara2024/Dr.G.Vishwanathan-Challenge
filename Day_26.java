LeetCode Problem 164 : Maximum Gap
Given an integer array nums, return the maximum difference between two successive elements in its sorted form. If the array contains less than two elements, return 0.
You must write an algorithm that runs in linear time and uses linear extra space.

Example 1:
Input: nums = [3,6,9,1]
Output: 3

Code:
import java.util.Arrays;
class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int maxGap = 0;
        for (int i = 1; i < nums.length; i++) {
            maxGap = Math.max(maxGap, nums[i] - nums[i - 1]);
        }
        return maxGap;
    }
}

