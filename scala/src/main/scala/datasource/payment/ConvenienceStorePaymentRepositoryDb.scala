package datasource.payment

import domain.payment.{Amount, ConvenienceStorePaymentCode, ConvenienceStorePaymentRepository}

case object ConvenienceStorePaymentRepositoryDb extends ConvenienceStorePaymentRepository {
  def apply(amount: Amount): ConvenienceStorePaymentCode = ConvenienceStorePaymentCode("c-store-p-code-1")
}
