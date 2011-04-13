package uk.co.render.xtrade

import org.specs2._

class BinomialOptionPricingSpec  extends SpecificationWithJUnit { def is =
  "Binomial option pricing for an asset"  					 	 		 ^
																		p^
    "For a call option " 		                 	 			 		 ^
	  "given an asset price of 100, volatility of 0.2 and"	  	         ^
	    "interest rate of 5%, strike price of 100 and "		  	         ^
		"expiration in 1 year in 4 steps"						  ! call1^
	  "given an asset price of 100, volatility of 0.2 and"               ^
		"interest rate of 5%, strike price of 100 and "		   			 ^
		"expiration in 1 year in 5 steps"						  ! call2
																	  	 end
	def call1 = CallOption(asset = 100, volatility = 0.2, interestRate = 0.05,
					strikePrice  = 100, expiry = 1, steps = 4) must be closeTo(9.9705, 0.0001)
	def call2 = CallOption(asset = 100, volatility = 0.2, interestRate = 0.05,
					strikePrice  = 100, expiry = 1, steps = 5) must be closeTo(10.8059, 0.0001)

}