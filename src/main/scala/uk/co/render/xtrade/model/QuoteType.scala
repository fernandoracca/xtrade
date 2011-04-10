package uk.co.render.xtrade.model

sealed abstract class QuoteType
case object Price extends QuoteType
case object Yield extends QuoteType
case object Spread extends QuoteType