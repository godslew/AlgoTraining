package com.example.algotraining.merge_intervals

class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val rangeList = mutableListOf<IntArray>()
        val sorted = intervals.sortedBy {
            it[0]
        }
        sorted.forEach { it ->
            var isAdd = true
            val start = it[0]
            val end = it[1]
            for (i in rangeList.indices) {
                val r = rangeList[i]
                if (start <= r[1]) {
                    rangeList[i] = IntArray(2) { index ->
                        when (index) {
                            0 -> r[0]
                            else -> maxOf(r[1], end)
                        }
                    }
                    isAdd = false
                    break
                }
            }
            if (isAdd) rangeList.add(it)
        }
        return rangeList.toTypedArray()
    }
}