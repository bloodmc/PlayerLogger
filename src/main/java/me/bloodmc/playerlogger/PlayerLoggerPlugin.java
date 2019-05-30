/*
 * This file is part of EventLogger, licensed under the MIT License (MIT).
 *
 * Copyright (c) bloodmc
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package me.bloodmc.playerlogger;

import me.bloodmc.playerlogger.config.PlayerLoggerConfig;
import me.bloodmc.playerlogger.config.type.GlobalConfig;
import me.bloodmc.playerlogger.listener.BlockEventListener;
import me.bloodmc.playerlogger.listener.PlayerEventListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class PlayerLoggerPlugin extends JavaPlugin {

    private static PlayerLoggerPlugin instance;
    public static final String MOD_ID = "PlayerLogger";
    private Logger logger = this.getLogger();

    public static PlayerLoggerConfig<GlobalConfig> globalConfig;
    private Path configPath = Paths.get(".", "plugins", "PlayerLogger", "config");

    @Override
    public void onEnable() {
        instance = this;

        try {
            if (Files.notExists(configPath)) {
                Files.createDirectories(configPath);
            }

            globalConfig = new PlayerLoggerConfig<>(GlobalConfig.class, configPath.resolve("global.conf"), null);
            globalConfig.save();
        } catch (Throwable t) {
            t.printStackTrace();
            return;
        }

        Bukkit.getPluginManager().registerEvents(new BlockEventListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerEventListener(), this);
    }

    public static PlayerLoggerPlugin getInstance() {
        return instance;
    }

    public static PlayerLoggerConfig<GlobalConfig> getGlobalConfig() {
        return globalConfig;
    }
}
