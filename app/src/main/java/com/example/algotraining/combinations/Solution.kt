package com.example.algotraining.combinations

class Solution {
    val list = mutableListOf<List<Int>>()
    fun combine(n: Int, k: Int): List<List<Int>> {
        combine(1, n, k, emptyList())
        return list
    }

    private fun combine(i: Int, n: Int, k: Int, level: List<Int>) {
        if (level.size == k) {
            list.add(level)
        }
        if (i > n) {
            return
        }
        for (j in i..n) {
            combine(j+1, n, k, level.plus(j))
        }
    }
}