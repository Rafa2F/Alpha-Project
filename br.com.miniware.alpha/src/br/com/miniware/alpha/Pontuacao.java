package br.com.miniware.alpha;

public class Pontuacao {
	
	private int pontuacao;
	
	public Pontuacao () 
	{
		pontuacao = 0;
	}
	
	
	public int getPontuacao() {
		
		return pontuacao;
	}
	
	

	public void adicionaPontuacao(int i) 
	{
		this.pontuacao = pontuacao + i;
		
	}
	
	public void diminuePontuacao(int i) 
	{
		this.pontuacao = pontuacao - i;
		
	}
	
	public void resetPontuacao () {
		
		pontuacao = 0;
		
	}
	
	

}
