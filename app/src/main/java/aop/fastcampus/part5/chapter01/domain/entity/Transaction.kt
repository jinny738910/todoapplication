package aop.fastcampus.part5.chapter01.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class Transaction(
    val id: String,
    val amount: Long,
    val category: String, // "식비", "교통" 등
    val transactionDate: Date
)
