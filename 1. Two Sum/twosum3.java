// Data structure
// Two-pointers (left/right)
// Hashmap requires additional space - O(n) for hashmap, while two pointers usually require O(1) 
// Two pointers are useful for sorted data 

// Time complexity
// O(nlogn)
// Iterate throught the array onece to create NumberIndex - O(n)
// Sort the NumberIndex - O(n log n)
// Two points traveral - O(n)

// Space complexity
// O(n)
// NumberArray: stores both the number and its original index for each element - O(n)
// pointers and temporary variables require constant space - O(1) 

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] twoSum3(int[] nums, int target) {
        int n = nums.length;

        // Create an array of NumberIndex objects to store numbers along with their
        // original indices
        NumberIndex[] numIndices = new NumberIndex[n];
        for (int i = 0; i < n; i++) {
            numIndices[i] = new NumberIndex(nums[i], i);
        }

        // Sort the array based on the number values
        Arrays.sort(numIndices, Comparator.comparingInt(a -> a.number));

        // Initialize two pointers
        int left = 0;
        int right = n - 1;

        // Iterate to find the two numbers that add up to the target
        while (left < right) {
            int sum = numIndices[left].number + numIndices[right].number;

            if (sum == target) {
                // Return the original indices
                return new int[] { numIndices[left].index, numIndices[right].index };
            } else if (sum < target) {
                left++; // Need a larger sum
            } else {
                right--; // Need a smaller sum
            }
        }

        // If no solution is found (though the problem guarantees one)
        return new int[] { -1, -1 };
    }

    // for testing
    public static void main(String[] args) {
    }

}

// Helper class to store number and its original index
class NumberIndex {
    int number;
    int index;

    NumberIndex(int number, int index) {
        this.number = number;
        this.index = index;
    }

}
