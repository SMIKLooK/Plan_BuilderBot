package bot_chains.drop_dz

import HomeworkMessage
import chain.Chain
import core.Updating
import data.HomeworkStorage
import executables.DeleteMessage
import executables.Executable
import handlers.CommandEvent
import updating.UpdatingChatId


class LastHomework : Chain(CommandEvent("/dz@Plan_BuilderBot")) {

    override suspend fun executableChain(updating: Updating): List<Executable> {
        return listOf(
            HomeworkStorage.Base.Instance().lastHomeworkForChat(
                updating.map(UpdatingChatId()).second
            ).map(HomeworkMessage(mKey)),
            DeleteMessage(mKey, updating)
        )
    }
}