def fibFrom(a:Int, b:Int): Stream[Int] = a #:: fibFrom(b, a+b)
val r = fibFrom(1,1).takeWhile(i => i <= 4000000).filter(i => i % 2 == 0).sum

println(r)

