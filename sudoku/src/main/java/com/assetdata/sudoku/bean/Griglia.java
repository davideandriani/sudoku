package com.assetdata.sudoku.bean;

public class Griglia {

	private Cella[][] celle = new Cella[9][9];

	public Cella[][] getCelle() {
		return celle;
	}

	public void setCelle(Cella[][] celle) {
		this.celle = celle;
	}
	
	public int getValoreCella(int row, int col) {
		return celle[row][col].getValore();
	}
	public Cella getCella(int row, int col) {
		return celle[row][col];
	}
	public Cella addCella(Cella cella, int row, int col) {
		return celle[row][col] = cella;
	}
	public Cella removeCella(int row, int col) {
		return celle[row][col] = null;
	}
	public void stampaGriglia() {
		for (int i = 0; i < 9; i++) {
			if (i%3 == 0) { 
				System.out.println("-------------------------------------------");
			}
			for (int j = 0; j < 9; j++) {
				String val = "";
				if (j%3 == 0) {
					val += "| ";
				}
				
				String numero = celle[i][j] != null ? String.valueOf(celle[i][j].getValore()) : "-";
				if ( celle[i][j] != null && !celle[i][j].isEmpty() ) {
					val += "["+numero+"]";
				} else {
					val += " "+numero+" ";
				}
				
				System.out.print(val +" ");
			}
			System.out.println("|");
		}
		System.out.println("-------------------------------------------");
	}
	public Cella[] getRigaMatrice(int row) {
		return celle[row];
	}
	public void setRigaMatrice(Cella[] rigaMatrice, int row) {
		celle[row] = rigaMatrice;
	}
	public void cleanGriglia() {
		celle = new Cella[9][9];
	}
	public void pulisciCella(int riga, int colonna) {
		this.celle[riga][colonna] = new Cella(riga, colonna);
	}
	
}
