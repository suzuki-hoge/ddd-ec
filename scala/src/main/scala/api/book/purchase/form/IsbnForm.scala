package api.book.purchase.form

import domain.book.Isbn

case object IsbnForm {
  def bind(value: String): List[Isbn] = value.split(" ").map(x => Isbn(x)).toList
}
