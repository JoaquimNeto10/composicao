package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Clientes;
import entities.ItemPedido;
import entities.Pedido;
import entities.Produto;
import entities.enums.StatusPedido;


public class ExPedidos {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);		
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Entre com os dados do cliente:");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Data de nascimento (DD/MM/YYYY): ");
		Date niver = sdf.parse(sc.next());
		
		Clientes cliente = new Clientes(nome, email, niver);		
		
		System.out.println("\nEntre com os dados do pedido:");
		System.out.print("Status(AGUARDANDO_PAGAMENTO, PROCESSANDO, ENVIADO, ENTREGUE): ");
		StatusPedido status = StatusPedido.valueOf(sc.next());
		
		Pedido pedido = new Pedido(new Date(), status, cliente);
		
		System.out.print("Quantos itens tem o pedido: ");
		int qtdItens = sc.nextInt();
		for (int i = 1; i <= qtdItens; i++) {
			System.out.println("Insira os dados do item nº" + i + ": ");
			System.out.print("Nome do produto: ");
			sc.nextLine();
			String nomeProduto = sc.nextLine();
			
			System.out.print("Preço do produto: ");
			double precoProduto = sc.nextDouble();
			Produto produto = new Produto(nomeProduto, precoProduto);
			
			System.out.print("Quantidade: ");
			int qtd = sc.nextInt();
			
			ItemPedido itemPedido = new ItemPedido(qtd, precoProduto, produto);
			
			pedido.adcItem(itemPedido);			
		}
		
		System.out.println();
		System.out.println("Resumo do pedido:");
		System.out.println(pedido);
				
		sc.close();

	}

}
