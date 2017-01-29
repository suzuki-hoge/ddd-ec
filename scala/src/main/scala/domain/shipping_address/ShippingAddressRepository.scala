package domain.shipping_address

trait ShippingAddressRepository {
  def convert(convenienceStoreCode: ConvenienceStoreCode): ShippingAddress
}
