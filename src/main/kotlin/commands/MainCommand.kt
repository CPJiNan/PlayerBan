package me.cpjinan.playerban.commands

import taboolib.common.platform.command.CommandBody
import taboolib.common.platform.command.CommandHeader
import taboolib.common.platform.command.mainCommand
import taboolib.expansion.createHelper

@CommandHeader("playerban")
object MainCommand {

    @CommandBody
    val main = mainCommand {
        createHelper()
    }

    @CommandBody
    val kick = KickCommand

    @CommandBody
    val ban = BanCommand
    @CommandBody
    val unban = BanCommand

}
