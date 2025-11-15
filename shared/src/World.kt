data class CommandResult(val exitCode: Int, val error: String? = null) {
    val isSuccess: Boolean get() = exitCode == 0
    val isFailure: Boolean get() = exitCode != 0
}

expect class World() {
    fun installGit(): CommandResult
    fun installPython(): CommandResult
    fun runShellCommand(
        command: String,
        args: List<String>,
        workingDir: String? = null
    ): CommandResult
}