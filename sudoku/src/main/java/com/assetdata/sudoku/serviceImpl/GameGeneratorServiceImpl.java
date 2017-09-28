package com.assetdata.sudoku.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.assetdata.sudoku.bean.Griglia;
import com.assetdata.sudoku.game.bl.SudokuUtility;
import com.assetdata.sudoku.service.GameGeneratorService;

@Component("generatorService")
public class GameGeneratorServiceImpl implements GameGeneratorService {

	@Resource(name="generator")
	private SudokuUtility gameMaster;
	
	@Override
	public Griglia generateNewGame() {
		return gameMaster.generaGriglia();
	}

}
