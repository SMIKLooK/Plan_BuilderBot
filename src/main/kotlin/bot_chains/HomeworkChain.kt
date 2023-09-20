package bot_chains

import chain.Chain
import core.Updating
import executables.AnswerToCallback
import executables.Executable
import handlers.OnCallbackDataGotten

class HomeworkChain : Chain(OnCallbackDataGotten("Homework")) {
    override suspend fun executableChain(updating: Updating): List<Executable> {
        return listOf(
            WriteHomework.Homework(mKey).message(),
            AnswerToCallback(mKey, "напишите домашку в личке")
        )
    }
}