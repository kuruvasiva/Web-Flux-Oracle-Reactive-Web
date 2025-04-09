package com.siva.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.siva.model.Gamer;
import com.siva.service.IGamerServiceMnmg;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/client-api")
public class Client_GamerRestController {

	@Autowired
	private IGamerServiceMnmg gamerService;
	
	@PostMapping("/save")
	public ResponseEntity<Mono<String>> saveGamer(@RequestBody Gamer gamer){
		//use service
      System.out.println("GamerRestController.saveGamer() Thread Name::"+Thread.currentThread().getName());
		Mono<String> saveGamer = gamerService.saveGamer(gamer);

	 return new ResponseEntity<Mono<String>>(saveGamer,HttpStatus.CREATED);		
	}
	
	@GetMapping("/all")
	public ResponseEntity<Flux<Gamer>>fetchAllGamers (){
		//use service
		System.out.println("GamerRestController.fetchAllGamers() ThreadName::  "+Thread.currentThread().getName() );
		Flux<Gamer> listOfGamers = gamerService.getAllGamers();
		
	 return new ResponseEntity<>(listOfGamers,HttpStatus.OK);		
	}
	
	@GetMapping("/find/{gamerId}")
	public ResponseEntity<Mono<Gamer>>fetchGamerFindById(@PathVariable Integer gamerId){
		//use service
		/*
		try {
			//Thread.sleep(50000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("GamerRestController.find by id catch Block"+Thread.currentThread().getName());
			e.printStackTrace();
		}*/
		     
		System.out.println("GamerRestController.fetchGamerFindById() ThreadName:: "+Thread.currentThread().getName() );
		Mono<Gamer> gamer = gamerService.getGamerById(gamerId);
		
	 return new ResponseEntity<>(gamer,HttpStatus.OK);		
	}
	
	@PutMapping("/update")
	public ResponseEntity<Mono<String>> UpdateGamer(@RequestBody Gamer gamer){
		//use service
		System.out.println("GamerRestController.UpdateGamer() ThreadName::"+Thread.currentThread().getName() );
		Mono<String> saveGamer = gamerService.updateGamerDetails(gamer);
		
	 return new ResponseEntity<Mono<String>>(saveGamer,HttpStatus.UPGRADE_REQUIRED);		
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Mono<String>>deleteGamerById( @RequestParam("id") Integer gamerId){
		//use service
		Mono<String> deleteGamerMsg = gamerService.deleteGamerByIdWithMsg(gamerId);
		System.out.println("GamerRestController.deleteGamerById() ThreadName::"+Thread.currentThread().getName() );
	 return new ResponseEntity<>(deleteGamerMsg,HttpStatus.OK);		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Mono<String>>deleteGamerById1( @PathVariable("id") Integer gamerId){
		//use service
		Mono<String> deleteGamerMsg = gamerService.deleteGamerByIdWithOutMSG(gamerId);
		System.out.println("GamerRestController.deleteGamerById() ThreadName::"+Thread.currentThread().getName() );
	 return new ResponseEntity<>(deleteGamerMsg,HttpStatus.OK);		
	}
	
	
	@DeleteMapping("/objdelete")
	public ResponseEntity<Mono<String>>deleteGamerById( @RequestBody Gamer gamer){
		//use service
		System.out.println("GamerRestController.deleteGamerById()ThreadName::"+Thread.currentThread().getName());
		Mono<String> deleteGamerMsg = gamerService.deleteGamer(gamer);
		
	 return new ResponseEntity<>(deleteGamerMsg,HttpStatus.OK);		
	}
	
	@PostMapping("/saveAll")
	public ResponseEntity<Flux<String>> listOfSaveGamer(@RequestBody List<Gamer> listOfgamers){
		//use service
		System.out.println("GamerRestController.listOfSaveGamer() ThreadName::"+Thread.currentThread().getName() );
		Flux<String> ListOfsaveGamer = gamerService.ListOfSaveGamer(listOfgamers);
		
	 return new ResponseEntity<>(ListOfsaveGamer,HttpStatus.CREATED);		
	}
	
	
}
