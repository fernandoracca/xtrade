package uk.co.render.xtrade.model


sealed abstract class ContributionStatus
case object ContributionSuccess extends ContributionStatus
case object ContributionFailure extends ContributionStatus