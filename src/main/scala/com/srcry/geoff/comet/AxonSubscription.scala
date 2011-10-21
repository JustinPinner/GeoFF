package com.srcry.geoff.comet

import net.liftweb.http.{CometActor, CometListener}

/*
 * Created by Justin Pinner.
 * On: 21/10/2011 at: 09:25
*/

trait AxonSubscription extends CometActor with CometListener {

/**
   * When the component is instantiated, register as
   * a listener with the AxonServer
   */
  def registerWith = AxonServer

}