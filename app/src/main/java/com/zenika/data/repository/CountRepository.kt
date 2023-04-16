package com.zenika.data.repository

import com.zenika.data.dao.CountDao
import com.zenika.data.model.CountDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CountRepository @Inject constructor(
    private val dao: CountDao
) {
    fun observeCurrentCount(): Flow<Int?> = dao.observeCount().map { it?.value }

    suspend fun setCount(count: Int) {
        val newCountDto = dao.getCount()
            ?.copy(value = count)
            ?: CountDto(0, count)
        dao.upsert(newCountDto)
    }
}
