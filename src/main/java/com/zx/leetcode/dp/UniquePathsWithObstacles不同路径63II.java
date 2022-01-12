package com.zx.leetcode.dp;

/**
 * @author zhangxin
 * @date 2022-01-06 1:18
 */
public class UniquePathsWithObstacles不同路径63II {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int heigth = obstacleGrid.length;
        int wide = obstacleGrid[0].length;

        int[][] dp = new int[heigth][wide];

        for (int i=0;i<heigth;i++){
            if (obstacleGrid[i][0]==1){
                break;
            }else {
                dp[i][0]=1;
            }
        }

        for (int i=1;i<wide;i++){
            if (obstacleGrid[0][i]==1){
                break;
            }else {
                dp[0][i]=1;
            }
        }

        for (int i=1;i<heigth;i++){
            for (int j=1;j<wide;j++){
                if (obstacleGrid[i][j]==1){
                    continue;
                }      else {
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }

        return dp[heigth-1][wide-1];

    }

    public static void main(String[] args) {
        int[][] dp = new int[][]{{0,1},{0,0}};

        uniquePathsWithObstacles(dp);
    }
}
