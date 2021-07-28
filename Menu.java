package br.ucsal;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) { // Método principal
		menu(); // Chama o método "menu()" para exibir o menu no console e a escolha do jogo.
	}

	public static void menu() { // Método onde está o menu dos jogos que será exibido em console.
		Scanner in = new Scanner(System.in);
		System.out.println("Bem-vindo aos Jogos de LPA feitos em Java!\n"
				+ "Para escolher um jogo, digite o número correspondente:\n1 - Jogo da Forca\n"
				+ "2 - Batalha Naval\n3 - Jogo da Velha\n4 - Sair e encerrar o código");
		int escolha = in.nextInt();
		jogos(escolha); // Chama o método "jogos()" inserindo o parâmetro de escolha de jogo que o usuário digitou.
	}

	public static void jogos(int ind) {         // Método para chamar os métodos de execução das classes dos jogos, sendo chamada a que o usuário escolheu através do switch case.
		JogoDaForca jogoF = new JogoDaForca();
		BatalhaNaval jogoB = new BatalhaNaval();// Aqui declaro as variáveis para receber as classe dos jogos.
		JogoDaVelha jogoV = new JogoDaVelha();
		switch (ind) {                          // Switch case para decidir qual jogo executar a partir do valor digitado pelo usuário.
		case 1:
			jogoF.start();
			break;
		case 2:
			jogoB.start();
			break;
		case 3:
			jogoV.start();
			break;
		case 4:
			System.out.println("Encerrado, obrigado por jogar! :D\n\n\n\t    §---< Desenvolvedores"
					+ " >---§\n\n     §   Claubson Santos // @oninho_s       §\n     §   Enzo Gama       // @enzox7         §\n"
					+ "     §   Iago Roque      // @iagorockque    §\n     §   Kevin Vasques   // @kevinvasques_  §"
					+ "\n     §   Lucas Emanuel   // @elucasouza     §\n\n §-< https://github.com/iagoroque/Jogos-em-Java >-§");
			break;
		default:
			System.out.println("Encerrado.\n\n\n\t    §---< Desenvolvedores"
					+ " >---§\n\n     §   Claubson Santos // @oninho_s       §\n     §   Enzo Gama       // @enzox7         §\n"
					+ "     §   Iago Roque      // @iagorockque    §\n     §   Kevin Vasques   // @kevinvasques_  §"
					+ "\n     §   Lucas Emanuel   // @elucasouza     §\n\n §-< https://github.com/iagoroque/Jogos-em-Java >-§");
			break;
		}
	}
}