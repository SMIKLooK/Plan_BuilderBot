package bot_functoins

import bot_chains.HelpChain
import bot_chains.drop_dz.DropHomeworkChain
import bot_chains.drop_dz.LastHomework
import bot_chains.drop_dz.the_past_вя.DropPastDz
import bot_chains.remembered_chains.HelloChain
import bot_chains.remembered_chains.HomeworkChain
import bot_chains.remembered_chains.RememberedChain
import core.BotChains

class StartGreeting : BotChains{
    override fun chains()= listOf(
        RememberedChain(),
        HelloChain(),
        HomeworkChain(),
        LastHomework(),
        DropPastDz(),
        HelpChain(),
        DropHomeworkChain()
    )
}