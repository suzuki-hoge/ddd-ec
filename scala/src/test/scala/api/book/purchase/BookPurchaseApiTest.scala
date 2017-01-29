package api.book.purchase

import domain.payment.ConvenienceStorePaymentCode
import org.scalatest.FunSuite

class BookPurchaseApiTest extends FunSuite {
  test("success for convenience store") {
    val result: Either[String, PurchaseResponse] = BookPurchaseApi.apply(
      "user-1", "session-1", "mail-1", "isbn-1 isbn-2",
      "", "AtConvenienceStore",
      "c-store-code-1", "", "", "ConvenienceStore"
    )
    val expected = PurchaseResponse(Some(ConvenienceStorePaymentCode("c-store-p-code-1")))

    assert(result.right.get == expected)
  }

  test("success for address specification and pay there") {
    val result: Either[String, PurchaseResponse] = BookPurchaseApi.apply(
      "user-1", "session-1", "mail-1", "isbn-1 isbn-2",
      "", "AtReceived",
      "", "tokyo", "zip-1", "AddressSpecification"
    )
    val expected = PurchaseResponse(None)

    assert(result.right.get == expected)
  }

  test("failure for address specification and pay at convenience store") {
    val result: Either[String, PurchaseResponse] = BookPurchaseApi.apply(
      "user-1", "session-1", "mail-1", "isbn-1 isbn-2",
      "", "AtConvenienceStore",
      "", "tokyo", "zip-1", "AddressSpecification"
    )
    val expected = "invalid payment type and shipping type"

    assert(result.left.get == expected)
  }
}
