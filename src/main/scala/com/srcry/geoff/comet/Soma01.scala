package com.srcry.geoff.comet

import com.srcry.geoff.{GuardianApiHttpClient, GeoPlanetHttpClient}
import net.liftweb.util.ClearClearable

/**
 * Created by IntelliJ IDEA.
 * User: nbennett
 * Date: 21/10/11
 * Time: 12:28
 * To change this template use File | Settings | File Templates.
 */

class Soma01 extends Soma {

  var responses: String = ""

  override def lowPriority = {
    case v: Vector[String] => {
      log.info("Heard %s" format v.toString)
      val searchString: String = v.last.toString
      responses = new GuardianApiHttpClient().lookupPlaces(searchString.split(" ").last).toString
      reRender()
    }
  }

  /**
   * Put the messages in the li elements and clear
   * any elements that have the clearable class.
   */
  override def render = ".feedback *" #> msgs & ClearClearable

}