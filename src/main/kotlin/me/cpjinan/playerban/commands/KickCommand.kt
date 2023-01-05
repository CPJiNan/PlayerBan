package me.cpjinan.playerban.commands

import me.cpjinan.playerban.manager.FormatManager.getKickFormat
import org.bukkit.Bukkit
import taboolib.common.platform.ProxyCommandSender
import taboolib.common.platform.command.*
import taboolib.expansion.createHelper
import taboolib.module.chat.colored

@CommandHeader(name = "kick", permission = "playerban.kick")
object KickCommand {

    @CommandBody
    val main = mainCommand {
        createHelper()

        dynamic("player") {
            suggestPlayers(true)

            dynamic("reason") {
                execute<ProxyCommandSender> { sender, context, argument ->
                    Bukkit.getPlayerExact(context.get(0))?.kickPlayer(getKickFormat(context.get(0), context.get(1)))

                    sender.sendMessage(("&c已将玩家 &f" + context.get(0) + " &c从服务器请出!").colored())
                }
            }
        }
    }

}