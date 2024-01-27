class Solution {
    public int kInversePairs(int n, int k) {
        final int Mod = 1000000007;
        int[][] dp = new int[n+1][k+1];
        
        for(int i=1; i <= n; i++){
            for(int j=0; j<= k; j++){
                if(j == 0) dp[i][j] = 1;
                else{
                    int val = (dp[i-1][j] + Mod - (j-i >= 0 ? dp[i-1][j-i] : 0)) % Mod;
                    dp[i][j] = (dp[i][j-1]+val) % Mod;
                }
            }
        }
        return (dp[n][k] + Mod - (k > 0 ? dp[n][k-1] : 0))%Mod;
    }
}