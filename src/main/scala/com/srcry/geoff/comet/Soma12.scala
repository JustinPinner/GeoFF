package com.srcry.geoff.comet

import com.srcry.geoff.GeoPlanetHttpClient
import net.liftweb.util.ClearClearable

class Soma12 extends Soma {

  override var msgs: Vector[String] = Vector("")
  
  override def lowPriority = {
    case v: Vector[String] => {
      if (v.last.length() > 0) {
        log.info("Heard: %s" format v.toString)
        msgs :+= GeoPlanetHttpClient.lookupPlaceTypes(v.last.toString).toString
        reRender()
      }
    }
  }

  /**
   * Put the messages in the li elements and clear
   * any elements that have the clearable class.
   */
  override def render = ".soma_12_feedback *" #> msgs & ClearClearable

}