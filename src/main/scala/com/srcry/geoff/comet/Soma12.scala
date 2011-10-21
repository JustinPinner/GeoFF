package com.srcry.geoff.comet

import com.srcry.geoff.GeoPlanetHttpClient
import net.liftweb.util.ClearClearable

/*
 * Created by Justin Pinner.
 * On: 21/10/2011 at: 11:16
*/

class Soma12 extends Soma {

  var responses: String = ""

  override def lowPriority = {
    case v: Vector[String] => {
      log.info("Heard %s" format v.toString)
      responses = new GeoPlanetHttpClient().lookupPlaceTypes(v.last.toString).toString
      reRender()
    }
  }

  /**
   * Put the messages in the li elements and clear
   * any elements that have the clearable class.
   */
  override def render = ".feedback *" #> msgs & ClearClearable

}