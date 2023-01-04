package me.cpjinan.playerban.commands

import me.cpjinan.playerban.manager.ConfigManager
import me.cpjinan.playerban.manager.FormatManager
import org.bukkit.BanList
import org.bukkit.Bukkit
import taboolib.common.platform.ProxyCommandSender
import taboolib.common.platform.command.*
import taboolib.common.platform.function.getDataFolder
import taboolib.common.util.replaceWithOrder
import taboolib.expansion.createHelper
import taboolib.module.chat.colored
import java.util.*

@CommandHeader(name = "unban", permission = "playerban.unban")
object UnbanCommand {

    @CommandBody
    val main = mainCommand {
        createHelper()

        dynamic("player") {
            execute<ProxyCommandSender> { sender, context, argument ->
                ConfigManager.data["player." + context.get(0)] = null
                ConfigManager.data.saveToFile(ConfigManager.data.file)

                sender.sendMessage(("&c已解封玩家 &7" + context.get(0) + " &c!").colored())
            }
        }
    }

}