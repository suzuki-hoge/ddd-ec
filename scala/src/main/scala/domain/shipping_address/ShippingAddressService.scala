package domain.shipping_address

object ShippingAddressService {
  def verify(requestedShippingAddress: RequestedShippingAddress): Either[String, ValidatedShippingAddress] = requestedShippingAddress match {
    case RequestedShippingAddress(Some(x: ConvenienceStoreCode), None, ConvenienceStore) => Right(ValidatedShippingAddress(x, ConvenienceStore))
    case RequestedShippingAddress(None, Some(x: ShippingAddress), AddressSpecification) => Right(ValidatedShippingAddress(x, AddressSpecification))
    case _ => Left("invalid shipping address")
  }
}
