package se.evolvetechnology.scala.workshop.test.services

import cats.effect.IO
import org.http4s.{HttpService, Method, Request, Uri}
import org.scalatest._
import se.evolvetechnology.scala.workshop.services.ApiService
import org.http4s.dsl.io._

class ApiServiceSpec extends FlatSpec with Matchers {
  
  private lazy val apiService = ApiService().route.orNotFound
  "The Api Service" should "return a 200 OK response at its root" in {
    val getRoot = Request[IO](Method.GET, uri("/"))
    val root = apiService.run(getRoot).unsafeRunSync()
    Ok shouldBe root.status
  }


  "The api service" should "return a not found response when failing to match a route" in {
    val getMeaningless = Request[IO](Method.GET, uri("/fake/path"))
    val meaningless = apiService.run(getMeaningless).unsafeRunSync()
    NotFound shouldBe meaningless.status
  }

}
