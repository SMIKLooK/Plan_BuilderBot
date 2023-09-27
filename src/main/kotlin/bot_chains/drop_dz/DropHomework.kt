package bot_chains.drop_dz

import bot_chains.remembered_chains.MessageMenu
import executables.Executable
import executables.SendMessage


interface DropHomework {
    fun message(): Executable

    class DropHomeTask(
        private val mKey: String
    ): MessageMenu {
        override fun message(): Executable {
            return SendMessage(
                mKey,
                "ваше дз:"
            )
        }
    }
}