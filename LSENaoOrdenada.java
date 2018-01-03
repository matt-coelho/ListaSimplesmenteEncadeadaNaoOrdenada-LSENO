package pkgLSENaoOrdenada;
import java.util.*;
public class LSENaoOrdenada {
	private static class Lista{
		public int num;
		public Lista prox;
	}// fim classe
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		Lista inicio = null;
		Lista fim = null;
		Lista aux;
		Lista anterior;
		
		int op = 0, numero = 0, achou;
		do{// MENU
			System.out.println("\tMenu\n1 - Inserir no inicio da lista\n2 - Inserir no final da lista\n3 - Consultar toda a lista\n4 - Remover da lista\n5 - Esvaziar a lista\n6 - Remover primeira ocorr�ncia de um valor\n7 - SAIR\nDigite sua op��o:");
			op = entrada.nextInt();
			if(op<1 || op>7){
				System.err.println("Op��o Inv�lida!!!");
			}// fim if <1 || >6
			
			// INSERIR NO IN�CIO =========================================================
			else if(op == 1){
				System.out.println("Digite o numero a ser inserido no inicio da lista.");
				Lista novo = new Lista();
				novo.num = entrada.nextInt();
				if(inicio == null){
					inicio = novo;
					fim = novo;
					novo.prox = null;
				}//fim if
				else{
					novo.prox = inicio;
					inicio = novo;
				}//fim else
			System.out.println("O numero "+novo.num+" foi inserido ao inicio da lista!");
			}//fim else 1 - Inserir no inicio da lista
			
			//INSERIR NO FINAL DA LISTA =========================================================
			else if(op==2){
				System.out.println("Digite o numero a ser inserido no final da lista.");
				Lista novo = new Lista();
				novo.num = entrada.nextInt();
				if(inicio == null){
					inicio = novo;
					fim = novo;
					novo.prox = null;
				}//fim if inicio == null
				else{ 
					fim.prox = novo;
					fim = novo;
					novo.prox = null;
				}//fim else inicio == null
			System.out.println("O numero "+novo.num+" foi inserido ao fim da lista!");
			}//fim else if 2 - Inserir no fim da lista
			
			// CONSULTAR TODA A LISTA =========================================================
			else if(op == 3){
				if(inicio == null){
					System.out.println("A lista est� vazia");
				}//fim if
				else{
					aux = inicio;
					System.out.println("O primeiro n�mero da lista � "+inicio.num+", o n�mero final da lista � "+fim.num+".\n");
					while (aux != null){
						System.out.print(aux.num+" ");
						aux = aux.prox;
					}//fim while aux = null
				System.out.println("\n");
				}//fim else
			}//fim else 3 - Consultar toda a lista
			
			// REMOVER UM VALOR DA LISTA (TODAS AS SUAS OCORR�NCIAS) =========================================================
			else if(op==4) {
				if(inicio == null){
					System.out.println("A lista est� vazia");
				}//fim if
				else{
					System.out.println("Digite o elemento a ser removido");
					numero = entrada.nextInt();
				}//fim else
				aux = inicio;
				anterior = null;
				achou = 0;
				while( aux != null){
					if(aux.num == numero){
						achou = achou + 1;
						if(aux == inicio){
							inicio = aux.prox;
							aux = inicio;
						}//fim if aux == inicio
						else if(aux == fim){
							anterior.prox = null;
							fim = anterior;
							aux = null;
						}//fim else if (aux == fim)
						else{
							anterior.prox = aux.prox;
							aux = aux.prox;
						}//fim else do if (aux == inicio) e else if(aux == fim)
					}//fim if aux.num == numero
					else{
						anterior = aux;
						aux = aux.prox;
					}//fim else do if(aux == inicio)
				}//fim while
				if(achou == 0){
					System.out.println("N�mero n�o encontrado na lista!");
				}//if achou
				else if(achou == 1){
					System.out.println("N�mero removido uma vez!");
				}//fim else if achou == 1
				else{
					System.out.println("N�mero removido "+achou+" vezes!");
				}//fim else bloco achou
			}//fim if op = 4 - Remover da lista
				
			// ESVAZIAR A LISTA =========================================================	
			else if(op==5){
				if(inicio == null){
					System.out.println("A lista est� vazia!");
				}//fim if
				else{
					//esvaziando a lista
					inicio = null;
					System.out.println("A lista foi esvaziada!");
				}//fim else esvaziando a lista
			}//fim else 5 - Esvaziar lista
			
			// REMOVER PRIMEIRA OCORRENCIA DE UM VALOR
			else if(op==6){
				if(inicio == null){
					System.out.println("A lista est� vazia");
				}//fim if
				else{
					System.out.println("Digite o elemento a ser removido");
					numero = entrada.nextInt();
				}//fim else
				aux = inicio;
				anterior = null;
				achou = 0;
				while( aux != null){
					if(aux.num == numero){
						achou = achou + 1;
						if(aux == inicio){
							inicio = aux.prox;
							aux = inicio;
							break;
						}//fim if aux == inicio
						else if(aux == fim){
							anterior.prox = null;
							fim = anterior;
							aux = null;
							break;
						}//fim else if (aux == fim)
						else{
							anterior.prox = aux.prox;
							aux = aux.prox;
							break;
						}//fim else do if (aux == inicio) e else if(aux == fim)
					}//fim if aux.num == numero
					else{
						anterior = aux;
						aux = aux.prox;
					}//fim else do if(aux == inicio)
				}//fim while aux!= numero
				if(achou==0){
					System.out.println("N�mero n�o encontrado!");
				}//fim if achou ==0
				else{
					System.out.println("N�mero removido da lista");
				}//fim else
			}//fim else if op 6 - remover primeira ocorrencia de um valor
			
		}while(op != 7);//fim do while
		System.err.println("------------FIM DA APLICA��O------------\n");
	}//fim public main()
}//fim class
