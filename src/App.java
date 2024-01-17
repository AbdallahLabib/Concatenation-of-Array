public class App {
    public static void main(String[] args) throws Exception {
        int[] intArr = { 1, 2, 3, 4 };
        getConcatenation(intArr);

        // This method is another way to solve this problem that gives me tha ability to specify
        // the # of concatenations, so we can concat it more than 2 times easily
        // concatIntArray(intArr);
    }

    // Time: O(n)
    // Space: O(n)
    public static int[] getConcatenation(int[] nums) {
        // We specified the array length because it was declared in the problem that we need to
        // concat the input array twice 
        int[] ans = new int[2 * nums.length];

        for (int i = 0; i < nums.length; i++) {
            // We start by adding 1st element in nums array inside ans array, so "ans" is [1]
            ans[i] = nums[i];
            // then we add another element in index (i + nums.length), 
            // if (nums.length = 4), then "ans" will be [1, 0, 0, 0, 1]
            ans[i + nums.length] = nums[i];

            //next round will be [1, 2, 0, 0, 1], then [1, 2, 0, 0, 1, 2]
            //third round will be [1, 2, 0, 0, 1, 2], then [1, 2, 3, 0, 1, 2, 3]
            //fourth round will be [1, 2, 3, 0, 1, 2, 3], then [1, 2, 3, 4, 1, 2, 3, 4]
        }
        return ans;
    }
    
    // This method is another way to solve this problem that gives me tha ability to specify
    // the # of concatenations, so we can concat it more than 2 times easily
    // Time: O(n)
    // Space: O(n)
    public static int[] concatIntArray(int[] array) {
        // Calculate the total length of the resulting array
        // For example, if we want to concat it 10 times, then it will be as follows:
        int totalLength = array.length * 10;

        // Create a new array with the total length
        int[] result = new int[totalLength];
        
        // Copy the original array into the result array 10 times
        for (int i = 0; i < 10; i++) {
            // "System.arraycopy" is an efficient way to copy arrays in Java. It is a native method
            //  that is optimized for performance and generally faster than manual array copying loops.
            
            //It takes five parameters:
            // source_arr: The array to be copied from.
            // sourcePos: The starting position in the source array from where to copy.
            // dest_arr: The array to be copied into.
            // destPos: The starting position in the destination array, where to copy in.
            // len: The total number of components to be copied.

            // The components at "sourcePos" to "sourcePos + length – 1" are copied 
            // to "dest_arr" from "destPos" to "destPos + length – 1"

            System.arraycopy(array, 0, result, i * array.length, array.length);
            System.out.println(result[i]);
        }
        
        return result;
    }
}
