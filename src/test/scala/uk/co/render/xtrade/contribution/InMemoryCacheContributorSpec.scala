package uk.co.render.xtrade.contribution

import org.specs2._
import org.specs2.mock._
import uk.co.render.xtrade.market.MarketConnector
import uk.co.render.xtrade.model.{ContributionFailure, Contribution, ContributionSuccess}

class InMemoryCacheContributorSpec  extends SpecificationWithJUnit { def is =

  "In memory contributor"                                                    ^
    "will publish security 123456"                           ! test().publish^
    "will not publish other securities"                  ! test().dontPublish^
                                                                           end
    case class test() extends Mockito {
    	val marketConnector = mock[MarketConnector]
		val testObject = new InMemoryCacheContributor(marketConnector)

    	def publish = {
			val contribution = testObject.buildContribution(123456)
            marketConnector.publish(contribution) returns ContributionSuccess
            val status = testObject.contribute(123456)
            there was one(marketConnector).publish(contribution)
			status must be equalTo(ContributionSuccess)
        }

        def dontPublish = {
			val status = testObject.contribute(654321)
			there was no(marketConnector).publish(any[Contribution])
			status must be equalTo(ContributionFailure)
		}
    }
}