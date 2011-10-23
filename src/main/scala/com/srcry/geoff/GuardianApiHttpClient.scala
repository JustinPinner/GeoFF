package com.srcry.geoff

import org.apache.commons.httpclient.HttpClient
import org.apache.commons.httpclient.methods.GetMethod
import io.Source

class GuardianApiHttpClient extends Logging  {

  val httpClient = new HttpClient
  val baseUrl: String = "http://content.guardianapis.com/search?q=%s"
  val staticParams: String = "&tag=travel&format=json"

  def lookupPlaces(searchTerms: String): HttpResponse = {
      val url = baseUrl.format(searchTerms) + staticParams
      log.info("Calling url %s" format(url))
      GET(url)
  }

  def GET(url: String, headers: Iterable[ (String,String) ] = Nil): HttpResponse = {
    val method = new GetMethod(url)

    headers.foreach { case (key, value) => method.addRequestHeader(key, value) }
    httpClient.executeMethod(method)

    val statusLine = method.getStatusLine
    //log.error("+++++++++++++++++++++++++++++++++++" + statusLine)
    val responseBody = Option(method.getResponseBodyAsStream)
            .map(Source.fromInputStream(_).mkString)
            .getOrElse("")

    method.releaseConnection()

    //new HttpResponse(responseBody, statusLine.getStatusCode, statusLine.getReasonPhrase)
    new HttpResponse(responseBody, statusLine.getStatusCode, "blah")

  }


}