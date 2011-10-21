package com.srcry.geoff.comet

import net.liftweb.util.ClearClearable
import com.srcry.geoff.GeoPlanetHttpClient

/*
 * Created by Justin Pinner.
 * On: 21/10/2011 at: 10:24
*/

class Soma22 extends Soma {

  var responses: String = ""

  override def lowPriority = {
    case v: Vector[String] => {
      log.info("Heard %s" format v.toString)
      responses = new GeoPlanetHttpClient().lookupPlaces(v.last.toString).toString
      reRender()
    }
  }

  /**
   * Put the messages in the li elements and clear
   * any elements that have the clearable class.
   */
  override def render = ".feedback *" #> msgs & ClearClearable

}