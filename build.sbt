name := "viconHelper"

// Custom keys for this build.

val gitHeadCommitSha = taskKey[String]("Determines the current git commit SHA")

val makeVersionProperties = taskKey[Seq[File]]("Creates a version.properties file we can find at runtime.")

// Common settings/definitions for the build

def ViconProject(name: String): Project = (
  Project(name, file(name))
  settings(
    version := "1.0",
    organization := "ro.ims",
    libraryDependencies += "org.specs2" % "specs2_2.10" % "1.14" % "test"
    libraryDependencies += "com.jsuereth" %% "scala-arm" % "1.3"
  )  
)

gitHeadCommitSha in ThisBuild := Process("git rev-parse HEAD").lines.head  

// Projects in this build

lazy val csv_interpreter = (
  ViconProject("csv_interpreter")
  settings(
	makeVersionProperties := {
	  val propFile = (resourceManaged in Compile).value / "version.properties"
	  val content = "version=%s" format (gitHeadCommitSha.value)
	  IO.write(propFile, content)
	  Seq(propFile)
	}
  )
)
