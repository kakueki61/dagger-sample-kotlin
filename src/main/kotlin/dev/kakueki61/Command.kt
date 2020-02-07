package dev.kakueki61

/**
 * Logic to process some user input
 */
interface Command {
    /**
     * Process the rest of the command's words and do something
     */
    fun handleInput(input: List<String>): Status

    enum class Status {
        INVALID, HANDLED
    }
}