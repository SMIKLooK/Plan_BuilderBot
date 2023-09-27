package bot_chains

import core.Updating
import executables.Executable
import executables.SendMessage
import handlers.CommandEvent

class HelpChain: chain.Chain(CommandEvent("/help")) {
    override suspend fun executableChain(updating: Updating): List<Executable> {
        return listOf(
            SendMessage(
                mKey,
                "Команды бота: " +
                        "\\/start \\- написать дз "+
                        "\\/dz \\- скинет домашку " +
                        "\\/help \\-помошь по боту"
            )
        )
    }
}