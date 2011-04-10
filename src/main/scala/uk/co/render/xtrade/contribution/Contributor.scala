package uk.co.render.xtrade.contribution

import java.util.{GregorianCalendar, Calendar, Date}
import uk.co.render.xtrade.model.{ContributionStatus, Contribution, ContributionFailure}
import uk.co.render.xtrade.market.{BloomzergMarketConnector, MarketConnector}

object Contributor {
	def apply():Contributor = {
		return apply(marketConnector = MarketConnector())
	}
	def apply(marketConnector: MarketConnector):Contributor = {
		return new InMemoryCacheContributor(marketConnector)
	}
}

abstract class Contributor {
	def contribute(securityId: Int) : ContributionStatus
}

class InMemoryCacheContributor(marketConnector: MarketConnector) extends Contributor {

	override def contribute(securityId: Int) = {
		securityId match {
			case 123456 => marketConnector.publish(buildContribution(securityId))
			case _ => ContributionFailure;
		}
	}

	def buildContribution(securityId: Int) = {
		new Contribution(securityId, askSize = 10000, bidSize = 8000,
						askPrice = 100, bidPrice = 99,
						ticker = "JPM 3 1/2 12-18",
						maturity = getTime(2018,12,1))
	}

	 def getTime(year: Int, month: Int, day: Int) ={ //implicits example !!!
		new GregorianCalendar(year,month,day).getTime
	}

}