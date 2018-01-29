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
object Roll20Objects extends js.Object {
  @js.native
  trait CharacterCreate extends js.Object {
    /**
     * URL to an image used for the character.
     *
     * See the note about avatar and imgsrc restrictions at [[https://wiki.roll20.net/API:Objects#imgsrc_and_avatar_property_restrictions Roll20 Docs]].
     */
    var avatar: String = js.native;
    var name: String = js.native;
    /**
     *  The character's biography.
     *
     *  See the note at [[https://wiki.roll20.net/API:Objects#Using_the_Notes.2C_GMNotes.2C_and_Bio_fields_.5BAsynchronous.5D Roll20 Docs]] about accessing the Notes, GMNotes, and bio fields.
     */
    var bio: String = js.native;
    /**
     * 	Notes on the character only viewable by the GM.
     *
     * See the note at [[https://wiki.roll20.net/API:Objects#Using_the_Notes.2C_GMNotes.2C_and_Bio_fields_.5BAsynchronous.5D Roll20 Docs]] about accessing the Notes, GMNotes, and bio fields.
     */
    var gmnotes: String = js.native;
    var archived: Boolean = js.native;
    /**
     * Comma-delimited list of player ID who can view this character.
     *
     * Use "all" to give all players the ability to view.
     */
    var inplayerjournals: String = js.native;

    /**
     * Comma-delimited list of player IDs who can control and edit this character.
     *
     * Use "all" to give all players the ability to edit.
     */
    var controlledby: String = js.native;
  }

  @js.native
  trait AbilityCreate extends js.Object {
    /**
     * The character this ability belongs to. Read-only. Mandatory when using createObj.
     */
    var _characterid: String = js.native;
    var name: String = js.native;
    /**
     * The description does not appear in the character sheet interface.
     */
    var description: String = js.native;
    /**
     * 	The text of the ability.
     */
    var action: String = js.native;
    /**
     * Is this ability a token action that should show up when tokens linked to its parent Character are selected?
     */
    var istokenaction: Boolean = js.native;
  }

  @js.native
  trait AttributeCreate extends js.Object {
    /**
     * The character this attribute belongs to. Read-only. Mandatory when using createObj.
     */
    var _characterid: String = js.native;
    var name: String = js.native;
    /**
     * The current value of the attribute can be accessed in chat and macros with the syntax @{Character Name|Attribute Name} or in abilities with the syntax @{Attribute Name}.
     */
    var current: String = js.native;
    /**
     * 	The max value of the attribute can be accessed in chat and macros with the syntax @{Character Name|Attribute Name|max} or in abilities with the syntax @{Attribute Name|max}.
     */
    var max: String = js.native;
  }
}
