package com.srcry.geoff
package snippet

import net.liftweb.util.Helpers._
import net.liftweb.http.SHtml

import comet.AxonServer
import net.liftweb.http.js.JsCmds.SetValById
import org.slf4j.LoggerFactory


/**
 * A snippet transforms input to output... it transforms
 * templates to dynamic content.  Lift's templates can invoke
 * snippets and the snippets are resolved in many different
 * ways including "by convention".  The snippet package
 * has named snippets and those snippets can be classes
 * that are instantiated when invoked or they can be
 * objects, singletons.  Singletons are useful if there's
 * no explicit state managed in the snippet.
 */
object SearchInput extends UserActionAnnouncer with Logging {
  var searchTerms: String = _

  def setTerms = SHtml.onSubmit(s => {
    searchTerms = s
  })

  def doSearch = {
    "#search_input" #> SHtml.onSubmit(userText => searchTerms = extractTerms(userText)) &
    "#search_button" #> SHtml.ajaxSubmit("Search", () => {
      log.info("Sending (%s, %s) to AxonServer" format(UserAction.searchClick.toString, searchTerms))
      AxonServer ! (UserAction.searchClick, searchTerms)
    })
  }

  private def extractTerms(terms: String) = {
    // here's where we'll sort out any encoding if necessary but for now, just give back
    // what we received...
    terms
  }
  
//  /**
//   * The render method in this case returns a function
//   * that transforms NodeSeq => NodeSeq.  In this case,
//   * the function transforms a form input element by attaching
//   * behavior to the input.  The behavior is to send a message
//   * to the ChatServer and then returns JavaScript which
//   * clears the input.
//   */
//  def render = SHtml.onSubmit(s => {
//    SetValById("search_input", s)
//  })
}