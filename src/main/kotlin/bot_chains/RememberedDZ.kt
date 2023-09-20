package bot_chains

import executables.SendMessage
import java.lang.reflect.Executable

interface RememberedDZ {
    fun message(): Executable
    class Remember(
        private val mKey: String
    ): MessageMenu{
        override fun message(): executables.Executable {
            return SendMessage(
                mKey,
                "запоминл домашку"
            )
        }
    }
}