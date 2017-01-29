package domain.payment_and_shipping

import domain.payment.{AtConvenienceStore, AtReceived, PayWithCreditCard, PaymentType}
import domain.shipping_address.{AddressSpecification, ConvenienceStore, ShippingType}

case object PaymentAndShippingService {
  def verify(paymentType: PaymentType, shippingType: ShippingType): Either[String, Unit] = (paymentType, shippingType) match {
    case (PayWithCreditCard, _) => Right()
    case (AtConvenienceStore, ConvenienceStore) => Right()
    case (AtReceived, AddressSpecification) => Right()
    case _ => Left("invalid payment type and shipping type")
  }
}
