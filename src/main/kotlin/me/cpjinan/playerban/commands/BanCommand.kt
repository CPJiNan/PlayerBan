package me.cpjinan.playerban.commands

import me.cpjinan.playerban.manager.ConfigManager
import me.cpjinan.playerban.manager.FormatManager
import org.bukkit.Bukkit
import taboolib.common.platform.ProxyCommandSender
import taboolib.common.platform.command.*
import taboolib.expansion.createHelper
import taboolib.module.chat.colored

@CommandHeader(name = "ban", permission = "playerban.ban")
object BanCommand {

    @CommandBody
    val main = mainCommand {
        createHelper()
        dynamic("player") {
            dynamic("reason") {
                execute<ProxyCommandSender> { sender, context, argument ->
                    ConfigManager.data["player." + context.get(0) + ".isBanned"] = true
                    ConfigManager.data["player." + context.get(0) + ".reason"] = context.get(1)
                    ConfigManager.data.saveToFile(ConfigManager.data.file)

                    Bukkit.getPlayerExact(context.get(0))?.kickPlayer(FormatManager.getBanFormat(context.get(0), context.get(1)))

                    sender.sendMessage(("&c已封禁玩家 &f" + context.get(0) + " &c!").colored())
                }
            }
        }
    }

}