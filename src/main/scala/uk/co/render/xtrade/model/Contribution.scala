package uk.co.render.xtrade.model

import java.util.Date

case class Contribution(
	securityId: Int,
	askSize: Double = 0,
	bidSize: Double = 0,
	askPrice: Double = 0,
	bidPrice: Double = 0,
	quoteType: QuoteType = Price,
	ticker: String,
	maturity: Date)