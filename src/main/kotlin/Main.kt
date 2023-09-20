import bot_functoins.StartGreeting
import core.Bot
import core.BotProvider

private lateinit var sBot: Bot

fun main(args: Array<String>) {
    val provider = BotProvider.Base(args)
    sBot = provider.createdBot(
        StartGreeting()
    )
}