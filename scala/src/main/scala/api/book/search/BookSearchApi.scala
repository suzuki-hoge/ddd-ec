package api.book.search

import api.book.search.form.FilterForms
import domain.book.Book
import service.search.BookSearchService

case object BookSearchApi {
  def apply(genre: String, language: String): List[Book] = {
    val filter = FilterForms.bind(genre, language)
    BookSearchService.apply(filter)
  }
}
