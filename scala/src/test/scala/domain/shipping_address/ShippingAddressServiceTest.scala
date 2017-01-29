package domain.shipping_address

import org.scalatest.FunSuite

class ShippingAddressServiceTest extends FunSuite {
  test("right for address specification") {
    val in = RequestedShippingAddress(Some(ConvenienceStoreCode("123")), None, ConvenienceStore)
    val out = ValidatedShippingAddress(ConvenienceStoreCode("123"), ConvenienceStore)
    assert(ShippingAddressService.verify(in) == Right(out))
  }

  test("left for else") {
    val in = RequestedShippingAddress(None, None, AddressSpecification)
    assert(ShippingAddressService.verify(in) == Left("invalid shipping address"))
  }
}
