package com.srcry.geoff

import net.liftweb.http.{CometListener, CometActor}
import net.liftweb.util.ClearClearable

class GuTravel extends CometActor with CometListener {
  // private state
  private var msgs: Vector[String] = Vector()

  /**
   * When the component is instantiated, register as
   * a listener with the ChatServer
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
    case v: Vector[String] => msgs = v
    reRender()
  }

  /**
   * Put the messages in the li elements and clear
   * any elements that have the clearable class.
   */
  def render = "li *" #> msgs & ClearClearable
}