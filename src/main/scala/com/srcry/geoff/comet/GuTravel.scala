package com.srcry.geoff
package comet

import net.liftweb.http.{CometListener, CometActor}
import net.liftweb.util.ClearClearable

class GuTravel extends CometActor with CometListener with Logging {
  // private state
  private var msgs: Vector[String] = Vector("Hi")

  /**
   * When the component is instantiated, register as
   * a listener with the AxonServer
   */
  def registerWith = AxonServer

  /**
   * The CometActor is an Actor, so it processes messages.
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
  def render = ".feedback *" #> msgs & ClearClearable
  
}