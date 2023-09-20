package bot_chains

import executables.Executable
import executables.SendMessage
import handlers.OnTextGotten


interface DropHomework {
    fun message(): Executable

    class DropHomeTask(
        private val mKey: String
    ): MessageMenu{
        override fun message(): Executable {
            return SendMessage(
                mKey,
                "ваше дз:"
            )
        }
    }
}