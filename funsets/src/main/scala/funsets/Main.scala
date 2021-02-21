package funsets

object Main extends App {
  import FunSets._
  println(contains(singletonSet(1), 1))
  println(contains(singletonSet(1), 2))

  val x = singletonSet(2)
  val y = singletonSet(1)

  println("union")

  println(contains(union(x,y), 1))
  println(contains(union(x,y), 2))
  println(contains(union(x,y), 3))

  println("intersect")

  println(contains(intersect(x,x), 2))
  println(contains(intersect(y,y), 2))
  println(contains(intersect(x,union(x,y)), 1))
  println(contains(intersect(x,union(x,y)), 2))
  println(contains(intersect(x,union(x,y)), 3))

  println("diff")

  println(contains(diff(x,x), 2))
  println(contains(diff(y,y), 2))
  println(contains(diff(union(x,y), x), 1))
  println(contains(diff(union(x,y), x), 2))
  println(contains(diff(union(x,y), x), 3))

  println("filter")
  println(contains(filter(union(x,y), a => a < 2), 1))
  println(contains(filter(union(x,y), a => a < 2), 2))
  println(contains(filter(union(x,y), a => a < 2), 3))

  println("forall")
  println(forall(union(x,y), a => a < 2))
  println(forall(union(x,y), a => a < 3))

  println("exists")
  println(exists(union(x,y), a => a < 2))
  println(exists(union(x,y), a => a > 3))

  println("map")
  println(contains(map(x, a => a+10), 11))
  println(contains(map(x, a => a+10), 1))
  println(contains(map(x, a => a+10), 2))
  println(contains(map(x, a => a+10), 12))
}
