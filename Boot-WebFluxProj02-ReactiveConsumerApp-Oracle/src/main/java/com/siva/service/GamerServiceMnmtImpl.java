package com.siva.service;

import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.siva.model.Gamer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class GamerServiceMnmtImpl implements IGamerServiceMnmg {


	WebClient client = WebClient.create("http://localhost:9091");
	
	
	@Override
	public Mono<String> saveGamer(Gamer gamer) {
		// TODO Auto-generated method stub
		 Mono<String> mono = client
				 .post()
				  .uri("gamer-api/save")
	                .bodyValue(gamer)
	                .retrieve()
	                .bodyToMono(String.class);
		return mono;
	}

	@Override
	public Flux<String> ListOfSaveGamer(List<Gamer> listgamer) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public Flux<Gamer> getAllGamers() {
		// TODO Auto-generated method stub
		Flux<Gamer> flux = client
				      .get()
				      .uri("/gamer-api/all")
		              .retrieve()
		              .bodyToFlux(Gamer.class);
		return flux;
	}

	@Override
	public Mono<Gamer> getGamerById(Integer gamerId) {
		// TODO Auto-generated method stub
		Mono<Gamer> mono = client
				.get()
				.uri("/gamer-api/find/{id}", gamerId)
	            .retrieve()
	            .bodyToMono(Gamer.class);
		return mono;
	}

	@Override
	public Mono<Void> deleteGamerByIdWithOutMSg(Integer gamerId) {
		// TODO Auto-generated method stub
		Mono<Void> monoVoid = client
				.delete()
	            .uri("/gamer-api/delete?id="+ gamerId)
	            .retrieve()
	            .bodyToMono(Void.class);
		return monoVoid;
	}
	@Override
	public Mono<String> deleteGamerByIdWithOutMSG(Integer gamerId) {
		// TODO Auto-generated method stub
		Mono<String> monoVoid = client
				.delete()
	            .uri("/gamer-api/delete?id="+ gamerId)
	            .retrieve()
	            .bodyToMono(String.class);
		return monoVoid;
	}

	@Override
	public Mono<String> deleteGamerByIdWithMsg(Integer gamerId) {
		// TODO Auto-generated method stub
		Mono<String> monoMsg = client
				.delete()
				.uri("gamer-api/objdelete",gamerId)
				.retrieve()
				.bodyToMono(String.class);
		return monoMsg;
	}

	@Override
	public Mono<String> updateGamerDetails(Gamer gamer) {
		// TODO Auto-generated method stub
	    Mono<String> mono = client.put()
	            .uri("/gamer-api/update/{id}", gamer.getGamerId())
	            .bodyValue(gamer)
	            .retrieve()
	            .bodyToMono(String.class);
		return mono;
	}

	@Override
	public Mono<String> deleteGamer(Gamer gamer) {
		// TODO Auto-generated method stub
		Mono<String> monoMsg = client
				.method(HttpMethod.DELETE) // Use method explicitly to allow body
	            .uri("/gamer-api/objdelete")
	            .bodyValue(gamer)
	            .retrieve()
	            .bodyToMono(String.class);
		return monoMsg;
	}

	
}
