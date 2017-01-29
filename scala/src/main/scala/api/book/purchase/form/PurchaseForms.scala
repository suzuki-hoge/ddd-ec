package api.book.purchase.form

import api.book.purchase.PurchaseRequest

case object PurchaseForms {
  def bind(
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
            ): PurchaseRequest = PurchaseRequest(
    UserIdForm.bind(userId),
    SessionIdForm.bind(sessionId),
    MailAddressForm.bind(mailAddress),
    IsbnForm.bind(isbns),
    RequestedPaymentForms.bind(creditCard, paymentType),
    RequestedShippingAddressForms.bind(convenienceStoreCode, address, zipCode, shippingType)
  )
}
