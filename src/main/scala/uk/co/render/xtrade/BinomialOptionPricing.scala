package uk.co.render.xtrade

import scala.math._

trait BinomialOptionPricing {

	def apply(asset: Double, volatility: Double, interestRate: Double,
			strikePrice: Double, expiry: Double, steps: Int): Double = {

		val timeStep = expiry / steps
		val timeStepSquare = sqrt(timeStep)
		val discountFactor = exp(-interestRate * timeStep);

		val u = exp(volatility * timeStepSquare);
		val d = exp(-volatility * timeStepSquare);
		val p = (exp(interestRate * timeStep) - d) / (u - d);

		val assetValuations = calculateAssetValuations(asset, steps, u, d);
		val optionPayoffs   = calculateOptionPayoffs(strikePrice, steps, assetValuations);

		calculateOptionValue(steps, discountFactor, p, optionPayoffs);
	}

	def calculateAssetValuations(asset: Double, steps: Int,	u: Double, d: Double): Array[Double] = {
		val assetValues = new Array[Double](steps+1)
		assetValues(0) = asset
		for(i <- 1 to steps) {
			for(j <- i to 1 by -1){
				assetValues(j) = u * assetValues(j - 1)
			}
			assetValues(0) =  d * assetValues(0)
		}
		assetValues
	}

	def calculateOptionPayoffs(strikePrice: Double, steps: Int, assetValues: Array[Double]):Array[Double] = {
		val payoffs = for (i <- 0 to steps) yield payoff(assetValues(i), strikePrice)
		return payoffs.toArray[Double]
	}

	def payoff(asset: Double, strike: Double): Double

	def calculateOptionValue(steps: Int, discountFactor: Double, p: Double, optionPayoffs: Array[Double]): Double = {
		for (i <- steps until 0 by -1) {
			for(j <- 0 until i) {
				optionPayoffs(j) = (p * optionPayoffs(j + 1) + (1 - p) * optionPayoffs(j)) * discountFactor
			}
		}
		optionPayoffs(0)
	}
}

case object CallOption extends BinomialOptionPricing {

 	def payoff(asset: Double, strike: Double): Double = asset match {
		case asset if asset > strike => asset - strike
		case _ => 0
	}
}

case object PutOption extends BinomialOptionPricing {

	def payoff(asset: Double, strike: Double): Double = asset match {
		case asset if asset < strike => strike - asset
		case _ => 0
	}
}