package api.book.purchase

import domain.payment.ConvenienceStorePaymentCode

case class PurchaseResponse(convenienceStorePaymentCode: Option[ConvenienceStorePaymentCode])

