package py.com.rentacar.resources;

import java.util.Optional;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import py.com.rentacar.models.User;
import py.com.rentacar.service.UserService;

/**
 * @author mmartinez 
 * @class UserResource
 * En esta clase se recibiran las peticiones realizadas desde el Front-End
 * siempre teniendo en cuenta la ruta y el tipo de peticion realizada
 */
public class UserResource extends AbstractVerticle {

	private UserService service = new UserService();

	@Override
	public void start(Future<Void> fut) {
		Router router = Router.router(vertx);

		router.get("/users")
				.handler(routingContext -> routingContext.response()
						.putHeader("content-type", "application/json; charset=utf-8")
						.end(Json.encodePrettily(service.findAll())));

		router.get("/users/:username").handler(routingContext -> {
			Optional<User> result = service.findByUsername(routingContext.request().getParam("username"));
			if (result.isPresent()) {
				routingContext.response().setStatusCode(200)
						.putHeader("content-type", "application/json; charset=utf-8")
						.end(Json.encode(result.get()));
			} else {
				routingContext.response().setStatusCode(404);
			}
		});

		router.post("/users").handler(routingContext -> {
			
			User user = Json.decodeValue(routingContext.getBodyAsString(), User.class);
			service.create(user);
			
			routingContext.response().setStatusCode(201)
					.putHeader("content-type", "application/json; charset=utf-8")
					.end(Json.encodePrettily(user));
		});

		vertx.createHttpServer().requestHandler(router::accept).listen(config().getInteger("http.port", 8080),
				result -> {
					if (result.succeeded()) {
						fut.complete();
					} else {
						fut.fail(result.cause());
					}
				});
	}

}