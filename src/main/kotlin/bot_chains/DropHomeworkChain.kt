package bot_chains

import chain.Chain
import core.Updating
import executables.Executable
import handlers.CommandEvent

class DropHomeworkChain : Chain(CommandEvent("/drop_homework")) {
    override suspend fun executableChain(updating: Updating): List<Executable> {
        return listOf(
            DropHomework.DropHomeTask(mKey).message()
        )
    }
}