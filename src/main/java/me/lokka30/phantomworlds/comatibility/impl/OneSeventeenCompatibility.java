package me.lokka30.phantomworlds.comatibility.impl;
/*
 * Phantom Worlds
 * Copyright (C) 2023 - 2024 Daniel "creatorfromhell" Vidmar
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

import me.lokka30.phantomworlds.comatibility.VersionCompatibility;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

/**
 * OneSixteenCompatibility
 *
 * @author creatorfromhell
 * @since 2.0.5.0
 */
public class OneSeventeenCompatibility implements VersionCompatibility {

  /**
   * Used to return a list of potion effects suggestions for our /pw set effects command.
   *
   * @return The list containing the potion effects that exist.
   */
  @Override
  public List<String> potionEffectSuggestions() {

    final List<String> effects = new ArrayList<>();

    for(PotionEffectType value : PotionEffectType.values()) {

      if(value == null) { //for some reason there is a null value here
        continue;
      }

      effects.add(value.getName() + ",duration,amplifier");
      effects.add(value.getName() + ",-1,1");
    }
    return effects;
  }

  /**
   * Used to find an {@link PotionEffectType effect type} based on a string.
   *
   * @param effectType The effect type.
   *
   * @return The effect type if found, otherwise null
   */
  @Override
  public PotionEffectType findType(String effectType) {
    return PotionEffectType.getByName(effectType);
  }
}