//import com.gu._

name := "geoFF"

version := "1.0"

organization := "com.srcry"

scalaVersion := "2.9.0-1"

//resolvers in ThisBuild ++= Seq(
//  "Guardian Github Releases" at "http://guardian.github.com/maven/repo-releases",
//  "Guardian Github Snapshots" at "http://guardian.github.com/maven/repo-snapshots",
//  "Guardian Nexus" at "http://nexus.gudev.gnl:8081/nexus/content/groups/public"
//)

// include web plugin settings in this project
seq(webSettings :_*)

// artifact generation stuff
//seq(SbtDistPlugin.distSettings :_*)

libraryDependencies ++= {
    val LIFT_VERSION = "2.4-M4"
    val SLF4J_VERSION = "1.6.1"
    val JETTY_VERSION = "7.3.1.v20110307"
    Seq(
        "org.slf4j" % "slf4j-api" % SLF4J_VERSION,
        "org.slf4j" % "log4j-over-slf4j" % SLF4J_VERSION,
        "ch.qos.logback" % "logback-classic" % "0.9.27",
        "joda-time" % "joda-time" % "2.0",
        "org.joda" % "joda-convert" % "1.1",
        "org.scala-tools.time" %% "time" % "0.5",
        "net.liftweb" %% "lift-common" % LIFT_VERSION,
        "net.liftweb" %% "lift-actor" % LIFT_VERSION,
        "net.liftweb" %% "lift-webkit" % LIFT_VERSION,
        "net.liftweb" %% "lift-json" % LIFT_VERSION,
        "net.liftweb" %% "lift-json-ext" % LIFT_VERSION,
        "javax.servlet" % "servlet-api" % "2.5" % "provided",
        "org.scalatest" % "scalatest" % "1.3" % "test",
        "commons-lang" % "commons-lang" % "2.4",
        "commons-codec" % "commons-codec" % "1.4",
        "commons-io" % "commons-io" % "2.1",
        "commons-httpclient" % "commons-httpclient" % "3.1"
    )
}

libraryDependencies ++= Seq (
//  "com.gu" %% "configuration" % "3.6",
//  "com.gu.openplatform" %% "content-api-client" % "1.12",
//  "com.gu" %% "opta" % "3.1",
  "commons-lang" % "commons-lang" % "2.4"
)

// and use this version of jetty for jetty run
libraryDependencies += "org.eclipse.jetty" % "jetty-webapp" % "7.3.1.v20110307" % "jetty"

//libraryDependencies += "com.gu" % "gu-deploy-libs" % "1.73" % "dist"

//distPath := file("/r2/ArtifactRepository/ipad-packager/trunk") /
//  ("trunk-build." + System.getProperty("build.number", "DEV")) / "artifacts.zip"

// include the war itself (this is the location we want the war to save to)
//distFiles <<= (packageWar in Compile) map { pkg => Seq( pkg -> "ipad-packager/webapps/ipad-packager.war") }

// and include custom scripts in src/main/deploy
//distFiles <++= (sourceDirectory in Compile) map { src =>
//  val deploy = src / "deploy"
//  (deploy ***) x rebase (deploy, "")
//}
