package renta_car;

import io.swagger.jaxrs.config.BeanConfig;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Servlet de inicializacion para configurar host, path base, version, y
 * paquetes de la API
 */
@WebServlet(name = "SwaggerJaxrsConfiguration", loadOnStartup = 2)
public class SwaggerJaxrsConfiguration extends HttpServlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("== LLAMADA A SERVLET DE SWAGGER==");
        super.init(servletConfig);
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");// version
        beanConfig.setTitle("API RentaCar");// nombre que vamos a utilizar para la API
        beanConfig.setSchemes(new String[]{"http"});
        // String host = "10.150.12.211:8380"; //Debe ser la ip del servidor donde se va
        // a levantar la api
        String host = "127.0.0.1:8080";
        beanConfig.setHost(host);
        beanConfig.setBasePath("/");// uri base para acceder a los endpoints
        beanConfig.setResourcePackage("py.com.rentacar.service"); // paquete donde estan los servicios
        beanConfig.setScan(true);
    }
}
