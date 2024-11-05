public class KnapSack01 {
    public static void main(String[] args) {

        int[] weight = {1, 3, 4, 5};
        int[] value = {1, 4, 5, 7};
        int capacity = 7;

        // Correct dp array size: [number of items + 1][capacity + 1]
        int[][] dp = new int[weight.length + 1][capacity + 1];

        // Initialize dp array with -1 for memoization
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println("Bottom Up: " +knapSack(weight, value, capacity, weight.length, dp));

        //knapsack topdown
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;  // Base case: no items or zero capacity
                } else if (weight[i - 1] <= j) {  // Check if the item can fit in the knapsack
                    dp[i][j] = Math.max(value[i - 1] + dp[i - 1][j - weight[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];  // If item can't fit, skip it
                }
            }
        }
        System.out.println("Top Down: " + dp[dp.length - 1][dp[0].length - 1]);


    }


    static int knapSack(int[] weight, int[] value, int capacity, int n, int[][] dp) {
        // Base case: no items left or no remaining capacity
        if (n == 0 || capacity == 0) return 0;

        // If value is already computed, return it
        if (dp[n][capacity] != -1) return dp[n][capacity];

        // If the weight of the current item can be included
        if (weight[n - 1] <= capacity) {
            // Store the maximum of either including or excluding the item
            dp[n][capacity] = Math.max(
                    value[n - 1] + knapSack(weight, value, capacity - weight[n - 1], n - 1, dp),
                    knapSack(weight, value, capacity, n - 1, dp)
            );
        } else {
            // If the current item cannot be included, skip it
            dp[n][capacity] = knapSack(weight, value, capacity, n - 1, dp);
        }

        return dp[n][capacity];
    }
}
