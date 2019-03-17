package my.sheshenya.samplespringfunctionalmicroframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.netty.http.server.HttpServer;

import java.io.IOException;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;


public class SampleSpringFunctionalMicroframeworkApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		//SpringApplication.run(SampleSpringFunctionalMicroframeworkApplication.class, args);
		RouterFunction router = getRouter();
		HttpHandler handler = RouterFunctions.toHttpHandler(router);
		ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(handler);


		HttpServer
				.create()
				.host("localhost").port(8080)
				.handle(adapter)
				.bindNow();

		Thread.currentThread().join();
	}

	static RouterFunction<ServerResponse> getRouter() {
		HandlerFunction<ServerResponse> hello = request -> ok().body(fromObject("Hello"));
		HandlerFunction<ServerResponse> helloJson = request -> ok().contentType(APPLICATION_JSON).body(fromObject(new Foo("world")));

		return
				route(GET("/"), hello)
						.andRoute(
					  GET("/json"), helloJson );
	}

}
