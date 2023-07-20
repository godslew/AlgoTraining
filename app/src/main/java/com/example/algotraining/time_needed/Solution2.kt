package com.example.algotraining.time_needed

class Solution2 {
    private var maxTime = 0
    fun numOfMinutes(n: Int, headID: Int, manager: IntArray, informTime: IntArray): Int {
        if (n == 1) return maxTime
        calc(headID, manager, informTime, informTime[headID])
        return maxTime
    }

    private fun calc(id: Int, manager: IntArray, informTime: IntArray, sum: Int) {
        val bukas = manager.filter { it == id }
        for ((index, _) in bukas.withIndex()) {
            if (informTime[index] == 0) {
                if (sum > maxTime) {
                    maxTime = sum
                }
                continue
            }
            calc(index, manager, informTime, sum + informTime[index])
        }
    }
}