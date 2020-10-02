import io.github.dragneelfps.kbot.bot
import io.github.dragneelfps.kbot.generic
import io.github.dragneelfps.kbot.text
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) = runBlocking {
    val bot = bot {
        token = System.getenv("TOKEN")
        usePolling = true
        pollDelaySeconds = 2
        logApiRequests = true

        listeners {
            generic { client, update ->
                val chatId = update.message?.chat?.id!!
                val text = update.message?.text!!
                client.sendMessage(chatId, text)
            }

            text(match = "start") { client, message, _ ->
                val chatId = message.chat?.id!!
                client.sendMessage(chatId, "Lets gooo!!!!")
            }

            text(match = """^url (\w+)$""") { client, message, matches ->
                val chatId = message.chat?.id!!
                client.sendMessage(chatId, matches.joinToString())
            }
        }
    }
    bot.startPolling()
}
