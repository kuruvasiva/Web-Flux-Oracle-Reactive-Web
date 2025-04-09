package com.siva.webrepository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.siva.model.Gamer;
@Repository
public interface IGamerWebFluxReactiveRepo extends R2dbcRepository<Gamer,Integer> {

}
