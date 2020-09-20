import io.nooblabs.kbot.bot
import io.nooblabs.kbot.generic
import io.nooblabs.kbot.models.Update
import io.nooblabs.kbot.network.TClient
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) = runBlocking {
    val bot = bot {
        token = System.getenv("TOKEN")
        usePolling = true
        pollDelaySeconds = 2

        listeners {
            generic { client: TClient, update: Update ->
                val chatId = update.message?.chat?.id!!
                val text = update.message?.text!!
                client.sendMessage(chatId, text)
            }
        }
    }
    bot.startPolling()
}
