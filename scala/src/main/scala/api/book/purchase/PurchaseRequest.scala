package api.book.purchase

import domain.account.{MailAddress, SessionId, UserId}
import domain.book.Isbn
import domain.payment.RequestedPayment
import domain.shipping_address.RequestedShippingAddress

case class PurchaseRequest(
                            userId: UserId,
                            sessionId: SessionId,
                            mailAddress: MailAddress,
                            isbns: List[Isbn],
                            requestedPayment: RequestedPayment,
                            requestedShippingAddress: RequestedShippingAddress
                            )
