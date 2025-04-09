package com.siva.service;

import java.util.List;

import com.siva.model.Gamer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IGamerServiceMnmg {

	public Mono<String> saveGamer(Gamer gamer);
	
	public Flux<String> ListOfSaveGamer(List<Gamer> listgamer);

	public Flux<Gamer> getAllGamers();
	
	public Mono<Gamer> getGamerById(Integer gmaerId);
	
	public Mono<Void> deleteGamerByIdWithOutMSg(Integer gamerId);
	
	public Mono<String>deleteGamerByIdWithMsg(Integer gamerId);
	
	public Mono<String> updateGamerDetails(Gamer gamer);
	
	public Mono<String> deleteGamer(Gamer gamer);
}
