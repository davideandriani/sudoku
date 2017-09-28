package com.assetdata.sudoku.game.bl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.assetdata.sudoku.bean.Cella;
import com.assetdata.sudoku.bean.Griglia;

@Component("generator")
public class SudokuUtility {

	public Griglia griglia = new Griglia();
	private final static int NUM_CELLE_PIENE = 34;

	
	/**
	 * metodo utilizzato per la generazione degli indici da rimuove dal'array monodimensionale
	 * contenente tutti i valori della griglia generata
	 * 
	 * @param dimensioneGriglia
	 * @param numCelleDaRimuovere
	 * @return
	 */
	private List<Integer> getIndiciCelleDaRimuovere(int dimensioneGriglia, int numCelleDaRimuovere){
		List<Integer> indiciCelleDaRimuovere = new ArrayList<Integer>(numCelleDaRimuovere);
		Random random = new Random();
		for (int i = 0; i < numCelleDaRimuovere; i++) {
			int indiceDaRimuovere = random.nextInt(dimensioneGriglia);
			// System.out.println(indiceDaRimuovere);
			if ( indiciCelleDaRimuovere.contains(indiceDaRimuovere)) {
				i--;
				continue;
			}
			indiciCelleDaRimuovere.add(indiceDaRimuovere);				
		}
		return indiciCelleDaRimuovere;
	}

	/**
	 * generazione griglia da completare, inserendo per ciascuna cella la soluzione
	 * 
	 * @return Griglia
	 */
	public Griglia generaGriglia() {
		try {
			int dimensioneGriglia = SudokuGenerator.DIMENSIONE_GRIGLIA*SudokuGenerator.DIMENSIONE_GRIGLIA;
			int numCelleDaRimuovere = dimensioneGriglia-NUM_CELLE_PIENE;
			int colonna = 0;
			int riga = 0;
			
			// generazione griglia completa			
			int[] valori = SudokuGenerator.getInstance().generaSudoku();
			
			// generazione indici da rimuovere dalla griglia completa
			List<Integer> indiciCelleDaRimuovere = getIndiciCelleDaRimuovere(dimensioneGriglia, numCelleDaRimuovere);

			// generazione griglia da completare
			for (int i = 0; i < dimensioneGriglia; i++) {
				colonna = i%SudokuGenerator.DIMENSIONE_GRIGLIA;
				riga = (int) (i/(double)SudokuGenerator.DIMENSIONE_GRIGLIA);
				Integer valore = 0;
				// Il daSettare identifica la cella che risulterà  vuota
				boolean daSettare = true;
				if ( !indiciCelleDaRimuovere.contains(i) ) {
					valore = valori[i+1];
					daSettare = false;
				}
				Cella cella = new Cella(riga, colonna, valore);
				cella.setValore(valori[i+1]);
				if(!daSettare) {
					//Imposto i valori da visualizzare e segno la cella come pregenrata per impedire lato frontend la modifica del campo in questione
					cella.setValoreVisualizzato(valori[i+1]);
					cella.setPregenerato(true);
				}
				cella.setBlocco(SudokuUtility.defineBlocco(riga, colonna));
				griglia.addCella(cella, riga, colonna);

			}


		} catch (Exception e) { 
			e.printStackTrace();
		}
		return griglia;
	}

	
	public Griglia getGriglia() {
		return griglia;
	}

	public void setGriglia(Griglia griglia) {
		this.griglia = griglia;
	}
	/*
	 * 
	 * Definisce i vari blocchi
	 * @param riga indice della riga
	 * @param colonna indice della colonna
	 * 
	 * @return indice del blocco
	 */
	public static int defineBlocco(int riga, int colonna) {
		int bloccoBaseLength= 3;
		if(riga<bloccoBaseLength && colonna<bloccoBaseLength) {
			return 1;
		}else if(riga<bloccoBaseLength && colonna>=bloccoBaseLength && colonna<bloccoBaseLength*2) {
			return 2;
		}else if(riga<bloccoBaseLength && colonna>=bloccoBaseLength*2 && colonna<bloccoBaseLength*3) {
			return 3;
		}
		else if(riga>=bloccoBaseLength && riga<bloccoBaseLength*2 && colonna<bloccoBaseLength) {
			return 4;
		}else if(riga>=bloccoBaseLength && riga<bloccoBaseLength*2 && colonna>=bloccoBaseLength && colonna<bloccoBaseLength*2) {
			return 5;
		}else if(riga>=bloccoBaseLength && riga<bloccoBaseLength*2  && colonna>=bloccoBaseLength*2 && colonna<bloccoBaseLength*3) {
			return 6;
		}
		else if(riga>=bloccoBaseLength*2 && riga<bloccoBaseLength*3 && colonna<bloccoBaseLength) {
			return 7;
		}else if(riga>=bloccoBaseLength*2 && riga<bloccoBaseLength*3 && colonna>=bloccoBaseLength && colonna<bloccoBaseLength*2) {
			return 8;
		}else if(riga>=bloccoBaseLength*2 && riga<bloccoBaseLength*3  && colonna>=bloccoBaseLength*2 && colonna<bloccoBaseLength*3) {
			return 9;
		}else return -1;
	}
}
