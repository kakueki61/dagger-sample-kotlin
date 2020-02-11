package dev.kakueki61.command

import dev.kakueki61.Database
import dev.kakueki61.Outputter
import dev.kakueki61.di.UserCommandsRouter
import java.util.*
import javax.inject.Inject

class LoginCommand
@Inject
constructor(
    private val db: Database,
    private val outputter: Outputter,
    private val userCommandsRouterFactory: UserCommandsRouter.Factory,
    private val account: Optional<Database.Account>
) : SingleArgCommand() {
    init {
        println("Creating a new $this")
    }

    override fun handleArg(userName: String): Command.Result {
        if (account.isPresent) {
            return Command.Result.handled()
        }

        val newAccount = db.getAccount(userName)
        println("$userName is logged in with balance: ${newAccount.balance}")
        return Command.Result.enterNestedCommandSet(
            userCommandsRouterFactory.create(newAccount).router()
        )
    }
}