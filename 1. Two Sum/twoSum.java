// Time complexity
// O(n^2)
// Nested Loop - outer loop (n) & inner loop (n-1) -> n^2

// Space complexity
// O(1)
// Fixed amount of additional space is used regardless of input size

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // default result value [0,0]
        int[] result = { 0, 0 };

        // two for-loops

        // first loop
        for (int i = 0; i < nums.length; i++) {

            // second loop - if their sum is same as target, update result value (you can
            // return it right away since there is only one valid answer).
            // starts from i+1 because you may not use the same element twice.
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    // return new int[] {i,j}
                }

            }
        }

        return result;

    }
}