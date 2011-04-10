package uk.co.render.xtrade.market

import com.weiglewilczek.slf4s.Logging
import uk.co.render.xtrade.model.{Success, ContributionStatus, Contribution}

object MarketConnector {
	def apply() = {
		new BloomzergMarketConnector()
	}
}

abstract class MarketConnector {
	def publish(contribution: Contribution): ContributionStatus
}

class BloomzergMarketConnector extends MarketConnector with Logging {

	override def publish(contribution: Contribution) = {
		logger.info(contribution.toString)
		Success
	}
}