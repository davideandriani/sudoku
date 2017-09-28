package com.assetdata.sudoku.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.assetdata.sudoku.controller.GameController;
import com.assetdata.sudoku.controller.SudokuConfigController;

@Configuration
@ComponentScan("com.assetdata")
@Import({SudokuConfigController.class, GameController.class})
@EnableAutoConfiguration
public class Application {
	
	
	
 public static void main(String[] args) {
  SpringApplication.run(Application.class, args);
 }
 
}
