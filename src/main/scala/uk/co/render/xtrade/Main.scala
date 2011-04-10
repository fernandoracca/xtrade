package uk.co.render.xtrade

import contribution.Contributor
import com.weiglewilczek.slf4s.Logging

object Main extends Logging {
	def main(args: Array[String]): Unit = {
		val status = Contributor().contribute(123456);
		logger.info(status.toString);
	}

}