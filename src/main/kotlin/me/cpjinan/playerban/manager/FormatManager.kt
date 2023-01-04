package me.cpjinan.playerban.manager

import taboolib.common.util.replaceWithOrder
import taboolib.module.chat.colored

object FormatManager {
    fun getKickFormat(name:String, reason : String) : String{
        return ConfigManager.kick.getList("format")!!.joinToString(separator = System.lineSeparator()).replaceWithOrder(reason, "#$name").colored()
    }

    fun getBanFormat(name : String, reason : String) : String{
        return ConfigManager.ban.getList("format")!!.joinToString(separator = System.lineSeparator()).replaceWithOrder(reason, "#$name").colored()
    }
}