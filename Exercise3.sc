import scala.math.max

def maxNum(num1: Int, num2: Int): Int = {max(num1, num2)}

def get_max(x:Int, y:Int, f:(Int,Int) => Int): Int = {f(x,y)}

println(get_max(25, 35, maxNum))