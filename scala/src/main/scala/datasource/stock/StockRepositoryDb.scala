package datasource.stock

import domain.book.Isbn
import domain.stock.StockRepository

object StockRepositoryDb extends StockRepository {
  def hasStock(isbn: Isbn): Boolean = isbn.value match {
    case "isbn-2" => false
    case _ => true
  }

  def pick(isbn: Isbn): Unit = {
    println("pick " + isbn)
  }
}
