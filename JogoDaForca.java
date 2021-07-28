package br.ucsal;

import java.util.Random;  // Biblioteca do Random, usada para escolher uma palavra aleatoriamente dentro da String[].
import java.util.Scanner; // Biblioteca do Scanner, usada para pegar e ler dados inseridos no console.

public class JogoDaForca {

	public static void main(String[] args) { // Método principal
		start(); // Caso essa classe seja executada sem o uso da classe de "Menu", ela poderá chamar o método "executar" normalmente.
	}
	
	public static String desenhoForca(int chances) { // Método com o desenho em console da forca.
		String[] forca = { "  ______\n |      |\n |\n |\n |\n_|_\n", "  ______\n |      |\n |      O\n |\n |\n_|_\n",
				"  ______\n |      |\n |      O\n |      |\n |\n_|_\n",
				"  ______\n |      |\n |      O\n |     /|\n |\n_|_\n",
				"  ______\n |      |\n |      O\n |     /|\\\n |\n_|_\n",
				"  ______\n |      |\n |      O\n |     /|\\\n |     /\n_|_\n",
				"  ______\n |      |\n |      O\n |     /|\\\n |     / \\\n_|_\n" };
		String desenhoForca = forca[chances];
		return desenhoForca;
	}
	
	public static void seGanhou(int chances, String pSorteada) { // Método que exibe a mensagem se a pessoa ganhou ou não a partir da quantidade de chances que restou.
		if (chances > 0) { // Se o usuário ainda estiver com alguma chance sobrando após encerrar o jogo, significa que ela finalizou o jogo e ganhou ele.
			System.out.println("\n\n\t§---<| Jogo finalizado, você ganhou, parabéns! |>---§\n");
		} else { // Se ele não tiver nenhuma chance sobrando, significa que ele finalizou o jogo por causa que ele acabou com todas as suas chances e perdeu o jogo.
			System.out.println("\n\n\t§---<| Jogo finalizado, você foi enforcado! A palavra era: " + pSorteada + " |>---§\n");
		}
	}

