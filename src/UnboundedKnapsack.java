public class UnboundedKnapsack {
    //By Rod Cutting Problem
    public static void main(String[] args) {
        int[] len={1,2,3,4,5,6,7,8,9,10};
        int[] profit={1,5,8,9,10,17,17,20,24,30};
        int max_len=10;
        int[][] dp=new int[len.length+1][len.length+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j]=-1;
            }
        }
        System.out.println("Recursive: "+recursive(len,profit,max_len,len.length));
        System.out.println("Bottom Up: "+bottom_up(len,profit,max_len,len.length,dp));

        //Top Down
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if(i==0||j==0) dp[i][j]=0;
                else if(len[i-1]<=j) dp[i][j]=Math.max((profit[i-1]+dp[i][j-len[i-1]]),dp[i-1][j]);
                else dp[i][j]=dp[i-1][j];

            }
        }
        System.out.println("Top Down: "+dp[dp.length-1][dp.length-1]);

    }

    //recursive approach
    static int recursive(int[] len, int[] profit,int max_len,int n){
        if (n==0||max_len==0) return 0;
        else if(len[n-1]<=max_len) return Math.max(profit[n-1]+recursive(len,profit,max_len-len[n-1],n),recursive(len,profit,max_len,n-1));
        else return recursive(len,profit,max_len,n-1);
    }

    //bottom up approach
    static int bottom_up(int[] len, int[] profit,int max_len,int n,int[][]dp){
        if (n==0||max_len==0) dp[n][max_len]= 0;
        if(dp[n][max_len]!=-1) return dp[n][max_len];
        if(len[n-1]<=max_len){
            return dp[n][max_len] = Math.max(profit[n-1]+bottom_up(len,profit,max_len-len[n-1],n,dp),bottom_up(len,profit,max_len,n-1,dp));
        }
        else {
            return dp[n][max_len]=bottom_up(len,profit,max_len,n-1,dp);
        }

    }


}
