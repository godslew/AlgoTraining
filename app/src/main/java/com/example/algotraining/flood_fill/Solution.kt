package com.example.algotraining.flood_fill

class Solution {
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        if (image.size - 1 < sr) return image
        if (image[sr].size - 1 < sc) return image
        val targetColor = image[sr][sc]
        if (targetColor == color) return image
        image[sr][sc] = color
        return dfs(targetColor, image, sr, sc, color)
    }

    private fun dfs(
        targetColor: Int,
        image: Array<IntArray>,
        sr: Int,
        sc: Int,
        color: Int
    ): Array<IntArray> {
        val dfs1 = if (sr - 1 >= 0 && image[sr - 1][sc] == targetColor) {
            image[sr - 1][sc] = color
            dfs(targetColor, image, sr - 1, sc, color)
        } else {
            image
        }

        val dfs2 = if (sr + 1 < dfs1.size && dfs1[sr + 1][sc] == targetColor) {
            dfs1[sr + 1][sc] = color
            dfs(targetColor, dfs1, sr + 1, sc, color)
        } else {
            dfs1
        }

        val dfs3 = if (sc - 1 >= 0 && dfs2[sr][sc - 1] == targetColor) {
            dfs2[sr][sc - 1] = color
            dfs(targetColor, dfs2, sr, sc - 1, color)
        } else {
            dfs2
        }

        val dfs4 = if (sc + 1 < dfs3[sr].size && dfs3[sr][sc + 1] == targetColor) {
            dfs3[sr][sc + 1] = color
            dfs(targetColor, dfs3, sr, sc + 1, color)
        } else {
            dfs3
        }
        return dfs4
    }
}