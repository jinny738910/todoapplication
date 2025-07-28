package aop.fastcampus.part5.chapter01.data.local.db.dao

import androidx.room.*
import aop.fastcampus.part5.chapter01.data.entity.ToDoEntity
import aop.fastcampus.part5.chapter01.domain.entity.Goal
import kotlinx.coroutines.flow.Flow

@Dao
interface GoalDao {

    @Insert
    suspend fun insertGoal(goal: Goal)

    @Query("SELECT * FROM goals WHERE id = :goalId")
    suspend fun getGoalById(goalId: Int): Goal

    @Query("SELECT * FROM goals")
    fun getAllGoals(): Flow<List<Goal>>

}
