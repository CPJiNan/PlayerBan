package me.cpjinan.playerban.listener

import me.cpjinan.playerban.manager.ConfigManager.data
import me.cpjinan.playerban.manager.FormatManager
import org.bukkit.event.player.AsyncPlayerPreLoginEvent
import taboolib.common.platform.event.SubscribeEvent

/**
 * author:      CPJiNan
 * project:     PlayerBan
 * package:     me.cpjinan.playerban.listener
 * className:   BanEvent
 * date:        2023/1/1 10:55
 * description: 封禁事件监听器
 */
object BanEvent {

    /**
     * 玩家登入事件处理方法
     */
    @SubscribeEvent
    fun onPlayerLogin(event : AsyncPlayerPreLoginEvent) {
        if (data.getBoolean("player." + event.name + ".isBanned")) event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_BANNED, getResult(event.name)) else event.allow()
    }

    private fun getResult(name : String) : String{
        return FormatManager.getBanFormat(name, data.getString("player.$name.reason")!!)
    }

}