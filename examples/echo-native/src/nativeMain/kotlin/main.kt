import io.github.dragneelfps.kbot.bot
import io.github.dragneelfps.kbot.models.Message
import io.github.dragneelfps.kbot.network.TClient
import io.github.dragneelfps.kbot.text
import kotlinx.coroutines.runBlocking

fun main() {
//    Platform.isMemoryLeakCheckerActive = false
    runBlocking {
        val bot = bot {
            token = "1216367408:AAG36b9bomdcSYsQk3sUl2hf9dWWieXiBE4"
            usePolling = true
            pollDelaySeconds = 2

            listeners {
//            generic { client: TClient, update: Update ->
//                val chatId = update.message?.chat?.id!!
//                val text = update.message?.text!!
//                client.sendMessage(chatId, text)
//            }

                text(match = "start") { client: TClient, message: Message, _: MatchResult ->
                    val chatId = message.chat?.id!!
                    client.sendMessage(chatId, "Lets gooo!!!!")
                }

                text(match = """^url (\w+)$""".toRegex()) { client: TClient, message: Message, matchResult: MatchResult ->
                    val chatId = message.chat?.id!!
                    client.sendMessage(chatId, matchResult.groups[1]!!.value)
                }
            }
        }
        bot.startPolling()
    }
}