	public static void start() { // Método onde realmente está todo o jogo, e esse será o método chamado pela classe "Menu".
		
		// Random para escolher uma palavra aleatoriamente dentro do array, e a abertura do Scanner.
		Random random = new Random();
		Scanner in = new Scanner(System.in);
		
		// String[] onde ficam armazenada as palavras da forca, todas em letra maiúscula e sem acentos ou caracteres especiais.
		String[] palavras = { "ANIMAL", "FRUTA", "CIDADE", "PALAVRA", "UNIVERSIDADE", "JOGO", "FORCA", "BIBLIOTECA",
				"ECLIPSE", "JAVA", "INTERNET", "COMPUTADOR", "ALGORITMO", "CONSTANTE", "RECORDE", "TEMPO", "BRASIL",
				"BAHIA", "SALVADOR", "PROCESSADOR", "ATIVIDADE", "REDE", "MUNDO", "PLANETA", "SISTEMA", "BATALHA",
				"GUERRA", "PAZ", "AMOR", "INFINITO", "ARQUIVO", "CLASSE", "UNIDADE", "CAPITAL", "DINHEIRO", "DATA",
				"VIDA", "DIA", "HORA", "MINUTO", "SEGUNDO", "ANO", "SEMANA", "MULHER", "HOMEM", "MAGIA", "TECNOLOGIA",
				"MAR", "OCEANO", "TERRA", "ARQUITETURA", "ENGENHARIA", "SOFTWARE", "ENERGIA", "MASSA", "SINGULARIDADE",
				"ENTROPIA", "VELOCIDADE", "VAZIO", "LINHA", "COLUNA", "PESQUISAR", "OBRIGADO", "DESCULPA", "NATUREZA",
				"PARADOXO", "CARACTERE", "ESPECIAL", "LETRA", "ALFABETO", "SELVA", "FLORESTA", "BIOMA", "CARVALHO",
				"ORTODOXO", "FERRO", "TRABALHO", "PIZZA", "SORVETE", "BIGORNA", "NEVE", "MONTANHA", "ASTRO", "SOL",
				"LUA", "CARBONO", "ALECRIM", "TELA", "TECLADO", "CELULAR", "AREIA", "VIDRO", "SOM", "LUZ", "MAGNETISMO",
				"GRAVIDADE", "BURACO", "PLASMA", "REAL", "REALIDADE", "BORDA", "PLANO", "MAPA", "CHUVA", "RAIO",
				"NUVEM", "FRIO", "CALOR", "QUENTE", "CLARO", "ESCURO", "GELADO", "FERVENDO", "DESENHO", "CORPO",
				"GASOSO", "CACHORRO", "GATO", "VOAR", "TEMPESTADE", "MADEIRA", "PEDRA", "INTERFACE", "NAVEGADOR",
				"PLACA" };

		int qPalavras = palavras.length; // Var tipo int para receber a quantidade de palavras que existem dentro de "palavras[]"
		int indSorteado = random.nextInt(qPalavras); // O random lê o int "qPalavras" e escolhe um número aleatoriamente, que depois é recebida na var "indSorteado".
		String pSorteada = palavras[indSorteado]; // Com um número escolhido aleatoriamente pelo random dentro da quantidade de palavras existentes, a var "pSorteada"
		                                          //vai receber a palavra que está no índice do array que o random escolheu aleatoriamente.

		char[] acertos = new char[pSorteada.length()]; // A var "acertos[]" é criada com o tamanho definido pela quantidade de caracteres que tem na palavra sorteada.
		for (int i = 0; i < acertos.length; i++) { // Esse for é para atribuir a todos os caracteres do "acertos[]" o valor 0, pois depois
			acertos[i] = 0;                        // esse parâmetro será utilizado ou para mostrar "_" ou a letra que a pessoa acertou"
		}
		
		String lUtilizadas = ""; // Var que vai guardar as letras utilizadas.
		char letra; // Var que vai receber as letras digitadas pelo usuário.
		boolean ganhou = false; // Var que vai definir se o jogo irá continuar no do/while ou não, pois verifica se o jogador ganhou ou perdeu.
		int chances = 6; // Quantidade de erros que a pessoa pode cometer, e é equivalente a quantidade de partes desenhadas do boneco da forca.

		//Aqui é onde começa a ser mostrado o jogo no console.
		System.out.println("\n\tA _ C _ E _ G _ I _ K _ M _\n\t§---<| JOGO DA FORCA |>---§\n\t_ B _ D _ F _ H _ J _ L _ N\n");
		System.out.println("*Uma entre " + qPalavras + " palavras diferentes foi escolhida para você, boa sorte!*");
		System.out.println(desenhoForca(0)); // Mostra a forca pela primeira vez quando executado.
		for (int i = 0; i < pSorteada.length(); i++) { // Mostra as "_" que serão substituídas pelos caracteres da palavra.
			System.out.print("_ ");
		}
		
		do { // É a partir desse do/while que o jogo se repete
			System.out.print("\n\nLetras utilizadas:" + lUtilizadas + "\nDigite uma letra: "); // Mostra as letras utilizadas e pede para digitar uma letra.
			letra = in.next().toUpperCase().charAt(0); // Recebe a letra digitada com o uso do scanner, transforma ela em maiúscula caso não esteja com o uso do
			// .toUpperCase(), e o 0 no charAt() para pegar a primeira letra digitada.
			lUtilizadas += " " + letra; // Vai juntando as letras digitas para mostrar para o usuário.

			boolean perdeChance = true; // Declaro perdeVida como sendo verdadeira.
			for (int i = 0; i < pSorteada.length(); i++) { // Verifica se a letra digitada é compatível com algum caractere da palavra sorteada.
				if (letra == pSorteada.charAt(i)) { // Se sim, ele altera a posição daquela letra no array acertos[] de 0 para 1 para posteriormente ser utilizado.
					acertos[i] = 1;
					perdeChance = false; // E ainda altera perdeChance para false para indicar naquela jogada que o usuário não perdeu uma chance.
				}
			}
			if (perdeChance) { // Se perdeChance for verdadeira, perco uma chance, se não, continuo com a mesma quantidade de chances.
				chances--;
			}
			
			switch (chances) { // A partir da quantidade de chances que a pessoa tem, é determinado o desenho da forca que será mostrado.
			case 6:
				System.out.println(desenhoForca(0));
				break;
			case 5:
				System.out.println(desenhoForca(1));
				break;
			case 4:
				System.out.println(desenhoForca(2));
				break;
			case 3:
				System.out.println(desenhoForca(3));
				break;
			case 2:
				System.out.println(desenhoForca(4));
				break;
			case 1:
				System.out.println(desenhoForca(5));
				break;
			case 0:
				System.out.println(desenhoForca(6));
				break;
			default:
				break;
			}
			
			ganhou = true; // ganhou é definida como verdadeira, sendo assim, o do/while já pode encerrar.
			for (int i = 0; i < pSorteada.length(); i++) { // for que verifica se "acertos[]" continuar com 0, ele irá mostrar "_", mas se a pessoa acertar
				if (acertos[i] == 0) {                     // a letra, ele irá mostrar a letra digitada no lugar correto.
					System.out.print("_ ");
					ganhou = false;                        // Aqui o do while é definida como false para que no do/while reconhecer como ganhou verdadeira,
				} else {                                   // pois no do/while, ele verificar o valor oposto do valor booleano por causa do "!".
					System.out.print(pSorteada.charAt(i) + " "); // Mas se não existir mais nenhum vetor sendo 0 em "acertos[]", ele vai mostrar a letra correspondente
				}                                                // aquela posição e não vai alterar ganhou, deixando com o valor true
			}
			
		} while ((!ganhou) && (chances > 0)); // Se o valor de ganhou for true e a quantidade de chances for maior que 0, o while se encerra, encerrando assim o jogo.
		// Ou basicamente se ele não ganhou e ainda tem chances, o jogo se repete.
		
		seGanhou(chances, pSorteada); // O método que confere se a pessoa ganhou ou perdeu pela quantidade de chances é chamado.

		// Aqui aparece uma escolha no console para o usuário definir o que deseja após ter terminado o jogo.
		System.out.println("*Agora digite o número referente a sua escolha:\n0 - Jogar novamente\n1 - Voltar para o menu\n2 - Encerrar");
		int escolhafinal = in.nextInt();
		Menu menu = new Menu(); // Defino o método menu() da Classe Menu para poder chamá-lo no switch case.
		switch (escolhafinal) {
		case 0:
			start(); // Chama o método do jogo da Forca novamente para ser executado.
			break;
		case 1:
			System.out.println("\n\n");
			menu.menu(); // Chama o método do menu() para aparecer o menu.
			break;
		default: // Encerra o jogo por aqui mesmo, agradecendo-o por ter jogado e mostrando os créditos.
			System.out.println("Encerrado, obrigado por jogar! :D\n\n\n\t    §---< Desenvolvedores"
					+ " >---§\n\n     §   Claubson Santos // @oninho_s       §\n     §   Enzo Gama       // @enzox7         §\n"
					+ "     §   Iago Roque      // @iagorockque    §\n     §   Kevin Vasques   // @kevinvasques_  §"
					+ "\n     §   Lucas Emanuel   // @elucasouza     §\n\n §-< https://github.com/iagoroque/Jogos-em-Java >-§");
			break;
		}
	}

}