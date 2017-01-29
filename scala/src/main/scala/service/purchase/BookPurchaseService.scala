package service.purchase

import api.book.purchase.PurchaseRequest
import datasource.book.IsbnRepositoryApi
import datasource.stock.StockRepositoryDb
import domain.book.IsbnRepository
import domain.payment._
import domain.payment_and_shipping.PaymentAndShippingService
import domain.shipping_address.{ShippingAddressService, ValidatedShippingAddress}
import domain.stock.StockRepository
import service.local.PurchaseService

case object BookPurchaseService {
  val stockRepository: StockRepository = StockRepositoryDb
  val isbnRepository: IsbnRepository = IsbnRepositoryApi

  def apply(request: PurchaseRequest): Either[String, Option[ConvenienceStorePaymentCode]] = {
    val validPayment: Either[String, ValidatedPayment] = PaymentService.verify(request.requestedPayment)
    if (validPayment.isLeft) return validPayment.right.map(_ => None)

    val validShippingAddress: Either[String, ValidatedShippingAddress] = ShippingAddressService.verify(request.requestedShippingAddress)
    if (validShippingAddress.isLeft) return validShippingAddress.right.map(_ => None)

    val validatedType: Either[String, Unit] = PaymentAndShippingService.verify(request.requestedPayment.paymentType, request.requestedShippingAddress.shippingType)
    if (validatedType.isLeft) return validatedType.right.map(_ => None)

    val (existingIsbns, nonexistentIsbns) = request.isbns.partition(stockRepository.hasStock)
    existingIsbns.foreach(stockRepository.pick)

    val amount = Amount.create(existingIsbns.map(isbnRepository.fetchPrice).toList)

    val convenienceStorePaymentCode: Option[ConvenienceStorePaymentCode] = PurchaseService.apply(validPayment.right.get, amount)

    // ship

    // order

    // mail

    Right(convenienceStorePaymentCode)
  }
}
