package bot_chains

import executables.Executable
import executables.SendMessage
import helpers.convertToVertical
import keyboard_markup.InlineButton
import keyboard_markup.InlineKeyboardMarkup


interface MessageMenu {

    fun message(): Executable

    class Base(
        private val mKey: String,
    ) : MessageMenu {
        override fun message(): Executable {
            return SendMessage(
                mKey,
                "Hello word",
                InlineKeyboardMarkup(
                    listOf(
                        InlineButton(
                            "написать дз",
                            mCallbackData = "Homework"
                        )
                    ).convertToVertical()
                )
            )
        }
    }
}