package bot_functoins

import bot_chains.*
import core.BotChains

class StartGreeting : BotChains{
    override fun chains()= listOf(
        HelloChain(),
        HomeworkChain(),
        DropHomeworkChain(),
        RememberedChain()
    )
}