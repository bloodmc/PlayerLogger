/*
 * This file is part of GriefDefender, licensed under the MIT License (MIT).
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
package me.bloodmc.playerlogger.config.category;

import me.bloodmc.playerlogger.ConfigCategory;
import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

@ConfigSerializable
public class EventCategory extends ConfigCategory {

    // Block events
    @Setting
    public boolean BLOCK_BREAK_EVENT = true;
    @Setting
    public boolean BLOCK_IGNITE_EVENT = true;
    @Setting
    public boolean  BLOCK_PLACE_EVENT = true;

    // Player events
    @Setting
    public boolean PLAYER_DROP_ITEM_EVENT = true;
    @Setting
    public boolean PLAYER_INTERACT_EVENT = true;
    @Setting
    public boolean PLAYER_INVENTORY_CLICK_EVENT = true;
    @Setting
    public boolean PLAYER_INVENTORY_OPEN_EVENT = true;
    @Setting
    public boolean PLAYER_ITEM_HELD_EVENT = false;
    @Setting
    public boolean PLAYER_JOIN_EVENT = true;
    @Setting
    public boolean PLAYER_MOVE_EVENT = false;
    @Setting
    public boolean PLAYER_QUIT_EVENT = true;
    @Setting
    public boolean PLAYER_TELEPORT_EVENT = true;

}