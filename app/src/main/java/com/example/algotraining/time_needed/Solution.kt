package com.example.algotraining.time_needed

class Solution {
    fun numOfMinutes(n: Int, headID: Int, manager: IntArray, informTime: IntArray): Int {
        val map = mutableMapOf<Int, List<Int>>()
        manager.forEachIndexed { index, i ->
            if (i != -1) {
                val value = map.getOrDefault(i, emptyList())
                map[i] = value.plus(index)
            }
        }

        return dfs(headID, map, informTime)
    }

    private fun dfs(id: Int, map: MutableMap<Int, List<Int>>, informTime: IntArray): Int {
        var maxTime = 0
        for (i in map.getOrDefault(id, emptyList())) {
            maxTime = maxOf(maxTime, dfs(i, map, informTime))
        }
        return maxTime + informTime[id]
    }
}