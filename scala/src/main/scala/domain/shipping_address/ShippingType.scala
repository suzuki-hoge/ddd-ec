package domain.shipping_address

sealed trait ShippingType

case object ConvenienceStore extends ShippingType

case object AddressSpecification extends ShippingType
