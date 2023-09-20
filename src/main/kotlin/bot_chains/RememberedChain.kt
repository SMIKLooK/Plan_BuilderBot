package bot_chains

import chain.Chain
import core.Updating
import data.Homework
import data.HomeworkStorage
import executables.Executable
import handlers.OnTextGotten
import logs.Logging
import staging.NotFoundStateValue
import staging.safetyBoolean
import updating.UpdatingMessage
import updating.UserIdUpdating

class RememberedChain : Chain(OnTextGotten()) {

    override suspend fun executableChain(updating: Updating): List<Executable> {
        return if (mStates.state(updating).safetyBoolean("waitForHomework")) {
            val homeworkText = updating.map(UpdatingMessage())
            HomeworkStorage.Base.Instance().insertHomework(
                Homework(
                    -1,
                    homeworkText,
                    updating.map(UserIdUpdating()),
                    mStates.state(updating).int("chat_id").toLong(),
                    false,
                    System.currentTimeMillis() + 86_400_000L,
                    System.currentTimeMillis()
                )
            )
            listOf(
                Remember(mKey).message().also {
                    mStates.state(updating).editor(mStates).apply {
                        deleteValue("waitForHomework")
                        deleteValue("chat_id")
                    }.commit()
                }
            )
        } else {
            emptyList()
        }
    }
}