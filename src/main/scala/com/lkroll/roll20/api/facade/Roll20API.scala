/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 Lars Kroll <bathtor@googlemail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package com.lkroll.roll20.api.facade

import scalajs.js
import scalajs.js.annotation._
import scalajs.js.typedarray._
import scalajs.js.|

@js.native
@JSGlobalScope
object Roll20API extends js.Object {

  val state: js.Dynamic = js.native;

  /**
   * Register a callback function on some event.
   *
   * See [[https://wiki.roll20.net/API:Events#Callback_Parameters]] for more information.
   */
  def on(event: String, callback: js.Function): Unit = js.native;

  /**
   * Register a callback for when the current stack of sheet workers completes.
   *
   * Callback is only invoked once.
   *
   * See [[https://wiki.roll20.net/API:Function_documentation#onSheetWorkerCompleted]]
   */
  def onSheetWorkerCompleted(callback: js.Function0[Unit]): Unit = js.native;

  /**
   * Log debug information.
   *
   * The message parameter will be transformed into a String with JSON.stringify.
   */
  def log(message: js.Any): Unit = js.native;

  /**
   * Send chat messages.
   *
   * See [[https://wiki.roll20.net/API:Chat]]
   */
  def sendChat(speakingAs: String, input: String, callback: js.Function1[js.Array[ChatMessage], Unit] = null, options: js.Object = null): Unit = js.native;

  /**
   * Send object to front.
   *
   * See [[https://wiki.roll20.net/API:Utility_Functions#Object_Ordering]]
   */
  def toFront(obj: Roll20Object): Unit = js.native;
  /**
   * Send object to back.
   *
   * See [[https://wiki.roll20.net/API:Utility_Functions#Object_Ordering]]
   */
  def toBack(obj: Roll20Object): Unit = js.native;

  /**
   * Return evenly distributed random integer between 1 and max.
   *
   * See [[https://wiki.roll20.net/API:Utility_Functions#Random_Numbers]]
   */
  def randomInteger(max: Int): Int = js.native;

  /**
   * Returns a boolean response on whether a player in the game is a GM or not.
   *
   * See [[https://wiki.roll20.net/API:Utility_Functions#Player_Is_GM]]
   */
  def playerIsGM(playerid: String): Boolean = js.native;

  /**
   * Sets the default token for the supplied Character Object to the details of the supplied Token Object.
   *
   * Both objects must already exist.
   *
   * This will overwrite any default token currently associated with the character.
   */
  def setDefaultTokenForCharacter(character: Roll20Object, token: Roll20Object): Unit = js.native;

  /**
   * Play playlist.
   *
   * The play function takes in the Folder ID (get it from the "_jukeboxfolder" property in the Campaign object) of the playlist, and will begin playing that playlist for everyone in the game.
   */
  def playJukeboxPlaylist(playlistid: String): Unit = js.native;

  /**
   * Stop any playlist.
   *
   * The stop function does not require any arguments, and will stop any playlist that is currently playing.
   */
  def stopJukeboxPlaylist(): Unit = js.native;

  /**
   * Spawns effect at the given position.
   *
   * See [[https://wiki.roll20.net/API:Function_documentation#spawnFx]]
   */
  def spawnFx(left: Int, top: Int, `type`: String, pageId: js.UndefOr[String] = js.undefined): Unit = js.native;

  /**
   * Spawns effect in the given area.
   *
   * See [[https://wiki.roll20.net/API:Function_documentation#spawnFxBetweenPoints]]
   */
  def spawnFxBetweenPoints(start: Roll20Point, end: Roll20Point, `type`: String, pageId: js.UndefOr[String] = js.undefined): Unit = js.native;

  /**
   * Spawns effect at the given position.
   *
   * See [[https://wiki.roll20.net/API:Function_documentation#spawnFxWithDefinition]]
   */
  def spawnFxWithDefinition(left: Int, top: Int, definition: js.Object, pageId: js.UndefOr[String] = js.undefined): Unit = js.native;

  /**
   * Send a ping on the page.
   *
   * See [[https://wiki.roll20.net/API:Utility_Functions#Miscellaneous]].
   */
  def sendPing(left: Int, top: Int, pageid: String, playerid: String = null, moveAll: Boolean = false): Unit = js.native;

  /**
   * Get the singleton campaign object.
   */
  def Campaign(): Roll20Object = js.native;

  /**
   * Create a new objects of the specified type.
   *
   * See [[https://wiki.roll20.net/API:Function_documentation#createObj]]
   */
  def createObj(`type`: String, attributes: js.Object): Roll20Object = js.native;

