package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.NivelTrabalhador;

public class Trabalhador {
	
	private String nome;
	private NivelTrabalhador nivel;
	private Double salarioBase;	
	private Departamento departamento;
	//Quando se tem uma composi??o tem muitos(no caso abaixo uma lista) n?o ? inclu?do no construtor do m?todo, simplesmente inicia a lista vazia
	private List<Contrato> contratos = new ArrayList<>();
	
	
	public Trabalhador() {
		
	}

	public Trabalhador(String nome, NivelTrabalhador nivel, Double salarioBase, Departamento departamento) {
		this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}
	
	public void adicionarContrato(Contrato contrato) {
		contratos.add(contrato);
	}
	
	public void removerContrato(Contrato contrato) {
		contratos.remove(contrato);
	}
	
	public double renda(int ano, int mes) {
		double soma = salarioBase;
		Calendar cal = Calendar.getInstance();
		for (Contrato c : contratos) {
			//para cada contrato c, eu vou setar nesse calendario a data do contrato c 
			cal.setTime(c.getData());
			int c_ano = cal.get(Calendar.YEAR); 
			int c_mes = 1 + cal.get(Calendar.MONTH);
			
			if (ano == c_ano && mes == c_mes) {
				soma += c.valorTotal();	
			}
		}
		return soma;
	}

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public NivelTrabalhador getNivel() {
		return nivel;
	}


	public void setNivel(NivelTrabalhador nivel) {
		this.nivel = nivel;
	}


	public Double getSalarioBase() {
		return salarioBase;
	}


	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}


	public Departamento getDepartamento() {
		return departamento;
	}


	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}


	public List<Contrato> getContratos() {
		return contratos;
	}
}
