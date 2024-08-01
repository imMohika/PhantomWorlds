package me.lokka30.phantomworlds.misc;
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

/**
 * WorldCopyResponse
 *
 * @author creatorfromhell
 * @since 2.0.12.0
 */
public enum WorldCopyResponse {

  /**
   * Success: World copied and loaded
   */
  COPIED,

  /**
   * Failure: Original world not found.
   */
  NOT_FOUND,

  /**
   * Failure: Copied, but not loaded
   */
  NOT_LOADED,

  /**
   * Failure: Already exists.
   */
  ALREADY_EXISTS,

  /**
   * Failure: Invalid directory.
   */
  INVALID
}