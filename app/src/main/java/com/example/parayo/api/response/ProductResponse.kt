package com.example.parayo.api.response

/**
 * Created by KSW on 2020-08-27
 */

data class ProductResponse(
    val id: Long,
    val name: String,
    val description: String,
    val price: Int,
    val status: String,
    val sellerId: Long,
    val imagePaths: List<String>
)