package com.srcry.geoff.comet

import com.srcry.geoff.Logging

/*
 * Created by Justin Pinner.
 * On: 21/10/2011 at: 09:18
*/

abstract class Soma extends AxonSubscription with Logging {

  // Base class for soma objects - provides common functionality

  // private state
  var msgs: Vector[String]

  def sendMessage(message: Vector[String]) {
    AxonServer ! message
  }

}