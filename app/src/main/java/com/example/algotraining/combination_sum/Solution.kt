package com.example.algotraining.combination_sum

import java.util.LinkedList

class Solution {
    private val result = LinkedList<List<Int>>()
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val sorted = candidates.sorted()
        for (n in sorted) {
            candidates(
                n,
                sorted,
                target - n,
                listOf(n),
            )
        }
        return result
    }

    private fun candidates(
        base: Int,
        candidates: List<Int>,
        target: Int,
        list: List<Int>,
    ) {
        if (target == 0) {
            result.add(list)
            return
        }

        if (target < 0) return

        for (i in candidates) {
            if (target - i < 0) break
            if (i >= base) {
                candidates(i, candidates, target - i, list.plus(i))
            }
        }
    }
}