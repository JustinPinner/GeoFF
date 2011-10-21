package com.srcry.geoff.comet

import net.liftweb.util.ClearClearable

class GuTravel extends Soma {
  /**
   * Soma provides the CometActor and CometListener message processing.
   * In this case, we're listening for Vector[String],
   * and when we get one, update our private state
   * and reRender() the component.  reRender() will
   * cause changes to be sent to the browser.
   */
  override def lowPriority = {  
    case v: Vector[String] => {
      log.info("Heard %s" format v.toString)
      msgs = v
      reRender()
    }
    case s: String => {
      log.info("Heard %s" format s)
      msgs = Vector(s)
      reRender()
    }
  }

  /**
   * Put the messages in the li elements and clear
   * any elements that have the clearable class.
   */
  override def render = ".feedback *" #> msgs & ClearClearable
  
}