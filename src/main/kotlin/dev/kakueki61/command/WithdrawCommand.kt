package dev.kakueki61.command

import dev.kakueki61.Database
import dev.kakueki61.Outputter
import dev.kakueki61.di.qualifier.MaximumWithdrawal
import dev.kakueki61.di.qualifier.MinimumBalance
import java.math.BigDecimal
import javax.inject.Inject

class WithdrawCommand
@Inject
constructor(
    private val account: Database.Account,
    private val outputter: Outputter,
    @MinimumBalance private val minimumBalance: BigDecimal,
    @MaximumWithdrawal private val maximumWithdrawal: BigDecimal
) : BigDecimalCommand(outputter) {
    init {
        println("Creating a new $this")
    }

    override fun handleAmount(amount: BigDecimal) {
        if (amount > maximumWithdrawal) {
            outputter.output("amount must be maximum withdrawal: $amount > $maximumWithdrawal")
            return
        }

        val newBalance = account.balance.subtract(amount)
        if (newBalance < minimumBalance) {
            outputter.output("negative balance: $newBalance")
            return
        } else {
            account.withdraw(amount)
            outputter.output("your new balance is ${account.balance}")
        }
    }
}