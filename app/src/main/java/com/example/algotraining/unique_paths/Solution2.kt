package com.example.algotraining.unique_paths

class Solution2 {
    fun uniquePaths(m: Int, n: Int): Int {
        val dp = Array(m) { IntArray(n) { 0 } }
        dp[0][0] = 1
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (i - 1 < 0) continue
                if (j - 1 < 0) continue
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
            }
        }
        return dp[m - 1][n - 1]
    }
}