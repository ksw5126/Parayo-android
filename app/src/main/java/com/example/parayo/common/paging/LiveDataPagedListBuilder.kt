package com.example.parayo.common.paging

import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.paging.DataSource

/**
 * Created by KSW on 2020-08-27
 */

interface LiveDataPagedListBuilder<K, T> {

    fun createDataSource() : DataSource<K, T>

    private fun factoty() = object :
        DataSource.Factory<K,T>() {
        override fun create() : DataSource<K, T> = createDataSource()
    }

    private fun config() = PagedList.Config.Builder()
        .setPageSize(10)
        .setEnablePlaceholders(false)
        .build()

    fun buildPagedList() = LivePagedListBuilder(factoty(), config()).build()

}