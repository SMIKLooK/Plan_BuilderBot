package bot_chains


import executables.Executable
import executables.SendMessage
import staging.StateHandling


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