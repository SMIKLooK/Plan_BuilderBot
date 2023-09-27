package bot_chains.remembered_chains

import bot_chains.remembered_chains.WriteHomework
import chain.Chain
import core.Updating
import executables.AnswerToCallback
import executables.DeleteMessage
import executables.Executable
import handlers.OnCallbackGotten
import updating.UpdatingChatId

class HomeworkChain : Chain(OnCallbackGotten("Homework")) {
    override suspend fun executableChain(updating: Updating): List<Executable> {
        mStates.state(updating).editor(mStates).apply {
            putBoolean("waitForHomework", true)
            putLong("chat_id", updating.map(UpdatingChatId()).second)
        }.commit()
        return listOf(
            AnswerToCallback(mKey, "напишите домашку в личке", true),
            WriteHomework.Homework(mKey).message(),
            DeleteMessage(mKey, updating)
        )
    }
}