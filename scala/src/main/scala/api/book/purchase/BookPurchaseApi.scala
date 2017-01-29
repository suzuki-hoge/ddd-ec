package api.book.purchase

import api.book.purchase.form.PurchaseForms
import service.purchase.BookPurchaseService

case object BookPurchaseApi {
  def apply(
             userId: String,
             sessionId: String,
             mailAddress: String,
             isbns: String,
             creditCard: String,
             paymentType: String,
             convenienceStoreCode: String,
             address: String,
             zipCode: String,
             shippingType: String
             ): Either[String, PurchaseResponse] = {
    val request = PurchaseForms.bind(
      userId, sessionId, mailAddress, isbns,
      creditCard, paymentType,
      convenienceStoreCode, address, zipCode, shippingType
    )
    // auth
    BookPurchaseService.apply(request).right.map(PurchaseResponse)
  }
}
