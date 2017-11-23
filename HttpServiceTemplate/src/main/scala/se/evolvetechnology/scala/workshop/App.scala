package se.evolvetechnology.scala.workshop

import cats.effect.IO
import org.http4s.server.blaze.BlazeBuilder
import org.http4s.util.{ExitCode, StreamApp}
import fs2.Stream
import se.evolvetechnology.scala.workshop.services.ApiService

object App extends StreamApp[IO] {
  lazy val apiService = ApiService().route
  override def stream(args: List[String], requestShutdown: IO[Unit]): Stream[IO, ExitCode] = {
    BlazeBuilder[IO]
      .bindHttp(8080, "0.0.0.0")
      .mountService(apiService, "/")
      .serve
  }
}
