package bot_chains

import core.Updating
import executables.Executable
import handlers.CommandEvent


class HelloChain : chain.Chain(CommandEvent("/start")) {
    override suspend fun executableChain(updating: Updating): List<Executable> {
        return listOf(
            MessageMenu.Base(mKey).message()
        )
    }
}