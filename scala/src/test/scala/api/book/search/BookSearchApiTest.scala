package api.book.search

import database.book.BookTable
import org.scalatest.FunSuite

class BookSearchApiTest extends FunSuite {
  test("no specifications") {
    assert(
      BookSearchApi.apply("", "") == List()
    )
  }

  test("1 specification") {
    assert(
      BookSearchApi.apply("novel", "") == List(BookTable.row1, BookTable.row2)
    )
  }

  test("2 specifications") {
    assert(
      BookSearchApi.apply("novel", "japanese") == List(BookTable.row1)
    )
  }
}
