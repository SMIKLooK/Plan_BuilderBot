package bot_chains

import core.Updating
import executables.Executable
import handlers.OnTextGotten

class RememberedChain: chain.Chain(OnTextGotten()){
    val x = OnTextGotten().toString()
    override suspend fun executableChain(updating: Updating): List<Executable> {
        return listOf(
            RememberedDZ.Remember(mKey).message()
        )
    }
}