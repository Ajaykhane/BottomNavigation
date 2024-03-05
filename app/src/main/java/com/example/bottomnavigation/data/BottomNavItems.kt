package com.example.bottomnavigation.data

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItems(
    val title : String,
    val selectedicon : ImageVector,
    val unselectedicon : ImageVector,
    val batchCount : Int? = null,
    val hasnews : Boolean)
