package datasource.book

import domain.book.{Isbn, IsbnRepository}
import domain.payment.Price

case object IsbnRepositoryApi extends IsbnRepository {
  def fetchPrice(isbn: Isbn): Price = Price(1000)
}
