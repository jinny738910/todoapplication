package aop.fastcampus.part5.chapter01.data.repository

import androidx.room.Query
import aop.fastcampus.part5.chapter01.data.entity.ToDoEntity
import aop.fastcampus.part5.chapter01.data.local.db.dao.ToDoDao
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

interface MyDataApi {
    @GET("transactions")
    suspend fun getTransactions(
        @Query("startDate") startDate: String,
        @Query("endDate") endDate: String
    ): List<TransactionDto> // API 응답용 데이터 클래스
}
