package bot_chains

import chain.Chain
import core.Updating
import executables.AnswerToCallback
import executables.Executable
import executables.SendPhoto
import handlers.OnCallbackDataGotten
import handlers.OnCallbackGotten
import updating.UpdatingCallbackInt
import updating.UpdatingCallbackString
import updating.UpdatingChatId
import updating.UpdatingPhotoId

class HomeworkChain : Chain(OnCallbackGotten("Homework")) {
    override suspend fun executableChain(updating: Updating): List<Executable> {
        mStates.state(updating).editor(mStates).apply {
            putBoolean("waitForHomework", true)
            putLong("chat_id", updating.map(UpdatingChatId()).second)
        }.commit()
        return listOf(
            WriteHomework.Homework(mKey).message(),
            AnswerToCallback(mKey, "напишите домашку в личке", true)
        )
    }
}