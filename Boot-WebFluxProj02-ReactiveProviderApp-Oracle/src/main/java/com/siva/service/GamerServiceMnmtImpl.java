package com.siva.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siva.model.Gamer;
import com.siva.webrepository.IGamerWebFluxReactiveRepo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class GamerServiceMnmtImpl implements IGamerServiceMnmg {

	@Autowired
	private IGamerWebFluxReactiveRepo gamerRepo;

	
     @Override
     public Mono<String> saveGamer(Gamer gamer) {
    	    return gamerRepo.save(gamer) // Saves and returns Mono<Gamer>
    	            .map(savedGamer -> "Gamer successfully inserted with ID: " + savedGamer.getGamerId()) // Transforms to Mono<String>
    	            .onErrorResume(e -> Mono.error(new RuntimeException("Failed to insert gamer"))); // Handles any error
    	}
	@Override
	public Flux<Gamer> getAllGamers() {
		// TODO Auto-generated method stub
		return gamerRepo.findAll().switchIfEmpty(Flux.empty());
	}

	@Override
	public Mono<Gamer> getGamerById(Integer gmaerId) {
		// TODO Auto-generated method stub
		return gamerRepo.findById(gmaerId);
	}

	@Override
	public Mono<Void> deleteGamerByIdWithOutMSg(Integer gamerId) {
		// TODO Auto-generated method stub
		return gamerRepo.findById(gamerId)
				.switchIfEmpty(Mono.error(new RuntimeException("Gamer Date not found for deletion")))
				.flatMap(gamger->gamerRepo.deleteById(gamerId))
				.then(); // whit out deletion message 
	}
	
		@Override
		public Mono<String> deleteGamerByIdWithMsg(Integer gamerId) {
		    return gamerRepo.findById(gamerId)
		            .switchIfEmpty(Mono.error(new RuntimeException("Gamer data not found for deletion")))
		            .flatMap(gamer->gamerRepo.deleteById(gamerId))
		            .then(Mono.just("Deletion completed in Database this Id  "+gamerId));
		}
	
		/*@Override
		public Mono<Gamer> updateGamerDetails(Gamer gamer) {
			// use repository
			System.out.println("GamerServiceMnmtImpl.updateGamerDetails()");
			Mono<Gamer> mono = gamerRepo.findById(gamer.getGamerId());
					
			mono.subscribe(System.out::println);
			
			return mono.flatMap(obj->{
				BeanUtils.copyProperties(gamer, obj);
				return gamerRepo.save(obj);
			})
					.onErrorResume(e->{
						return Mono.error(new RuntimeException("Gamer Object is did not found for updation"));
					});
		}*/
		@Override
		public Mono<String> updateGamerDetails(Gamer gamer) {
		    System.out.println("GamerServiceMnmtImpl.updateGamerDetails()");

		    return gamerRepo.findById(gamer.getGamerId()) // Find the gamer
		        .switchIfEmpty(Mono.error(new RuntimeException("Gamer object not found for update"))) // Error if not found
		        .flatMap(existingGamer -> {
		            BeanUtils.copyProperties(gamer, existingGamer); // Copy updated properties
		            return gamerRepo.save(existingGamer)
		                   .map(updateGa -> "Succesfully Update Gamer"+updateGa.getGamerId())	// map method String type 
		            		; // Save updated gamer
		        });
		}

	@Override
	public Flux<String> ListOfSaveGamer(List<Gamer> listgamer) {
		// TODO Auto-generated method stub
	//	return gamerRepo.saveAll(listgamer)  /return Flux<Gamer> list of gamers
		return gamerRepo.saveAll(listgamer) // here return Flux<String> with Id		
				.map(gamers->" List of Gamers"+gamers.getGamerId())
				.onErrorResume(e ->
				           Mono.error(new RuntimeException("Failed to insert list of gamers")));
	}

	@Override
	public Mono<String> deleteGamer(Gamer gamer) {
		// use repository
		return gamerRepo.findById(gamer.getGamerId())
				.switchIfEmpty(Mono.error(new RuntimeException ("Gamer details is not found for deletion")))
				.flatMap(deletGamer->gamerRepo.delete(gamer))
				.then(Mono.just("delete successfully delete "+gamer.getGamerId()));
	}

}
