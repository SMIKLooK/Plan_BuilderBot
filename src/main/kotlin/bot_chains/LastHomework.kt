package bot_chains

import HomeworkMessage
import chain.Chain
import core.Updating
import data.HomeworkStorage
import executables.Executable
import handlers.CommandEvent
import updating.UserIdUpdating

class LastHomework : Chain(CommandEvent("/last")) {

    override suspend fun executableChain(updating: Updating): List<Executable> {
        return listOf(
            HomeworkStorage.Base.Instance().lastHomeworkForChat(
                updating.map(UserIdUpdating())
            ).map(HomeworkMessage(mKey))
        )
    }
}