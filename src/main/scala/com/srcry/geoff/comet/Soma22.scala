package com.srcry.geoff.comet

import net.liftweb.util.ClearClearable
import com.srcry.geoff.GeoPlanetHttpClient

class Soma22 extends Soma {

  override var msgs: Vector[String] = Vector("")

  override def lowPriority = {
    case v: Vector[String] => {
      if (v.last.length > 0) {
        log.info("Heard (Vector[String]): %s" format v.last.toString)
        msgs :+= GeoPlanetHttpClient.lookupPlaces(v.last.toString).toString
        reRender()
      }
    }
  }

  /**
   * Put the messages in the li elements and clear
   * any elements that have the clearable class.
   */
  override def render = ".soma_22_feedback *" #> msgs & ClearClearable

}