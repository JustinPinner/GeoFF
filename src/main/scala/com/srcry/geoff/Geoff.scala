package com.srcry.geoff

object Geoff {

  def main(args: Array[String]) {

    val options = parseCommandLine(Map(), args.toList)
    if (options.size != 2) {
      println("Usage: java -jar --date yyyymmdd --src-dir directory-path")
      sys.exit(-1)
    }

    val issueDate = options("date")

    //Assembler.assemble(options("src-dir"), issueDate)

  }

  def parseCommandLine(optionMap: Map[String, String], args: List[String]): Map[String, String] = {
    args match {
      case Nil => optionMap
      case "--date" :: date :: tail => parseCommandLine(optionMap ++ Map("date" -> date), tail)
      case "--src-dir" :: dir :: tail => parseCommandLine(optionMap ++ Map("src-dir" -> dir), tail)
      case option :: tail => {
        println("Unknown option "+option)
        sys.exit(-1)
      }
    }

  }

}