import java.util.Arrays;

public class LongestCommonSubSequence {
    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        char[] arr2 = {'a', 'c', 'd', 'e', 'f', 'g'};
        int n = arr.length;
        int m = arr2.length;

        // Adjust dp array size to be (n+1) x (m+1)
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        // Start from ends and check conditions
        System.out.println("Recursion: " + recursion(arr, arr2, n, m));
        System.out.println("Memoization: " + memoization(arr, arr2, n, m, dp));

        //TopDown
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if(i==0||j==0) dp[i][j]=0;
                else if (arr[i-1] == arr2[j-1]) dp[i][j] = 1 + dp[i-1][j-1];
                else {
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        System.out.println("Top Down: " + dp[n][m]);


    }

    // Recursion
    static int recursion(char[] arr1, char[] arr2, int n, int m) {
        if (n == 0 || m == 0) return 0;
        if (arr1[n - 1] == arr2[m - 1])
            return 1 + recursion(arr1, arr2, n - 1, m - 1);
        else
            return Math.max(recursion(arr1, arr2, n - 1, m), recursion(arr1, arr2, n, m - 1));
    }

    // Memoization
    static int memoization(char[] arr1, char[] arr2, int n, int m, int[][] dp) {
        if (n == 0 || m == 0) return 0;

        // Check if result is already calculated
        if (dp[n][m] != -1) return dp[n][m];

        if (arr1[n - 1] == arr2[m - 1])
            dp[n][m] = 1 + memoization(arr1, arr2, n - 1, m - 1, dp);
        else
            dp[n][m] = Math.max(memoization(arr1, arr2, n - 1, m, dp), memoization(arr1, arr2, n, m - 1, dp));

        return dp[n][m];
    }
}
