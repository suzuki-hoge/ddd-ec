package domain.book.search

import domain.book.Book

trait BookSearchRepository {
  def find(filter: Filter): List[Book]
}

