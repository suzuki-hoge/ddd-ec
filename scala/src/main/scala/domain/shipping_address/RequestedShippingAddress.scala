package domain.shipping_address

case class RequestedShippingAddress(
                                     convenienceStoreCode: Option[ConvenienceStoreCode],
                                     shippingAddress: Option[ShippingAddress],
                                     shippingType: ShippingType
                                     )
