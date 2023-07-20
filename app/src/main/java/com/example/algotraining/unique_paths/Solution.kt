package com.example.algotraining.unique_paths

import java.math.BigInteger

class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        return (factorial(((m - 1) + (n -1)).toBigInteger()) / factorial((m-1).toBigInteger()) / factorial((n-1).toBigInteger())).toInt()
    }

    private fun factorial(n: BigInteger): BigInteger {
        return if (n <= BigInteger.ZERO) BigInteger.ONE else n * factorial(n.minus(BigInteger.ONE))
    }
}