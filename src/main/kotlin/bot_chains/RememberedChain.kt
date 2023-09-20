package bot_chains

import chain.Chain
import core.Updating
import executables.Executable
import handlers.OnTextGotten
import logs.Logging
import staging.NotFoundStateValue
import staging.safetyBoolean
import updating.UpdatingMessage

class RememberedChain: Chain(OnTextGotten()) {

    override suspend fun executableChain(updating: Updating): List<Executable> {
        return if (mStates.state(updating).safetyBoolean("waitForHomework")) {
            Logging.ConsoleLog.log(updating.map(UpdatingMessage()))
            listOf(
                Remember(mKey).message().also {
                    mStates.state(updating).editor(mStates).apply {
                        deleteValue("waitForHomework")
                    }.commit()
                }
            )
        } else {
            emptyList()
        }
    }
}