package com.srcry.geoff

import comet.AxonServer

/*
 * Created by Justin Pinner.
 * On: 20/10/2011 at: 15:30
*/

trait UserActionAnnouncer {
  def announceUserAction(action: UserAction.action) {
    AxonServer ! action
  }
}

object UserAction extends Enumeration {
  type action = Value
  val submitClick = Value(0)
  val cancelClick = Value(1)
  val resetClick = Value(2)
  val searchClick = Value(3)
  
}