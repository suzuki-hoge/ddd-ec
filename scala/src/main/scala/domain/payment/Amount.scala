package domain.payment

case class Amount(value: Int)

case object Amount {
  def create(prices: List[Price]): Amount = Amount(prices.map(_.value).sum)
}

case class Price(value: Int)