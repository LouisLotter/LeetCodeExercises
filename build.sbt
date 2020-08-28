name := "leetcode"

version := "0.1"

scalaVersion := "2.13.3"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.2" % Test
libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.14.3" % Test
libraryDependencies += "dev.zio" %% "zio-test" % "1.0.1" % Test withSources()

testFrameworks := Seq(new TestFramework("zio.test.sbt.ZTestFramework"))
