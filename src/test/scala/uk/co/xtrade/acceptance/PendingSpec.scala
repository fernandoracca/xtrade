package uk.co.xtrade.acceptance

import org.specs2._

class PendingSpec extends SpecificationWithJUnit { def is =

	"this example fails for now"  ! e1

	def e1 = { 1 must be equalTo(2) }.pendingUntilFixed("ISSUE-123")

}