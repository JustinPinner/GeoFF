package com.srcry.geoff
package comet

import net.liftweb._
import net.liftweb.actor._
import net.liftweb.http._

/*
 * Created by Justin Pinner.
 * On: 19/10/2011 at: 21:23
*/

object AxonServer extends LiftActor with ListenerManager with Logging {
  // private state
  private var msgs = Vector("")

  /**
   * When we update the listeners, what message do we send?
   * We send the msgs, which is an immutable data structure,
   * so it can be shared with lots of threads without any
   * danger or locking.
   */
  def createUpdate = msgs

  /**
   * process messages that are sent to the Actor.  In
   * this case, we're looking for Strings that are sent
   * to the ChatServer.  We append them to our Vector of
   * messages, and then update all the listeners.
   */
  override def lowPriority = {
    case s: String => {
      log.info("Received %s" format(s))
      if (s.length() > 0) {
        msgs :+= s
        log.info("Updating Listeners...")
        updateListeners()
      }
    }
    case (UserAction.searchClick, searchTerms: String) => {
      log.info("Received searchClick and %s" format(searchTerms))
      if (searchTerms.length() > 0) {
        msgs :+= searchTerms
        log.info("Updating Listeners...")
        updateListeners()
      }
    }
  }
}