package uk.co.render.xtrade

import contribution.Contributor
import com.weiglewilczek.slf4s.Logging

class Main {
	def contribute(securityId:Int) = Contributor().contribute(securityId)
}

object Main extends Logging {
	def apply() = { new Main() }

	def main(args: Array[String]): Unit = {
		val status = Main().contribute(123456)
		logger.info(status.toString);
	}
}