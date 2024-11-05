import java.lang.reflect.Array;
import java.util.Arrays;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int[] matrices = {10, 20, 5, 10, 5};
        int length = matrices.length;
        int[][] dp= new int[length+1][length+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],-1);

        }
        System.out.println("Recursion: " + recursion(matrices, 1, length - 1));
        System.out.println("Memoization: " + memoization(matrices, 1, length - 1,dp));

    }

    static int recursion(int[] arr, int i, int j) {
        // Base Case: if there's only one matrix, no multiplication is needed
        if (i >= j) return 0;

        // Initialize minimum cost
        int min = Integer.MAX_VALUE;

        // Try all possible places to split the matrices
        for (int k = i; k < j; k++) {
            // Cost of multiplying the matrices split at k
            int temp = recursion(arr, i, k) + recursion(arr, k + 1, j)
                    + arr[i - 1] * arr[k] * arr[j];

            // Find the minimum cost
            min = Math.min(min, temp);
        }
        return min;
    }

    //Memoization
    static int memoization(int[] arr,int i,int j,int[][] dp){
        if(i>=j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int min=Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp=memoization(arr,i,k,dp)+memoization(arr,k+1,j,dp)+arr[i-1]*arr[k]*arr[j];
            min=Math.min(temp,min);
        }
        return dp[i][j] = min;
    }
}
