package com.siva.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Component
@Table
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class Gamer {

	@Id
	private Integer gamerId;
	@NonNull
	
	private String gamerName;
	@NonNull
	
	private String gamerLoc;
	@NonNull
	private Long gamerPhno;
	@NonNull
	
	private String gender;
	@NonNull
	
	private String gameType;

	
	
}
