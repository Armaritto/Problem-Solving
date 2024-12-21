class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        Solver solver = new Solver();
        int n = startTime.length;
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = startTime[i];
            arr[i][1] = endTime[i];
            arr[i][2] = profit[i];
        }
        return solver.solve(arr);
    }
}
class Solver{
    private int[] dp;
    private int[][] arr;
    private int getPrev(int i){
        for(int j=i-1;j>=0;j--){
            if(arr[j][1] <= arr[i][0])
                return j;
        }
        return -1;
    }
    private int topDownWightedActivitySelection(int[][] arr, int i){
        if (i==-1)
            return 0;
        if(i==0)
            return arr[0][2];
        if(dp[i]>0)
            return dp[i];
        dp[i] = Math.max(
            topDownWightedActivitySelection(arr,i-1),
            arr[i][2] + topDownWightedActivitySelection(arr,getPrev(i))
        );
        return dp[i];
    }
    public int solve(int[][] arr){
        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));
        this.dp = new int[arr.length];
        this.arr = arr;
        Arrays.fill(dp,-1);
        return topDownWightedActivitySelection(arr,arr.length-1);
    }
}