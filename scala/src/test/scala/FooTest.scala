import org.scalatest.FunSuite

class FooTest extends FunSuite {

  test("add2") {
    assert(
      Foo(2).add2 == Foo(4)
    )
  }
}

