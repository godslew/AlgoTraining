package com.example.algotraining.house_robber

class Solution {
    private val chache = mutableMapOf<Int, Int>()
    fun rob(nums: IntArray): Int {
        val max = IntArray(1) { 0 }
        if (nums.sum() == 0) return max[0]
        rob(nums, nums.lastIndex, 0, max)
        return max[0]
    }

    fun rob(nums: IntArray, index: Int, sum: Int, max: IntArray) {
        if (index < 0) {
            if (sum > max[0]) {
             max[0] = sum
            }
            return
        }
        if ((chache[index] ?: 0) > sum) {
            return
        }
        rob(nums, index - 2, sum + nums[index], max)
        chache[index] = sum
        if (index - 1 >= 0) {
            rob(nums, index - 3, sum + nums[index - 1], max)
            chache[index - 1] = sum
        }
    }
}

/*
fun rob(nums: IntArray): Int {
        var money = 0
        var index = nums.lastIndex
        while (0 <= index) {
            if (0 <= index - 2) {
                if (nums[index] >= nums[index - 1]) {
                    money += nums[index]
                } else if (nums[index - 1] >= nums[index - 2]) {
                    if (nums[index] + nums[index - 2] > nums[index-1]) {
                        money += nums[index]
                    } else {
                        index -= 1
                        money += nums[index]
                    }
                } else {
                    money += nums[index]
                }
            } else if (0 <= index - 1) {
                if (nums[index] >= nums[index - 1]) {
                    money += nums[index]
                } else {
                    money += nums[index - 1]
                }
            } else if (index == 0){
                money += nums[index]
            }
            index -= 2
        }
        return money
        }
 */