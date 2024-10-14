// Data Structure
// HashMap - stores data in key-value pair
// Pro: constant time retrieval O(1), reduced time complexity O(n), no nested loop
// Con : each key in hashmap must be unique 
// Key - actual number from nums array 
// Value - index 
// Q. Why not make index to be a key?
// A. It would invert the purpose of the HashMap. The goal is to quickly find if the complement of the current number exists in the array.
//    Even though it has duplicates, it can correctly identify the pair of indices that sum to the target without using the same element twice.

// Time complexity
// O(n) - the array is traversed once, each lookup and insertion in hashmap takes O(1)

// Space complexity
// O(n) - in worst case, all n elements are stored in the hashmap
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] twoSum2(int[] nums, int target) {
        // Create a HashMap to store number and its index
        Map<Integer, Integer> numToIndex = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if the complement exists in the map
            if (numToIndex.containsKey(complement)) {
                return new int[] { numToIndex.get(complement), i };
            }

            // Add the current number and its index to the map
            numToIndex.put(nums[i], i);
        }

        // If no solution is found, though the problem states there is exactly one
        return new int[] { -1, -1 };
    }

    //for testing
    public static void main(String[] args){
    }
}