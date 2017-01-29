package service.search

import datasource.book.search.BookSearchRepositoryDb
import domain.book.Book
import domain.book.search.{BookSearchRepository, Filter}

case object BookSearchService {
  val repository: BookSearchRepository = BookSearchRepositoryDb

  def apply(filter: Filter): List[Book] = repository.find(filter)
}
