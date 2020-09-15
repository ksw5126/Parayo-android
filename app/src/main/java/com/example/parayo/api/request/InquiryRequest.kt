package com.example.parayo.api.request

/**
 * Created by KSW on 2020-09-15
 */


data class InquiryRequest(
    val type: String, // QUESTION, ANSWER
    val inquiryId: Long?,
    val productId: Long,
    val content: String?
) {
    val isContentEmpty = content.isNullOrEmpty()
}