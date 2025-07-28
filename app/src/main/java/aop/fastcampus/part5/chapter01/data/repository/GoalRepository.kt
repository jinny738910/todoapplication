package aop.fastcampus.part5.chapter01.data.repository

import aop.fastcampus.part5.chapter01.data.entity.ToDoEntity
import aop.fastcampus.part5.chapter01.domain.entity.Goal
import aop.fastcampus.part5.chapter01.domain.entity.Transaction

interface GoalRepository {

    suspend fun getGoalWithTransactions(goalId: Int): Result<Pair<Goal, List<Transaction>>>
    suspend fun insertGoal(goal: Goal): Result<Unit> // 추가
    suspend fun getOverspendingGoals(): List<Goal> // 추가

}
