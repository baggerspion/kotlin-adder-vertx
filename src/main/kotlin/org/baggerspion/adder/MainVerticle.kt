package org.baggerspion.adder

import io.vertx.core.AbstractVerticle
import io.vertx.core.Future
import io.vertx.core.json.JsonObject
import io.vertx.ext.web.handler.BodyHandler
import io.vertx.ext.web.Router
import io.vertx.ext.web.RoutingContext
import io.vertx.kotlin.core.json.*

class MainVerticle : AbstractVerticle() {
  fun handleAddData(routingContext: RoutingContext) {
    var response = routingContext.response()
    var numsData: JsonObject = routingContext.getBodyAsJson()
    val result: Int = numsData.getInteger("operand1") + numsData.getInteger("operand2")

    response.putHeader("content-type", "application/json").end("{\"result\": $result}")
  }

  override fun start(startFuture: Future<Void>) {
    // Create the router
    var router = Router.router(vertx)
    router.route().handler(BodyHandler.create())
    router.post("/add").handler({handleAddData(it)})

    vertx.createHttpServer().requestHandler(router).listen(8080)
  }
}
