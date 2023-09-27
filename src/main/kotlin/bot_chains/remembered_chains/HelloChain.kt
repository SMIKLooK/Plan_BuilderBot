package bot_chains.remembered_chains

import core.Updating
import executables.DeleteMessage
import executables.Executable
import handlers.CommandEvent


class HelloChain : chain.Chain(CommandEvent("/start@Plan_BuilderBot")) {
    override suspend fun executableChain(updating: Updating): List<Executable> {
        return listOf(
            DeleteMessage(mKey, updating),
            MessageMenu.Base(mKey).message(),
        )
    }
}