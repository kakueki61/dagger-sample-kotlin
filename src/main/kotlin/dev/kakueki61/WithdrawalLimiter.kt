package dev.kakueki61

import dev.kakueki61.di.qualifier.MaximumWithdrawal
import dev.kakueki61.di.scope.PerSession
import java.math.BigDecimal
import javax.inject.Inject

@PerSession
class WithdrawalLimiter @Inject constructor(@MaximumWithdrawal var remainingWithdrawal: BigDecimal) {
    init {
        println("Creating a new $this")
    }

    fun recordDeposit(amount: BigDecimal) {
        remainingWithdrawal = remainingWithdrawal.add(amount)
        println("remaining: $remainingWithdrawal")
    }

    fun recordWithdrawal(amount: BigDecimal) {
        remainingWithdrawal = remainingWithdrawal.subtract(amount)
        println("remaining: $remainingWithdrawal")
    }
}