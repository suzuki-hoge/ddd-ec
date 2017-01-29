package datasource.book.search

import database.book.BookTable
import domain.book._
import domain.book.search.{BookSearchRepository, Filter}

case object BookSearchRepositoryDb extends BookSearchRepository {

  def find(filter: Filter): List[Book] = (filter.genre, filter.language) match {
    case (Some(g), Some(l)) => BookTable.rows.filter(_.genre == g).filter(_.language == l)
    case (Some(g), None) => BookTable.rows.filter(_.genre == g)
    case (None, Some(l)) => BookTable.rows.filter(_.language == l)
    case (None, None) => List()
  }
}
