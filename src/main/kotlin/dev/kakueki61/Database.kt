package dev.kakueki61

import java.lang.IllegalArgumentException
import java.math.BigDecimal
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Database @Inject constructor() {
    private val accounts = mutableMapOf<String, Account>()

    init {
        println("Creating a new $this")
    }

    fun getAccount(userName: String) = accounts.computeIfAbsent(userName) { Account(userName) }

    data class Account(val userName: String, var balance: BigDecimal = BigDecimal.ZERO) {
        fun deposit(amount: BigDecimal) {
            checkNonNegative(amount, "withdraw")
            balance = balance.add(amount)
        }

        fun withdraw(amount: BigDecimal) {
            checkNonNegative(amount, "withdraw")
            balance = balance.subtract(amount)
        }

        private fun checkNonNegative(amount: BigDecimal, action: String) {
            if (amount.signum() == -1) {
                throw IllegalArgumentException("Cannot $action negative amounts: $amount")
            }
        }
    }
}