package aop.fastcampus.part5.chapter01.domain.budget

import aop.fastcampus.part5.chapter01.data.repository.GoalRepository
import aop.fastcampus.part5.chapter01.data.repository.ToDoRepository
import aop.fastcampus.part5.chapter01.domain.UseCase
import aop.fastcampus.part5.chapter01.domain.entity.Goal

internal class CheckOverspendingUseCase(
    private val goalRepository: GoalRepository
): UseCase {

    suspend operator fun invoke(): List<Goal> {
        // ... 예산 초과 예측 로직 구현 ...
        // (현재까지의 지출 / 오늘 날짜) * 30 > 목표 예산 인 경우
        return goalRepository.getOverspendingGoals()
    }

}
