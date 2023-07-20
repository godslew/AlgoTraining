package com.example.algotraining.nearest_exit

class Solution {
    fun nearestExit(maze: Array<CharArray>, entrance: IntArray): Int {
        val queue: MutableList<Pair<Int, Int>> = mutableListOf()
        val visit: MutableMap<Pair<Int, Int>, Int> = mutableMapOf()
        val directions = listOf(Pair(1, 0), Pair(0, 1), Pair(-1, 0), Pair(0, -1))
        var count = 0
        val sr = entrance[0]
        val sc = entrance[1]

        queue.add(Pair(entrance[0], entrance[1]))
        while (queue.isNotEmpty()) {
            val temp = queue.toList()
            for (q in temp) {
                queue.removeAt(0)
                visit[Pair(q.first, q.second)] = -1
                for (dir in directions) {
                    val r = q.first + dir.first
                    val c = q.second + dir.second
                    if (r < 0 || c < 0 || r > maze.size - 1 || c > maze[r].size - 1) {
                        if (q.first == sr && q.second == sc) {
                            continue
                        }
                        return count
                    }
                    if (visit[Pair(r, c)] != null) {
                        continue
                    }
                    if (maze[r][c] != '+') {
                        queue.add(Pair(r, c))
                    }
                }
            }
            count++
        }
        return -1
    }
}