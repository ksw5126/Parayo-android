package com.example.parayo.product.registration

import com.example.parayo.api.ParayoApi
import com.example.parayo.api.response.ApiResponse
import com.example.parayo.api.response.ProductImageUploadResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.error
import java.io.File
import java.lang.Exception

/**
 * Created by KSW on 2020-08-25
 */

class ProductImageUploader : AnkoLogger {

    suspend fun upload(imageFile: File) = try {
        val part = makeImagePart(imageFile)
        withContext(Dispatchers.IO) {
            ParayoApi.instance.uploadProductImage(part)
        }
    } catch (e: Exception) {
        error("상품 이미지 등록 오류", e)
        ApiResponse.error<ProductImageUploadResponse>(
            "알 수 없는 오류가 발생"
        )
    }

    private fun makeImagePart(imageFile: File): MultipartBody.Part {
        val mediaType = MediaType.parse("multipart/from-data")
        val body = RequestBody.create(mediaType, imageFile)

        return MultipartBody.Part
            .createFormData("image", imageFile.name, body)
    }


}