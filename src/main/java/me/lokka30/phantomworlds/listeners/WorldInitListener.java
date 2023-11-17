package me.lokka30.phantomworlds.listeners;
/*
 * The New Kings
 * Copyright (C) 2022 - 2023 Daniel "creatorfromhell" Vidmar
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import me.lokka30.phantomworlds.PhantomWorlds;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldInitEvent;

/**
 * WorldInitListener
 *
 * @author creatorfromhell
 * @since 0.0.1.0
 */
public class WorldInitListener implements Listener {

  final PhantomWorlds plugin;

  public WorldInitListener(PhantomWorlds plugin) {
    this.plugin = plugin;
  }

  @EventHandler
  public void onInit(WorldInitEvent event) {
    if(!plugin.isWorldLoaded()) {
      plugin.loadWorlds();
    }
  }
}