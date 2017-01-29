package domain.order

import domain.account.{MailAddress, UserId}
import domain.book.Book

case class Order(userId: UserId, mailAddress: MailAddress, items: List[Item])

case class Item(book: Book)