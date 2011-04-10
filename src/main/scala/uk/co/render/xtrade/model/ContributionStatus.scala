package uk.co.render.xtrade.model


sealed abstract class ContributionStatus
case object Success extends ContributionStatus
case object Failure extends ContributionStatus