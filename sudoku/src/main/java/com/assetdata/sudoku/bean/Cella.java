package com.assetdata.sudoku.bean;

public class Cella {

	private Integer valore;
	private Integer valoreVisualizzato;
	private boolean corretto;
	private boolean empty;
	private boolean pregenerato;
	private int riga;
	private int colonna;
	private int blocco;
	
	public Cella(int riga, int colonna) {
		this.riga=riga;
		this.colonna=colonna;
	}
	
	public Cella(int riga, int colonna, Integer valoreVisualizzato) {
		this.riga=riga;
		this.colonna=colonna;
		this.valoreVisualizzato=valoreVisualizzato;
	}
	
	public Cella(int riga, int colonna, int blocco, Integer valoreVisualizzato) {
		this.riga=riga;
		this.colonna=colonna;
		this.blocco=blocco;
		this.valoreVisualizzato=valoreVisualizzato;
	}
	
	public int getValore() {
		return valore;
	}
	public void setValore(int valore) {
		this.valore = valore;
	}
	public boolean isCorretto() {
		return corretto;
	}
	public void setCorretto(boolean corretto) {
		this.corretto = corretto;
	}
	public boolean isEmpty() {
		return empty;
	}
	public void setEmpty(boolean empty) {
		this.empty = empty;
	}
	public int getRiga() {
		return riga;
	}
	public void setRiga(int riga) {
		this.riga = riga;
	}
	public int getColonna() {
		return colonna;
	}
	public void setColonna(int colonna) {
		this.colonna = colonna;
	}
	public int getValoreVisualizzato() {
		return valoreVisualizzato;
	}
	public void setValoreVisualizzato(int valoreVisualizzato) {
		this.valoreVisualizzato = valoreVisualizzato;
	}

	public boolean isPregenerato() {
		return pregenerato;
	}

	public int getBlocco() {
		return blocco;
	}

	public void setBlocco(int blocco) {
		this.blocco = blocco;
	}

	public void setPregenerato(boolean pregenerato) {
		this.pregenerato = pregenerato;
	}

	public void setValore(Integer valore) {
		this.valore = valore;
	}

	public void setValoreVisualizzato(Integer valoreVisualizzato) {
		this.valoreVisualizzato = valoreVisualizzato;
	}
	
	
	
}
