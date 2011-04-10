package uk.co.xtrade.acceptance

import org.specs2._

/**
 * Dev: Fernando Racca (fracca@gmail.com)
 * Creation Date: 06/04/2011 22:32
 */
class SimpleSpec extends SpecificationWithJUnit { def is =

    "This is a specification to check the 'Hello world' string"                 ^
                                                                                p^
    "The 'Hello world' string should"                                           ^
      "contain 11 characters"                                                   ! e1^
      "start with 'Hello'"                                                      ! e2^
      "end with 'world'"                                                        ! e3^
                                                                                end
    def e1 = "Hello world" must have size(11)
    def e2 = "Hello world" must startWith("Hello")
    def e3 = "Hello world" must endWith("world")
}