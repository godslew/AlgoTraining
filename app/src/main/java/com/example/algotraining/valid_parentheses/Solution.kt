package com.example.algotraining.valid_parentheses

class Solution {
    fun isValid(s: String): Boolean {
        val queue = ArrayDeque<Char>()
        s.forEach {
            when (it) {
                '(', '{', '[' -> queue.add(it)
                ')', '}', ']' -> {
                    if (queue.isEmpty()) return false
                    val prev = queue.removeLast()
                    if (!check(prev, it)) return false
                }
            }
        }
        return queue.isEmpty()
    }

    private fun check(c1: Char, c2: Char): Boolean {
        if (c1 == '(') return c2 == ')'
        if (c1 == '{') return c2 == '}'
        if (c1 == '[') return c2 == ']'
        return true
    }
}