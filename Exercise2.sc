
val numList = for( a <- 1 to 45) yield a
println("New List = "+ numList)

val sumBy4 = numList.filter( (x: Int) => x%4 == 0).sum
println("Sum of the numbers divisible by 4 = "+ sumBy4)


val sumBy3 = numList.filter((y: Int) => ((y*y)%3 == 0) && (y < 20)).sum
println("Sum of the squares of the numbers divisible by 3 and less than 20 = "+sumBy3)