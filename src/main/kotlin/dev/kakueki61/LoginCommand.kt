package dev.kakueki61

import dev.kakueki61.di.UserCommandsRouter
import javax.inject.Inject

class LoginCommand
@Inject
constructor(
    private val db: Database,
    private val outputter: Outputter,
    private val userCommandsRouterFactory: UserCommandsRouter.Factory
) : SingleArgCommand() {
    init {
        println("Creating a new $this")
    }

    override fun handleArg(userName: String): Command.Result {
        val account = db.getAccount(userName)
        println("$userName is logged in with balance: ${account.balance}")
        return Command.Result.enterNestedCommandSet(
            userCommandsRouterFactory.create(account).router()
        )
    }
}