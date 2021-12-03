package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Contrato;
import entities.Departamento;
import entities.Trabalhador;
import entities.enums.NivelTrabalhador;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner (System.in);
		Locale.setDefault(Locale.US);
		//Criado para manipularmos uma data
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		
		
		System.out.print("Entre com o nome do departamento: ");
		String nomeDepartamento = sc.nextLine();
		
		System.out.println("Entre com os dados do trabalhador: ");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Nível (JUNIOR, PLENO OU SENIOR): ");
		String nivel = sc.nextLine();
		System.out.print("Base salarial: ");
		double baseSalarial = sc.nextDouble();
		
		//Após acrescentar os dados, posso instanciar um trabalhador para receber os dados acima.
		//NivelTrabalhador.valueOf(nivel) = passou como string já que a variavel nivel é uma string
		//new Departamento(nomeDepartamento) = criou um instancia departamento para associar ao trabalhadaor.
		Trabalhador trabalhador = new Trabalhador(nome, NivelTrabalhador.valueOf(nivel), baseSalarial, new Departamento(nomeDepartamento));
		
		
		System.out.print("Quantos contratos possui esse trabalhador? ");
		int numContratos = sc.nextInt();
		
		for (int i = 1; i <= numContratos; i++) {
			System.out.println("Insira os dados do contrato nº" + i + ": ");
			System.out.print("Data (DD/MM/YYY): ");
			Date dataContrato = sdf.parse(sc.next());
			System.out.print("Valor por hora: ");
			double vlrHora = sc.nextDouble();
			System.out.print("Quantas horas: ");
			int horas = sc.nextInt();
			System.out.println();
			
			Contrato contrato = new Contrato(dataContrato, vlrHora, horas);
			trabalhador.adicionarContrato(contrato);			
		}
		
		System.out.println();
		System.out.println("Entre com o mês e ano para calcular o salário (MM/YYYY): ");
		String mesAno = sc.next();
		//pegou a variavel mesAno e converteu para um inteiro e armazenou nas variaveis mes e ano
		// o mesAno.substring(0, 2) é para cortar a string mesAno e pegar apenas os caracteres 0 a 2. Ex: 08/2021 = pegará o 08. Obs: tem que colocar um numero a mais, no caso não seria mesAno.substring(0, 1)
		int mes = Integer.parseInt(mesAno.substring(0, 2));
		int ano = Integer.parseInt(mesAno.substring(3));
		
		System.out.println("O nome do trabalhador é: " + trabalhador.getNome());
		System.out.println("Departamento: " + trabalhador.getDepartamento().getNome());
		System.out.println("Renda na data " + mesAno + " foi de: " + String.format("%.2f", trabalhador.renda(ano, mes)));
		
		sc.close();

	}

}
