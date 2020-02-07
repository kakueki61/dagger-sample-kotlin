package dev.kakueki61

import javax.inject.Inject

class LoginCommand @Inject constructor(private val db: Database, private val outputter: Outputter) : SingleArgCommand() {
    override fun key(): String {
       return "login"
    }

    override fun handleArg(userName: String): Command.Status {
        val account = db.getAccount(userName)
        println("$userName is logged in with balance: ${account.balance}")
        return Command.Status.HANDLED
    }
}