  /**
   * Test all campaign objects against the predicate and return those that pass.
   *
   * See [[https://wiki.roll20.net/API:Function_documentation#filterObjs]]
   */
  def filterObjs(predicate: js.Function1[Roll20Object, Boolean]): js.Array[Roll20Object] = js.native;

  /**
   * Find and return all campaign objects matching attributes.
   *
   * See [[https://wiki.roll20.net/API:Function_documentation#findObjs]]
   */
  def findObjs(attributes: js.Object, options: js.Object = null): js.Array[Roll20Object] = js.native;

  /**
   * Return all campaign objects.
   */
  def getAllObjs(): js.Array[Roll20Object] = js.native;

  /**
   * Get attribute of character by name.
   *
   * See [[https://wiki.roll20.net/API:Function_documentation#getAttrByName]]
   */
  def getAttrByName(characterId: String, attributeName: String, valueType: String = "current"): js.Any = js.native;

  /**
   * Get object of type with id.
   */
  def getObj(`type`: String, id: String): js.UndefOr[Roll20Object] = js.native;

  @js.native
  trait Roll20Point extends js.Object {
    val x: Int = js.native;
    val y: Int = js.native;
  }

  @js.native
  trait Roll20Object extends js.Object {
    val id: String = js.native;
    /**
     * For "notes", "gmnotes", or "bio".
     *
     * Asynchronous.
     */
    def get(property: String, callback: js.Function1[String, Unit]): Unit = js.native;
    /**
     * For other properties.
     *
     * Synchronous.
     */
    def get(property: String): js.Any = js.native;

    /**
     * Deletes the object.
     */
    def remove(): Unit = js.native;

    def set(property: String, value: js.Any): Unit = js.native;
    def set(values: js.Object): Unit = js.native;
    def setWithWorker(values: js.Object): Unit = js.native;
  }

  @js.native
  trait InlineRollResults extends js.Object {
    val resultType: String = js.native;
    val rolls: js.Array[js.Object] = js.native;
    val total: Int | Float = js.native;
    val `type`: String = js.native;
  }

  @js.native
  trait InlineRoll extends js.Object {
    val expression: String = js.native;
    val results: InlineRollResults = js.native;
    val rollid: js.UndefOr[String] = js.native;
    val signature: Boolean | String = js.native;
  }

  @js.native
  trait ChatMessage extends js.Object {
    /**
     * The display name of the player or character that sent the message.
     */
    val who: String = js.native;
    /**
     * The ID of the player that sent the message.
     */
    val playerid: String = js.native;
    /**
     * Type of the message.
     *
     * One of "general", "rollresult", "gmrollresult", "emote", "whisper", "desc", or "api".
     *
     * Default is "general".
     */
    val `type`: String = js.native;
    /**
     * The contents of the chat message.
     *
     * If type is "rollresult", this will be a JSON string of data about the roll.
     */
    val content: String = js.native;
    /**
     * The original text of the roll.
     *
     * (type "rollresult" or "gmrollresult" only)
     * The original text of the roll, e.g.: "2d10+5 fire damage" when the player types "/r 2d10+5 fire damage".
     * This is equivalent to the use of content on messages with types other than "rollresult" or "gmrollresult".
     */
    val origRoll: js.UndefOr[String] = js.native;
    /**
     * Inline roll information.
     *
     * (content contains one or more inline rolls only)
     *
     * An array of objects containing information about all inline rolls in the message.
     */
    val inlinerolls: js.UndefOr[js.Array[InlineRoll]] = js.native;
    /**
     * The name of the template specified.
     *
     * (content contains one or more roll templates only)
     */
    val rolltemplate: js.UndefOr[String] = js.native;
    /**
     * The player ID of the person the whisper is sent to.
     *
     * (type "whisper" only)
     *
     * If the whisper was sent to the GM without using his or her display name (ie, "/w gm text" instead of "/w Riley text" when Riley is the GM), or if the whisper was sent to a character without any controlling players, the value will be "gm".
     */
    val target: js.UndefOr[String] = js.native;
    /**
     * The display name of the player or character the whisper was sent to.
     *
     * (type "whisper" only)
     */
    val target_name: js.UndefOr[String] = js.native;
    /**
     * An array of objects the user had selected when the command was entered.
     * (type "api" only)
     */
    val selected: js.UndefOr[js.Array[Roll20Object]] = js.native;
  }
}
