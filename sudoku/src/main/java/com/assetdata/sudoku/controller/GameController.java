package com.assetdata.sudoku.controller;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.assetdata.sudoku.bean.Griglia;
import com.assetdata.sudoku.service.GameGeneratorService;

@RestController
public class GameController {

	@Resource(name="generatorService")
	private GameGeneratorService gameService;

	
	/*
	 * Definisce il servizio che genera una nuova griglia
	 */	
	  @RequestMapping(method = RequestMethod.GET, 
	  					produces = MediaType.APPLICATION_JSON_VALUE,
	  					value="/game")
	    public Griglia loadNewGame() {
		  
	        return gameService.generateNewGame();
	        
	    }
}
