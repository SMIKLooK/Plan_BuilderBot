package bot_chains.drop_dz

import HomeworkMessage
import chain.Chain
import core.Updating
import data.HomeworkStorage
import executables.DeleteMessage
import executables.Executable
import handlers.OnTextGotten
import org.w3c.dom.Text
import updating.UpdatingChatId
import updating.UpdatingInlineMessageId

class DropHomeworkChain : Chain(OnTextGotten("скинь дз")) {
    override suspend fun executableChain(updating: Updating): List<Executable> {
        return listOf(
            HomeworkStorage.Base.Instance().lastHomeworkForChat(
                updating.map(UpdatingChatId()).second
            ).map(HomeworkMessage(mKey)),
            DeleteMessage(mKey, updating)
        )
    }
}