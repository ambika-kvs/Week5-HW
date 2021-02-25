val numbers = for( a <- 1 to 9) yield a
println("New List = "+ numbers)

val oddNumbers = numbers.filter( (x: Int) => x%2 != 0)
println(oddNumbers)

def findCube(x:Int): Int = {x*x*x}

val numberCube = oddNumbers.map( (x: Int) => {findCube(x)})
for (numOdd <- numberCube) {
  println(numOdd)
}