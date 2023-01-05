package me.cpjinan.playerban.commands

import me.cpjinan.playerban.manager.ConfigManager.data
import taboolib.common.platform.ProxyCommandSender
import taboolib.common.platform.command.*
import taboolib.expansion.createHelper
import taboolib.module.chat.colored

@CommandHeader(name = "playerban", permissionDefault = PermissionDefault.FALSE)
object MainCommand {

    @CommandBody
    val main = mainCommand {
        createHelper()
    }

    @CommandBody
    val reason = subCommand {
        dynamic("id") {
            execute<ProxyCommandSender> { sender, context, argument ->
                val reason : String? = (data.getString("player."+context.get(1).substringAfter("#") + ".reason"))?.colored()
                if (reason != null) sender.sendMessage(("&c玩家 &f" + context.get(1).substringAfter("#") + " &c的封禁原因为: &f" + reason).colored())
                else sender.sendMessage(("&c不存在编号为 &f" + context.get(1) + " &c的封禁事件!").colored())
            }
        }
    }

    @CommandBody
    val kick = KickCommand

    @CommandBody
    val ban = BanCommand
    @CommandBody
    val unban = BanCommand

}
