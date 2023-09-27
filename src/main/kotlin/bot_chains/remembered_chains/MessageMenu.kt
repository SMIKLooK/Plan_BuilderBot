package bot_chains.remembered_chains

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
                "Напиши мне домашку нажав по кнопе ниже \uD83E\uDDD4\uD83C\uDFFB\u200D♀️",
                InlineKeyboardMarkup(
                    listOf(
                        InlineButton(
                            "написать дз",
                            mCallbackData = "Homework"
                        )
                    ).convertToVertical(),
                )
            )
        }
    }
}