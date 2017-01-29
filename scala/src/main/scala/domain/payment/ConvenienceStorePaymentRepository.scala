package domain.payment

trait ConvenienceStorePaymentRepository {
  def apply(amount: Amount): ConvenienceStorePaymentCode
}
