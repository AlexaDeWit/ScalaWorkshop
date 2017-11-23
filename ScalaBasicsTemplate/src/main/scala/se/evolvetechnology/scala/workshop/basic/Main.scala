package se.evolvetechnology.scala.workshop.basic

import cats.effect.{IO}
import scala.io.StdIn


object Main {

  def main(args: Array[String]): Unit = {
    var canChange = 5 //a mutable Int... In the scala world we generally avoid var at all costs.
    val betterConst = 5 //an immutable constant Int, but possible to determine at runtime!
    val runtimeConst = StdIn.readLine("Synchronous Response:") //Notice here, val is created at runtime, yet remains immutable
    //That said, we don't WANT to just run readLine() synchronously. Readline is a non-pure function! I don't like that stuff!
    Console.println(s"\n Synch Response Was: $runtimeConst")
    //Here, lets model the act of retrieving a line of text from the console as a value in and of itself.
    val safeRuntimeConst: IO[String] = IO(StdIn.readLine("\nIO Response:"))

    //Now, run the application... Notice that we only ever get one input from the console. WHAT?
    //The reason for this is that IO values are lazily evaluated. They simply encapsulate a definition for behaviour with types,
    //but they do not themselves -execute- unless explicitly instructed to.
    //Lets go ahead now then and -descript- the act of echoing that line back to the console, shall we?
    val echoToConsole: IO[Unit] = safeRuntimeConst.map(input => Console.println(s"\nAsynch Response was: $input"))

    //We'll find that, still, we get no action on the console. Maybe this is why people always say it's hard to "do anything"
    //in haskell.... so far we're "describing" the doing all day, hell, we can map actions to other actions, compose them all day.


    //Uncomment the line below, lets make it run the unsafe way, shall we?
    echoToConsole.unsafeRunSync() //Synchronously and unsafely run an IO.
  }


}
