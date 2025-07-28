package aop.fastcampus.part5.chapter01.domain.budget

import aop.fastcampus.part5.chapter01.data.repository.GoalRepository
import aop.fastcampus.part5.chapter01.data.repository.ToDoRepository
import aop.fastcampus.part5.chapter01.domain.UseCase
import aop.fastcampus.part5.chapter01.domain.entity.Goal
import aop.fastcampus.part5.chapter01.domain.entity.Transaction

internal class GetGoalWithTransactionsUseCase(
    private val goalRepository: GoalRepository
): UseCase {

    suspend operator fun invoke(goalId: Int): Result<Pair<Goal, List<Transaction>>> {
        return goalRepository.getGoalWithTransactions(goalId)
    }

}
