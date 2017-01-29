package domain.book

import domain.payment.Price

trait IsbnRepository {
  def fetchPrice(isbn: Isbn): Price
}
