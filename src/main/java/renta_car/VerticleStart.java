package renta_car;

import io.vertx.core.AbstractVerticle;
import org.jboss.resteasy.plugins.server.vertx.VertxRequestHandler;
import org.jboss.resteasy.plugins.server.vertx.VertxResteasyDeployment;
import py.com.rentacar.service.UserService;
import py.com.rentacar.service.VehiculoService;


public class VerticleStart extends AbstractVerticle {

    // Convenience method so you can run it in your IDE
    public static void main(String[] args) {
        Runner.runExample(VerticleStart.class);
    }

    @Override
    public void start() throws Exception {

        // Build the Jax-RS hello world deployment
        VertxResteasyDeployment deployment = new VertxResteasyDeployment();
        deployment.start();
        deployment.getRegistry().addPerInstanceResource(UserService.class);
        deployment.getRegistry().addPerInstanceResource(VehiculoService.class);

        // Start the server using the Jax-RS controller
        vertx.createHttpServer()
                .requestHandler(new VertxRequestHandler(vertx, deployment))
                .listen(8080, ar -> {
                    System.out.println("Server started on " + ar.result().actualPort());
                });
    }

}

