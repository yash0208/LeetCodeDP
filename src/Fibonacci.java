public class Fibonacci {
    public static void main(String[] args) {
        int n=6;
        int[] dp={-1,-1,-1,-1,-1,-1,-1};
        System.out.println("Recursion: "+fibonacci(n));
        System.out.println("Bottom Up: "+fibonacci_bu(n,dp));
        //Top Down
        dp[0]=0;
        dp[1]=1;
        for (int i = 2; i < n; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        System.out.println("Top Down: "+dp[n]);
    }
    //recursion
    static int fibonacci(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        else return fibonacci(n-1)+fibonacci(n-2);
    }
    //bottom up
    static int fibonacci_bu(int n,int[] dp){
        if(n==0) dp[n]=0;
        if(n==1) dp[n]=1;
        if(dp[n]!=-1) return dp[n];
        else{
            dp[n]=fibonacci_bu(n-1,dp)+fibonacci_bu(n-2,dp);
            return dp[n];
        }
    }

}
