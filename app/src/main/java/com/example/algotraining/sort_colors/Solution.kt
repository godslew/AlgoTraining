package com.example.algotraining.sort_colors

class Solution {
    fun sortColors(nums: IntArray): Unit {
        val colors = IntArray(3) { 0 }
        var index = 0
        nums.forEach {
            colors[it]++
        }
        colors.forEachIndexed { idx, it ->
            for (i in 0 until it) {
                nums[index] = idx
                index++
            }
        }
    }
}

//  one line swap
//  nums[i] = nums[lastIndex].also { nums[lastIndex] = nums[i] }