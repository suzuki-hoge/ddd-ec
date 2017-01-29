package api.book.purchase.form

import domain.shipping_address._

case object RequestedShippingAddressForms {
  def bind(convenienceStoreCode: String, address: String, zipCode: String, shippingType: String): RequestedShippingAddress = {
    RequestedShippingAddress(
      ConvenienceStoreCodeForm.bind(convenienceStoreCode),
      ShippingAddressForms.bind(address, zipCode),
      ShippingTypeForm.bind(shippingType)
    )
  }
}

case object ConvenienceStoreCodeForm {
  def bind(value: String): Option[ConvenienceStoreCode] = value match {
    case "" => None
    case x => Some(ConvenienceStoreCode(value))
  }
}

case object ShippingAddressForms {
  def bind(value1: String, value2: String): Option[ShippingAddress] = (value1, value2) match {
    case ("", _) => None
    case (_, "") => None
    case (x, y) => Some(ShippingAddress(Address(x), ZipCode(y)))
  }
}

case object ShippingTypeForm {
  def bind(value: String): ShippingType = value match {
    case "ConvenienceStore" => ConvenienceStore
    case "AddressSpecification" => AddressSpecification
  }
}
