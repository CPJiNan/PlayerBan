package me.cpjinan.playerban.manager

import taboolib.common.platform.Platform
import taboolib.module.metrics.Metrics
import taboolib.platform.BukkitPlugin

/**
 * author:      CPJiNan
 * project:     PlayerBan
 * package:     me.cpjinan.playerban.manager
 * className:   RegisterManager
 * date:        2023/1/2 17:55
 * description: 注册相关工具类
 */
object RegisterManager {

    /**
     * 快捷注册方法
     */
    fun registerAll() {
        registerMetrics()
    }

    /**
     * bStats统计注册方法
     */
    private fun registerMetrics() {
        if (ConfigManager.options.getBoolean("metrics")) Metrics(17277, BukkitPlugin.getInstance().description.version, Platform.BUKKIT)
    }

}