package uk.co.xtrade.acceptance

import org.specs2._

/**
 * Dev: Fernando Racca (fracca@gmail.com)
 * Creation Date: 06/04/2011 23:35
 */
class BookSellerSpec extends SpecificationWithJUnit   {   def is =
	  // the execution needs to be sequential
  sequential                                                                                       ^
  "Given that the customer buys 3 books at 10 dollars each"                                        ! c1.buyBook^
  "Given that the customer buys 1 book at 20 dollars"                                              ! c1.buyBook^
  "When he checks out"                                                                             ! c1.checkout^
  "Then the total price must be 50 dollars"                                                        ! c1.total^
                                                                                                   end

  case object c1 {
    val BuyBooks = ".* buys (\\d+) book.? at (\\d+) .*".r     // a regular expression for extracting the quantity and price
    val TotalBooks = ".* must be (\\d+) .*".r                 // a regular expression for extracting the total price
    val books: scala.collection.mutable.Map[Int, Int] = new scala.collection.mutable.HashMap[Int, Int]()

    def buyBook = (s: String) => {
      val BuyBooks(qty, price) = s
      books += qty.toInt -> price.toInt
      success
    }
    def checkout = books.pp must not be empty
    def total = (s: String) => {
      val TotalBooks(total) = s
      books.foldLeft(0)((res, cur) => res + cur._1 * cur._2) must be equalTo(total.toInt)
    }
  }
}

