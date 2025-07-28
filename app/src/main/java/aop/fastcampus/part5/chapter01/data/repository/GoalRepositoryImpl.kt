package aop.fastcampus.part5.chapter01.data.repository

import aop.fastcampus.part5.chapter01.data.entity.ToDoEntity
import aop.fastcampus.part5.chapter01.domain.entity.Goal
import aop.fastcampus.part5.chapter01.domain.entity.Transaction

interface GoalRepositoryImpl(
    private val myDataApi: MyDataApi,
    private val goalDao: GoalDao
) : GoalRepository {

    override suspend fun getGoalWithTransactions(goalId: Int): Result<Pair<Goal, List<Transaction>>> {
        return try {
            // 1. Room DB에서 목표 정보 가져오기
            val goal = goalDao.getGoalById(goalId)

            // 2. MyData API에서 이번 달 지출 내역 가져오기
            val transactions = myDataApi.getTransactions(getThisMonthStart(), getToday())
                .filter { it.category == goal.category } // 목표와 같은 카테고리의 지출만 필터링

            Result.success(goal to transactions.map { it.toDomainModel() })
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}
