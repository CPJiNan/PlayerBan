package me.cpjinan.playerban

import me.cpjinan.playerban.manager.RegisterManager.registerAll
import taboolib.common.platform.Plugin
import taboolib.common.platform.function.info

object PlayerBan : Plugin() {
    override fun onEnable() {
        registerAll()
    }
}