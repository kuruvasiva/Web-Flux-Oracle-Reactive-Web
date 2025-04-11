package com.siva.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gamer {
	
	private Integer gamerId;
	
	private String gamerName;
	
	private String gamerLoc;
	
	private Long gamerPhno;
	
	private String gender;
	
	private String gameType;	
}
