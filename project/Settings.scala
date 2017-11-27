import sbt._
import Keys._
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._

object Settings {

  val name = "gov.nasa.jpl.imce.omf.resolver"

  val namespace = "gov.nasa.jpl.imce.omf.resolver"

  val organization = "gov.nasa.jpl.imce"

  val version = "0.90.0"

  val scalacOptions = Seq(
    "-deprecation",
    "-encoding", "UTF-8",     // yes, this is 2 args
    "-feature",
    "-language:existentials",
    "-language:higherKinds",
    "-language:implicitConversions",
    "-unchecked",
    "-Xfatal-warnings",
    "-Xlint",
    "-Yno-adapted-args",
    "-Ywarn-dead-code",       // N.B. doesn't work well with the ??? hole
    "-Ywarn-numeric-widen",
    "-Ywarn-value-discard",
    "-Xfuture",
    "-Ywarn-unused-import",   // 2.11 only
    "-Yno-imports"            // no automatic imports at all; all symbols must be imported explicitly
  )

  object versions {
    val jpl_omf_schema_tables = "0.90.0-M27"
    val scala = "2.11.11"
    val scalaJ8CompatVersion = "0.8.0"
  }

  /**
    * These dependencies are shared between JS and JVM projects
    * the special %%% function selects the correct version for each project
    */
  val sharedDependencies = Def.setting(Seq(
  ))


  /** Dependencies only used by the JVM project */
  val jvmDependencies = Def.setting(Seq(
    "gov.nasa.jpl.imce" %% "gov.nasa.jpl.imce.oml.tables" % versions.jpl_omf_schema_tables
  ))


  /** Dependencies only used by the JS project (note the use of %%% instead of %%) */
  val scalajsDependencies = Def.setting(Seq(
    "gov.nasa.jpl.imce" %%% "gov.nasa.jpl.imce.oml.tables" % versions.jpl_omf_schema_tables
  ))

}