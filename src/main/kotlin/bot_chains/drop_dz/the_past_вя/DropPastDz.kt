package bot_chains.drop_dz.the_past_вя

import HomeworkMessage
import bot_chains.remembered_chains.WriteHomework
import core.Updating
import data.HomeworkStorage
import executables.DeleteMessage
import executables.Executable
import handlers.CommandEvent
import updating.UpdatingChatId

class DropPastDz : chain.Chain(CommandEvent("/drop_all_dz")) {
    override suspend fun executableChain(updating: Updating): List<Executable> {
        return listOf(
            HomeworkStorage.Base.Instance().dropAllHomework(
                updating.map(UpdatingChatId()).second
            ).map(HomeworkMessage(mKey))
        )
    }
}
