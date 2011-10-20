package com.srcry.geoff

import org.slf4j.LoggerFactory

/*
 * Created by Justin Pinner.
 * On: 20/10/2011 at: 16:46
*/

trait Logging {
  var log = LoggerFactory.getLogger(getClass)

}