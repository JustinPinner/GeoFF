package com.srcry.geoff.comet

import net.liftweb.http.{CometListener, CometActor}
import com.srcry.geoff.Logging

/*
 * Created by Justin Pinner.
 * On: 21/10/2011 at: 09:18
*/

abstract class Soma extends CometActor with CometListener with AxonSubscription with Logging {

  // Base class for soma objects - provides common functionality

  // private state
  var msgs: Vector[String] = Vector("Hello")

  def sendMessage(message: Vector[String]) = {
    AxonServer ! message
  }

}