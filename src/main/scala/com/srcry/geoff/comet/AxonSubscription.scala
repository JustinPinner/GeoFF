package com.srcry.geoff.comet

/*
 * Created by Justin Pinner.
 * On: 21/10/2011 at: 09:25
*/

trait AxonSubscription {
  /**
   * When the component is instantiated, register as
   * a listener with the AxonServer
   */
  def registerWith = AxonServer

}