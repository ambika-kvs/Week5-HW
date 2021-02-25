def greet1(name: String) : Unit = {
  println("Hello " + name + ", How are you doing?")
}

def greet2(name: String) : Unit = {
  println("Hey " + name + ", How was your day?")
}

def frame(x: String, f: String => Unit) : Unit = {f(x)}

frame("Alice", greet1)
frame("Nick", greet2)