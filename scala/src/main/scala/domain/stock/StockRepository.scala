package domain.stock

import domain.book.Isbn

trait StockRepository {
  def hasStock(isbn: Isbn): Boolean

  def pick(isbn: Isbn): Unit
}
