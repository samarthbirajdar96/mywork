package com.example.SpringReactive;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterConfig {
	
	
	@Bean
	public RouterFunction<ServerResponse>routerFunction(){
		return route(RequestPredicates.GET("/route"),
				request->ServerResponse.ok().bodyValue("This is arout endpoint"));
	}

}
