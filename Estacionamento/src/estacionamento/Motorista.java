package estacionamento;
import java.util.*;
public class Motorista {
	private String nome;
	private int idade;
	private boolean habilitado;
	private int pontos;
	
	public Motorista(String nome,int idade,boolean habilitado) {
		this.nome = nome;
		this.idade = idade;
		this.habilitado = habilitado;
	}
	//Getters e Setters	
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public boolean getHabilitado() {
		return habilitado;
	}
	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return this.getNome();
	}
	
	
	
	
}//Fim da classe
