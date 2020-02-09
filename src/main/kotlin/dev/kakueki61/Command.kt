package dev.kakueki61

/**
 * Logic to process some user input
 */
interface Command {
    /**
     * Process the rest of the command's words and do something
     */
    fun handleInput(input: List<String>): Result

    class Result(val status: Status, val nestedCommandRouter: CommandRouter?) {
        companion object {
            fun invalid() = Result(Status.INVALID, null)
            fun handled() = Result(Status.HANDLED, null)
            fun inputCompleted() = Result(Status.INPUT_COMPLETED, null)

            fun enterNestedCommandSet(nestedCommandRouter: CommandRouter): Result {
                return Result(Status.HANDLED, nestedCommandRouter)
            }
        }
    }

    enum class Status {
        INVALID, HANDLED, INPUT_COMPLETED
    }
}