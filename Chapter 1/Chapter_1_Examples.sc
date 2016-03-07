val x = "Hello, World"
val r1 = x.reverse
val r2 = x.reverse  // r1 and r2 are the same

val y = new StringBuilder("Hello")
val z = y.append(", World")
val r3 = z.toString
val r4 = z.toString // r3 and r4 are the same
val r5 = y.append(", World").toString
val r6 = y.append(", World").toString // r5 and r6 are no longer the same, StringBuilder is not a pure function