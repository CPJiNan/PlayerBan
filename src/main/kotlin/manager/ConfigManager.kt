package me.cpjinan.playerban.manager

import taboolib.library.configuration.ConfigurationSection
import taboolib.module.configuration.Config
import taboolib.module.configuration.ConfigNode
import taboolib.module.configuration.Configuration

object ConfigManager {
    private const val configFile = "config.yml"
    private const val databaseFile = "database.yml"

    @Config(configFile, autoReload = true)
    lateinit var config : Configuration

    @ConfigNode("options", configFile)
    lateinit var options : ConfigurationSection
    @ConfigNode("module.kick", configFile)
    lateinit var kick : ConfigurationSection
    @ConfigNode("module.ban", configFile)
    lateinit var ban : ConfigurationSection

    @Config(databaseFile, autoReload = true)
    lateinit var data : Configuration

}