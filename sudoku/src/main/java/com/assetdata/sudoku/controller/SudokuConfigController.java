package com.assetdata.sudoku.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/*
 * Mappa ed inoltra l'url della root alla pagina index.html
 */
@Controller
public class SudokuConfigController {

 @RequestMapping("/")
 public String home() {
  return "redirect:/index.html";
 }
 
}
