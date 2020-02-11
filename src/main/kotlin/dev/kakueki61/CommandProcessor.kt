package dev.kakueki61

import dev.kakueki61.command.Command
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CommandProcessor @Inject constructor(firstCommandRouter: CommandRouter){
    private val commandRouterStack = ArrayDeque<CommandRouter>()

    init {
        commandRouterStack.push(firstCommandRouter)
    }

    fun process(input: String): Command.Status {
        val result = commandRouterStack.peek().route(input)

        if (result.status == Command.Status.INPUT_COMPLETED) {
            commandRouterStack.pop()
            return if (commandRouterStack.isEmpty()) Command.Status.INPUT_COMPLETED else Command.Status.HANDLED
        }

        result.nestedCommandRouter?.let {
            commandRouterStack.push(it)
        }
        return result.status
    }
}