package com.siva.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.siva.model.Gamer;

import reactor.core.publisher.Flux;

//@Component

public class ReactiveRDBMSRunner implements CommandLineRunner {

	/*@Autowired
	private IGamerServiceMnmg gamerService;
	*/
	
	WebClient client = WebClient.create("http://localhost:9091");
	@Override
	public void run(String... args) throws Exception {
	
		
	System.out.println("ReactiveRDBMSRunner.run() Start");
		Flux<Gamer> flux = client
			      .get()
			      .uri("/gamer-api/all")
	              .retrieve()
	              .bodyToFlux(Gamer.class);
	
		flux.subscribe(System.out::println);
		
		System.out.println("ReactiveRDBMSRunner.run()  end-");
		
	}
	
}


