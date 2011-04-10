import sbt._

class XTradeProject(info: ProjectInfo) extends DefaultProject(info)  {

	//with AkkaProject

  // Repositories
	val releases  = "releases"  at "http://scala-tools.org/repo-releases"
	val snapshots = "snapshots" at "http://scala-tools.org/repo-snapshots"

  	// Dependencies
	//logging
	val slf4j = "org.slf4j" % "slf4j-api" % "1.6.1"
	val logback = "ch.qos.logback" % "logback-classic" % "0.9.28"
	val slf4s = "com.weiglewilczek.slf4s" % "slf4s_2.8.1" % "1.0.4"

	//acceptance tests
	val specs2 = "org.specs2" % "specs2_2.8.1" % "1.1-SNAPSHOT"
	def specs2Framework = new TestFramework("org.specs2.runner.SpecsFramework")
	override def testFrameworks = super.testFrameworks ++ Seq(specs2Framework)
	override def includeTest(s: String) = Seq("Spec", "Unit").exists(s.endsWith(_))

	//val akkaRemote = akkaModule("remote")
}
