package com.srcry.geoff.comet

import net.liftweb.util.ClearClearable
import com.srcry.geoff.GeoPlanetHttpClient

class GuTravel extends Soma {

  override var msgs: Vector[String] = Vector("")
  
   override def lowPriority = {
    case v: Vector[String] => {
      if (v.last.toString.length() > 0) {
        log.info("Heard: %s" format v.last.toString)
        msgs :+= GeoPlanetHttpClient.lookupPlaces(v.last.toString).toString
        reRender()
      }
    }
  }

  /**
   * Put the messages in the li elements and clear
   * any elements that have the clearable class.
   */
  override def render = ".gu_travel_feedback *" #> msgs & ClearClearable
  
}