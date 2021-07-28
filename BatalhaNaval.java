package br.ucsal;

import java.util.Random;
import java.util.Scanner;

public class BatalhaNaval {
    
    static final int VAZIO = 0;
    static final int NAVIO = 1;
    static final int ERROU_TIRO = 2;
    static final int ACERTOU_TIRO = 3;
    
    static final int POSICAO_X = 0;
    static final int POSICAO_Y = 1;
    
    
    static String nomeJogador1, nomeJogador2;
    static int tamanhoX, tamanhoY, quantidadeDeNavios, limiteMaximoDeNavios;
    static int tabuleiroJogador1[][], tabuleiroJogador2[][];
    static Scanner input = new Scanner(System.in);
    static int naviosJogador1, naviosJogador2;
    
    public static void main(String[] args) {
		start();
	}
    
    public static void start() {
    	System.out.println("\n\t~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\t§---<| BATALHA NAVAL |>---§\n\t~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        obterNomesDosJogadores();                                                  
        obterTamanhoDosTabuleiros();  
        calcularQuantidadeMaximaDeNaviosNoJogo();
        iniciandoOsTamanhosDosTabuleiros();
        obterQuantidadeDeNaviosNoJogo();
        instanciarContadoresDeNaviosDosJogadores();
        inserirOsNaviosNosTabuleirosDosJogadores();
        boolean jogoAtivo = true;
        do {
            exibirTabuleirosDosJogadores();  
            if (acaoDoJogador()) {
                if (naviosJogador2 <= 0) {
                    System.out.println("\n\t§---<| " + nomeJogador1 + " venceu o jogo! |>---§\n");
                    break;
                }
                // Verifico fim do jogo
                acaoDoComputador();
                if (naviosJogador1 <= 0) {
                    System.out.println("\n\t§---<| " + nomeJogador2 + " venceu o jogo! |>---§\n");
                    break;
                }
            }

        } while (jogoAtivo);
        exibirTabuleirosDosJogadores();
        System.out.println("\n*Agora digite o número referente a sua escolha:\n0 - Jogar novamente\n1 - Voltar para o menu\n2 - Encerrar");
		int escolhafinal = input.nextInt();
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
    
    public static void obterTamanhoDosTabuleiros() {
                tamanhoX = 10;
                tamanhoY = 10;
    }
    
    public static void obterNomesDosJogadores() {
        System.out.println("Digite o seu Nome: ");
        nomeJogador1 = input.next();
        nomeJogador2 = "PC";
    }
    
    public static void calcularQuantidadeMaximaDeNaviosNoJogo() {
        limiteMaximoDeNavios = 14;
    }
    
    public static void iniciandoOsTamanhosDosTabuleiros() {
        tabuleiroJogador1 = retornarNovoTabuleiroVazio();
        tabuleiroJogador2 = retornarNovoTabuleiroVazio();
    }
    
    public static int[][] retornarNovoTabuleiroVazio() {
        return new int[tamanhoX][tamanhoY];
    }
    
    public static void obterQuantidadeDeNaviosNoJogo() {
        System.out.println("Max: " + limiteMaximoDeNavios + " navios");
        quantidadeDeNavios = 14;
        if (quantidadeDeNavios < 1 && quantidadeDeNavios > limiteMaximoDeNavios) {
            quantidadeDeNavios = limiteMaximoDeNavios;
        }
    }
    
    public static void instanciarContadoresDeNaviosDosJogadores() {
        naviosJogador1 = quantidadeDeNavios;
        naviosJogador2 = quantidadeDeNavios;
    }
    
    public static int[][] retornarNovoTabuleiroComOsNavios() {
        int novoTabuleiro[][] = retornarNovoTabuleiroVazio();
        int quantidadeRestanteDeNavios = quantidadeDeNavios;
        int x= 0, y= 0;
        Random numeroAleatorio = new Random();
        do {
            x = 0;
            y = 0;
            for(int[] linha : novoTabuleiro) {
                for (int coluna : linha) {
                    if (numeroAleatorio.nextInt(100) <= 10) {
                        if(coluna == VAZIO) {
                            novoTabuleiro[x][y] = NAVIO;
                            quantidadeRestanteDeNavios--;
                            break;
                        }
                        if(quantidadeRestanteDeNavios < 0) {
                            break;
                        }
                    }
                    y++;
                }
                y = 0;
                x++;
                if(quantidadeRestanteDeNavios <= 0) {
                    break;
                }  
            }
        } while (quantidadeRestanteDeNavios > 0);
        return novoTabuleiro;
    }
	public static int[][] retornarNovoTabuleiroComOsNavios2() {
		Scanner in = new Scanner (System.in);
		int novoTabuleiro2[][] = retornarNovoTabuleiroVazio();
		int x= 0, y= 0;
		System.out.println("Posicione seus barcos usando números : ");
		for (int i = 0; i < 14; i++) {
			System.out.print("\n"+i+") Linha  : ");
			x = in.nextInt();
			System.out.print(i+") Coluna : ");
			y = in.nextInt();
			novoTabuleiro2 [x][y] = NAVIO;
		}
		System.out.println("Digite a letra e o número para atirar (O numero de 1 a 9 deverá ser acompanhado de 0) : ");

		return novoTabuleiro2;

	}
    public static void inserirOsNaviosNosTabuleirosDosJogadores() {
        tabuleiroJogador1 = retornarNovoTabuleiroComOsNavios2();
        tabuleiroJogador2 = retornarNovoTabuleiroComOsNavios();
    }

    public static void exibirNumerosDasColunasDosTabuleiros() {
        int numeroDaColuna = 1;
        String numerosDoTabuleiro = "   ";
        
        for(int i = 0; i < tamanhoY; i++) {
            numerosDoTabuleiro += (numeroDaColuna++) + " ";
        }
        System.out.println(numerosDoTabuleiro);
    }
    
    public static void exibirTabuleiro(String nomeDoJogador, int[][] tabuleiro, boolean seuTabuleiro) {
        System.out.println("|----- " + nomeDoJogador + " -----|");
        exibirNumerosDasColunasDosTabuleiros();
        String linhaDoTabuleiro = "";
        char letraDaLinha = 65;
        for(int[] linha : tabuleiro) {
            linhaDoTabuleiro = (letraDaLinha++) + " |";           
            
            for (int coluna : linha) {
                switch(coluna) {
                    case VAZIO : 
                        linhaDoTabuleiro += " |";
                        break;
                    case NAVIO : 
                        if (seuTabuleiro) {
                            linhaDoTabuleiro += "N|";
                            break;
                        } else {
                            linhaDoTabuleiro += " |";
                            break;
                        }
                    case ERROU_TIRO : 
                        linhaDoTabuleiro += "X|";
                        break;
                        
                    case ACERTOU_TIRO : 
                        linhaDoTabuleiro += "D|";
                        break; 
                }
            }
            System.out.println(linhaDoTabuleiro);
        }
    }
    
    public static void exibirTabuleirosDosJogadores() {
        exibirTabuleiro(nomeJogador1, tabuleiroJogador1, true);
        exibirTabuleiro(nomeJogador2, tabuleiroJogador2, false);
    }
        
    public static boolean validarPosicoesInseridasPeloJogador(int[] posicoes) {
        boolean retorno = true;
        if (posicoes[0] > tamanhoX -1) {
            retorno = false;
            System.out.println("A posicao das letras não pode ser maior que " + (char)(tamanhoX + 64));
        }

        if (posicoes[1] > tamanhoY) {
            retorno = false;
            System.out.println("A posicao numérica não pode ser maior que " + tamanhoY);
        }
        
        return retorno;
    }
    
    public static String receberValorDigitadoPeloJogador() {
        System.out.println("Digite a posição do seu tiro:");
        return input.next();
    }
    
    public static boolean validarTiroDoJogador(String tiroDoJogador) {
        int quantidadeDeNumeros = (tamanhoY > 10) ? 2 : 1;
        String expressaoDeVerificacao = "^[A-Za-z]{1}[0-9]{2}$";
        return tiroDoJogador.matches(expressaoDeVerificacao);
    }
    
    public static int[] retornarPosicoesDigitadasPeloJogador(String tiroDoJogador) {
        String tiro = tiroDoJogador.toLowerCase();
        int[] retorno = new int[2];
        retorno[POSICAO_X] = tiro.charAt(0) - 97;
        retorno[POSICAO_Y] = Integer.parseInt(tiro.substring(1)) - 1;
        return retorno;
    }
    
    public static void inserirValoresDaAcaoNoTabuleiro(int[] posicoes, int numeroDoJogador) {
        if (numeroDoJogador == 1) {
            if (tabuleiroJogador2[posicoes[POSICAO_X]][posicoes[POSICAO_Y]] == NAVIO) {
                tabuleiroJogador2[posicoes[POSICAO_X]][posicoes[POSICAO_Y]] = ACERTOU_TIRO;
                naviosJogador2--;
                System.out.println("Você acertou um navio!");
            } else {
                tabuleiroJogador2[posicoes[POSICAO_X]][posicoes[POSICAO_Y]] = ERROU_TIRO;
                System.out.println("Você errou o tiro!");
            }
        } else {
            if (tabuleiroJogador1[posicoes[POSICAO_X]][posicoes[POSICAO_Y]] == NAVIO) {
                tabuleiroJogador1[posicoes[POSICAO_X]][posicoes[POSICAO_Y]] = ACERTOU_TIRO;
                naviosJogador1--;
                System.out.println("Você acertou um navio!");
            } else {
                tabuleiroJogador1[posicoes[POSICAO_X]][posicoes[POSICAO_Y]] = ERROU_TIRO;
                System.out.println("Você errou o tiro!");
            }
        } 
    }
    
    public static boolean acaoDoJogador() {
        boolean acaoValida = true;
        String tiroDoJogador = receberValorDigitadoPeloJogador();
        if (validarTiroDoJogador(tiroDoJogador)) {
            int[] posicoes = retornarPosicoesDigitadasPeloJogador(tiroDoJogador);
            if (validarPosicoesInseridasPeloJogador(posicoes)) {
                inserirValoresDaAcaoNoTabuleiro(posicoes, 1);
            } else {
                acaoValida = false;
            }
        } else {
            System.out.println("Posição inválida");
            acaoValida = false;
        }
        return acaoValida;
    }
    
    public static void acaoDoComputador() {
        int[] posicoes = retornarJogadaDoComputador();
        inserirValoresDaAcaoNoTabuleiro(posicoes, 2);
    }
    
    public static int[] retornarJogadaDoComputador() {
        int[] posicoes = new int[2];
        posicoes[POSICAO_X] = retornarJogadaAleatoriaDoComputador(tamanhoX);
        posicoes[POSICAO_Y] = retornarJogadaAleatoriaDoComputador(tamanhoY);
        return posicoes;
    }
    
    public static int retornarJogadaAleatoriaDoComputador(int limite) {
        Random jogadaDoComputador = new Random();
        int numeroGerado = jogadaDoComputador.nextInt(limite);
        return (numeroGerado == limite) ? --numeroGerado : numeroGerado;
    }
}