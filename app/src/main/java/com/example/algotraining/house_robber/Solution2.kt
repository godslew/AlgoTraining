package com.example.algotraining.house_robber

class Solution2 {
    fun rob(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        if (nums.size == 1) return nums[0]

        var prev = 0
        var current = 0
        for (i in nums) {
            val temp = maxOf(prev+i, current)
            prev = current
            current = temp
        }
        return current
    }
}