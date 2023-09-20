import bot_functoins.StartGreeting
import core.Bot
import core.BotProvider
import core.storage.Storages
import data.HomeworkStorage
import helpers.storage.jdbc_wrapping.DatabaseHelper

private lateinit var sBot: Bot

fun main(args: Array<String>) {
    val provider = BotProvider.Base(args)
    val db = DatabaseHelper.Base.Instance.provideInstance(
        Storages.Main.Provider().stConfig
    )
    HomeworkStorage.Base.Instance.create("homework", db)
    db.createTable(HomeworkStorage.Base.Instance().tableSchema())
    sBot = provider.createdBot(
        StartGreeting()
    )
}