package com.example.algotraining.longest_common_subsequence

class Solution2 {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        if (text1.length < text2.length) {
            return longestCommonSubsequence(text2, text1)
        }
        var curr = IntArray(text1.length + 1) { 0 }
        var prev = IntArray(text1.length + 1) { 0 }

        for (i in text1.length - 1 downTo 0) {
            for (j in text2.length - 1 downTo 0) {
                if (text1[i] == text2[j]) {
                    curr[j] = 1 + prev[j + 1]
                } else {
                    curr[j] = maxOf(curr[j + 1], prev[j])
                }
            }
            curr = prev.also { prev = curr }
        }
        return prev[0]
    }
}