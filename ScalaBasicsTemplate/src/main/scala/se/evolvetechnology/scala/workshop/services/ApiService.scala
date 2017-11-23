package se.evolvetechnology.scala.workshop.services

import cats.effect.{Effect, IO}
import org.http4s.HttpService
import org.http4s.dsl.Http4sDsl

case class ApiService() extends Http4sDsl[IO] {
  def route : HttpService[IO] = HttpService {
    case GET -> Root =>  Ok()
  }
}
