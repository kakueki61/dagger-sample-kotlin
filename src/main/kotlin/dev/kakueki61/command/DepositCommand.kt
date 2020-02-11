package dev.kakueki61.command

import dev.kakueki61.Database
import dev.kakueki61.Outputter
import dev.kakueki61.WithdrawalLimiter
import java.math.BigDecimal
import javax.inject.Inject

class DepositCommand
@Inject
constructor(
    private val account: Database.Account,
    private val outputter: Outputter,
    private val withdrawalLimiter: WithdrawalLimiter
    ) : BigDecimalCommand(outputter) {
    init {
        println("Creating a new $this")
    }

    override fun handleAmount(amount: BigDecimal) {
        account.deposit(amount)
        withdrawalLimiter.recordDeposit(amount)
        outputter.output("${account.userName} now has: ${account.balance}")
    }
}