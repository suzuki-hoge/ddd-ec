package api.book.purchase.form

import api.book.purchase.PurchaseRequest
import domain.account.{MailAddress, SessionId, UserId}
import domain.book.Isbn
import domain.payment.{AtConvenienceStore, AtReceived, RequestedPayment}
import domain.shipping_address._
import org.scalatest.FunSuite

class PurchaseFormsTest extends FunSuite {
  test("pick convenience store, and pay there") {
    val in = PurchaseForms.bind(
      "user-1", "session-1", "mail-1", "isbn-1 isbn-2",
      "", "AtConvenienceStore",
      "c-store-code-1", "", "", "ConvenienceStore"
    )
    val out = PurchaseRequest(
      UserId("user-1"), SessionId("session-1"), MailAddress("mail-1"), List(Isbn("isbn-1"), Isbn("isbn-2")),
      RequestedPayment(None, AtConvenienceStore),
      RequestedShippingAddress(Some(ConvenienceStoreCode("c-store-code-1")), None, ConvenienceStore)
    )

    assert(in == out)
  }

  test("receive specification address, and pay there") {
    val in = PurchaseForms.bind(
      "user-1", "session-1", "mail-1", "isbn-1 isbn-2",
      "", "AtReceived",
      "", "tokyo", "zip-1", "AddressSpecification"
    )
    val out = PurchaseRequest(
      UserId("user-1"), SessionId("session-1"), MailAddress("mail-1"), List(Isbn("isbn-1"), Isbn("isbn-2")),
      RequestedPayment(None, AtReceived),
      RequestedShippingAddress(None, Some(ShippingAddress(Address("tokyo"), ZipCode("zip-1"))), AddressSpecification)
    )

    assert(in == out)
  }

  test("received, but pay convenience store (it is invalid specification, but valid request)") {
    val in = PurchaseForms.bind(
      "user-1", "session-1", "mail-1", "isbn-1 isbn-2",
      "", "AtConvenienceStore",
      "", "tokyo", "zip-1", "AddressSpecification"
    )
    val out = PurchaseRequest(
      UserId("user-1"), SessionId("session-1"), MailAddress("mail-1"), List(Isbn("isbn-1"), Isbn("isbn-2")),
      RequestedPayment(None, AtConvenienceStore),
      RequestedShippingAddress(None, Some(ShippingAddress(Address("tokyo"), ZipCode("zip-1"))), AddressSpecification)
    )

    assert(in == out)
  }
}
