package uk.co.render.xtrade

import org.specs2._

class BinomialOptionPricingSpec  extends SpecificationWithJUnit { def is =
  "Binomial option pricing for an asset"  					 	 		 ^
																		p^
    "The correct price for a call option " 		                 	 			 		 ^
		"given an asset price of 100, volatility of 20%, "	  		     ^
			"interest rate of 5%, strike price of 100 and "		  	     ^
			"expiration in 1 year, calculated in 4 steps"		  ! call1^
		                                                                p^
		"given an asset price of 100, volatility of 20%, "               ^
			"interest rate of 5%, strike price of 100 and "		   		 ^
			"expiration in 1 year, calculated in 5 steps"		  ! call2^
	 															 	  end^
	"The correct price for a put option "                                ^
		"given an asset price of 100, volatility of 20%,"         		 ^
			"interest rate of 5%, strike price of 100 and "	  			 ^
			"expiration in 1 year, calculated in 4 steps"		   ! put1^
																	   end
	def call1 = CallOption(asset = 100, volatility = 0.2, interestRate = 0.05,
					strikePrice  = 100, expiry = 1,
					steps = 4) must be closeTo(9.9705, 0.0001)
	def call2 = CallOption(asset = 100, volatility = 0.2, interestRate = 0.05,
					strikePrice  = 100, expiry = 1,
					steps = 5) must be closeTo(10.8059, 0.0001)
	def put1  =	{PutOption(asset  = 100, volatility = 0.2, interestRate = 0.05,
					strikePrice  = 100, expiry = 1,
					steps = 4) must be closeTo(6.152764, 0.0001)}.pendingUntilFixed("ISSUE-123")
}