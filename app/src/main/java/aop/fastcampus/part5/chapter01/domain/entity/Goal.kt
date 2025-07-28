package aop.fastcampus.part5.chapter01.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Goal(
    val id: Int,
    val title: String, // 예: "한달 식비"
    val amount: Long, // 예: 500000
    val category: String, // 예: "식비"
    val period: String // 예: "MONTHLY"
)
