package bot_chains.remembered_chains


import executables.Executable
import executables.SendMessage


interface WriteHomework {

    fun message(): Executable

    class Homework(
        private val mKey: String
    ) : MessageMenu {
        override fun message(): Executable {
            return SendMessage(
                mKey,
                "Напиши домашку"
            )
        }
    }
}