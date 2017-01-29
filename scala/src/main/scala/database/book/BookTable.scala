package database.book

import domain.book._

case object BookTable {
  val row1 = Book(BookId("1"), BookName("foo"), Isbn("111"), Novel, Japanese)
  val row2 = Book(BookId("2"), BookName("bar"), Isbn("222"), Novel, English)
  val row3 = Book(BookId("3"), BookName("zak"), Isbn("333"), Comic, Japanese)
  val row4 = Book(BookId("4"), BookName("pon"), Isbn("444"), Comic, English)

  val rows = List(row1, row2, row3, row4)
}
