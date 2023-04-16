package estacionamento;

/*Objetivo desse sistema é auxiliar na gestão de um estacionamento. Esse estacionamento é formato por um número limitado de vagas, assim, as regras são:

• O número de vagas do estacionamento são de dez carros. • Para cada carro que entra no sistema é necessário informar a sua placa, cor além das informações do motorista. • Para entrar no estacionamento, é necessário que exista um motorista, ou seja, nada de carro autônomo. • O motorista precisa ter idade suficiente para dirigir e possuir uma habilitação. • A habilitação não deverá está suspensa, ou seja, a pontuação da carteira de motorista não deverá ser superior a vinte pontos. • O estacionamento não deverá comportar o número superior de vagas. • Caso o estacionamento esteja lotado:

Chegue mais um novo carro, o primeiro que estacionou deverá sair
Caso o motorista do primeiro carro estacionado tenha uma idade superior a 55 anos, será escolhido o próximo motorista abaixo dos 55 anos.
Caso todos os motoristas, dentro do estacionamento, tenham mais de 55 anos e chegue um motorista, ele não conseguirá estacionar.*/

import java.util.*;

public class Estacionamento{
	List<Carro> carrosEstacionados = new ArrayList<>(10);
	private int vagasDisponiveis = 10;
	
	//Metodo principal para estacionar os carros
	public void estacionar(Carro carro) {
		if(validarCarro(carro) == true) {
			if(vagasDisponiveis>0) {
				System.out.println("Carro Estacionado");
				carrosEstacionados.add(carro);
				vagasDisponiveis --;
			}else {
				if(autorizaRemover(carro) == true) {
					System.out.println("Removendo carro");
					carrosEstacionados.remove(carro);
					vagasDisponiveis++;
				}else {
					System.out.println("Estacionamento cheio");
				}
			}
		}else {
			System.out.println("Carro invalido");
		}
	}
	
	//Metodo para ver se o carro e valido para entrar no sistema
	public boolean validarCarro(Carro carro) {
		if(carro.getCor() == null || carro.getPlaca() == null || carro.getMotorista().getHabilitado() == false || carro.getMotorista().getIdade() < 18 || carro.getMotorista().getNome() == null || carro.getMotorista().getPontos()>20) {
			System.out.println("Situaçao irregular,regularize-se");
			return false;
		}else {
			return true;
		}
	}
	
	//Metodo para ver se pode remover ou nao o carro
	
	public boolean autorizaRemover(Carro carro) {
		Iterator<Carro> iterator =  carrosEstacionados.iterator();
		while(iterator.hasNext()) {
			Carro next = iterator.next();
			if(next.getMotorista().getIdade()<55) {
				return true;
			}
		}
		return false;
	}
	
	
	@Override
	public String toString() {
		return "[carrosEstacionados=" + carrosEstacionados + "]";
	}

	public int getVagasDisponiveis() {
		return vagasDisponiveis;
	}

	public void setVagasDisponiveis(int vagasDisponiveis) {
		this.vagasDisponiveis = vagasDisponiveis;
	}
	
	
	
}//Fim da classe
