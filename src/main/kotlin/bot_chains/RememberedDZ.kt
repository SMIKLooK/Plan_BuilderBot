package bot_chains

import executables.SendMessage
import java.lang.reflect.Executable

class Remember(
    private val mKey: String
) : MessageMenu {
    override fun message(): executables.Executable {
        return SendMessage(
            mKey,
            "запоминл домашку"
        )
    }
}