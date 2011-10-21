package com.srcry.geoff

import org.apache.commons.httpclient.methods.GetMethod
import io.Source
import org.apache.commons.httpclient.HttpClient
import java.net.URLEncoder

/*
 * Created by Justin Pinner.
 * On: 21/10/2011 at: 10:29
*/

case class HttpResponse(body: String, statusCode: Int, statusMessage: String)

object GeoPlanetHttpClient extends Logging {

  val httpClient = new HttpClient
  val baseUrl: String = "http://where.yahooapis.com/v1/"
  val staticParams: String = "appid=000000&format=json&view=long"

  def lookupPlaces(searchTerms: String): HttpResponse = {
    val url = baseUrl + "places.q(" + URLEncoder.encode(searchTerms) + ")?" + staticParams
    log.info("Calling url %s" format(url))
    GET(url)
  }

  def lookupPlaceTypes(searchTerms: String): HttpResponse = {
    val url = baseUrl + "placetypes/" + URLEncoder.encode(searchTerms) + "?" + staticParams
    log.info("Calling url %s" format(url))
    GET(url)
  }

  def GET(url: String, headers: Iterable[ (String,String) ] = Nil): HttpResponse = {
    val method = new GetMethod(url)

    headers.foreach { case (key, value) => method.addRequestHeader(key, value) }

//    httpClient.executeMethod(method)
//
//    val statusLine = method.getStatusLine
//    val responseBody = Option(method.getResponseBodyAsStream)
//            .map(Source.fromInputStream(_).mkString)
//            .getOrElse("")
//
//    method.releaseConnection()

    //new HttpResponse(responseBody, statusLine.getStatusCode, statusLine.getReasonPhrase)
    new HttpResponse("", 0, "Testing!")

  }


}