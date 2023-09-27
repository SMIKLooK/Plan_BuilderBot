package bot_chains.remembered_chains

import executables.SendMessage

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