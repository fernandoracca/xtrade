package uk.co.render.xtrade

import model.{Failure, Success}
import org.specs2._

class MarketContributionSpec  extends SpecificationWithJUnit { def is =
	"Securities are contributed to market"  					 	 ^
																	p^
		"Contributions to Bloomzerg must" 		                 	 ^
		  "succeed when publishing security id 123456"           ! e1^
		  "fail when publishing any other security id"           ! e2
																	end
	def e1 = Main().contribute(123456) must be equalTo(Success)
	def e2 = Main().contribute(654321) must be equalTo(Failure)

}