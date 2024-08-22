package com.example.SpringReactive;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ReactiveController {
	
	@GetMapping("/mono")
	public Mono<String> getMono(){
		return Mono.just("This is Mono");
	}
	
	
	@GetMapping("/flux")
	public Flux<String>getflux(){
		return Flux.just("This" ,"is", "Flux");
	}
	
	@GetMapping("/errorflux")
	public Flux<String> getFluxError(){
		return Flux.just("This" ,"is","flux")
				.concatWith(Flux.error(new RuntimeException("This is error")))
				.onErrorReturn("Error cleared");
	}
	
	

}
