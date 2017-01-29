package domain.shipping_address

case class ShippingAddress(address: Address, zipCode: ZipCode) extends ShippingInformation

case class Address(value: String)

case class ZipCode(value: String)

