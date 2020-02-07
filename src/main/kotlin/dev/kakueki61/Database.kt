package dev.kakueki61

import java.math.BigDecimal
import javax.inject.Inject

class Database @Inject constructor() {
    private val accounts = mutableMapOf<String, Account>()

    fun getAccount(userName: String) = accounts.computeIfAbsent(userName) { Account(userName) }

    data class Account(val userName: String, val balance: BigDecimal = BigDecimal.ZERO)
}