package com.siva.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.siva.model.Gamer;
import com.siva.service.IGamerServiceMnmg;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//@Component

public class ReactiveRDBMSRunner implements CommandLineRunner {

	@Autowired
	private IGamerServiceMnmg gamerService;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		/*	Gamer gamer = new Gamer("Rowdy", "Hyderabad",8886838695l,"Male","Free Fire");
			Gamer gamer1 = new Gamer("Shiva","Maharastra",9898981234l,"Male","Free Fire");
			Gamer gamer2 = new Gamer("Rowdy", "Hyderabad",8886838695l,"Male","Free Fire");
			Gamer gamer3 = new Gamer("Rowdy", "Hyderabad",8886838695l,"Male","Free Fire");
			
			List<Gamer> listOfGamers = List.of(gamer,gamer1,gamer2,gamer3);
			
			Flux<Gamer> flux = gamerService.ListOfSaveGamer(listOfGamers);
			flux.doOnNext(System.out::println).blockLast();
		*/
		  
		
		  Gamer gamer = new Gamer("Rowdy", "Hyderabad",8886838695l,"Male","Free Fire");
		
		   Mono<String> monoGamer = gamerService.saveGamer(gamer);
		
		 monoGamer.subscribe(System.out::println);
		
		/*Flux<Gamer> flux = gamerService.getAllGamers();
		System.out.println(" List of Gamres ");
		  flux.doOnNext(System.out::println).blockLast();
		*/
	
		
		/*	Mono<Void> deleteVoid = gamerService.deleteGamerByIdWithOutMSg(6);
			deleteVoid.subscribe(t ->System.out.println(t+" Delete Sucessfully WithO ut MSg")); 
			*/
		/*
		Mono<String> String = gamerService.deleteGamerByIdWithMsg(8);
		
		String.subscribe(System.out::println);
		*/
		//System.out.println(" Run method is executed "+gamer);
		//❤️❤️❤️ ❣️💔 😍🥰😘 ❤️‍🔥❤️‍🔥🤍🤍
		 String emoji= "🤍";
		System.out.println("Emoji Lengt:: "+emoji.length());
		Gamer gamer1 = new Gamer(12,"❤️RowdyBaby❤", "Kurnool🥰😘",8184914791l,"Fe-Male","Free🔥‍🔥Fire");
			
		Mono<String> updateGamer = gamerService.updateGamerDetails(gamer1);
		updateGamer.subscribe(System.out::println);
		
	}
	
}


