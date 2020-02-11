package dev.kakueki61.command

import javax.inject.Inject

class LogoutCommand @Inject constructor() : Command {
    init {
        println("Creating a new $this")
    }

    override fun handleInput(input: List<String>): Command.Result {
        return if (input.isEmpty()) Command.Result.inputCompleted() else Command.Result.invalid()
    }
}