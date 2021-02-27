package com.godev.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.godev.model.Espaco;
import com.godev.model.Pessoa;
import com.godev.model.Sala;

public class Principal {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<Pessoa> listaPessoas = new ArrayList<Pessoa>();
		List<Sala> listaSala = new ArrayList<Sala>();
		List<Espaco> listaEspaco = new ArrayList<Espaco>();
		int opcao = 1;
		while (opcao != 0) {

			opcao = obterOpcaoMenu(scan);
			switch (opcao) {
			case 1:
				cadastrarPessoa(scan, listaPessoas);
				break;
			case 2:
				cadastrarSala(scan, listaSala);
				break;
			case 3:
				cadastrarEspaco(scan, listaEspaco);
				break;
			case 4:
				consultarPessoa(scan, listaPessoas);
				break;
			case 5:
				consultarSala(scan, listaSala);
				break;
			case 6:
				consultarEspaco(scan, listaEspaco);
				break;
			}
		}
	}

	private static void consultarEspaco(Scanner scan, List<Espaco> listaEspaco) {
		String nome=lerInformacao("Digite o nome do espaco", scan);
		Optional<Espaco> espacoFiltrado = listaEspaco.stream().filter(e -> e.getNome().contains(nome)).findFirst();
		if (espacoFiltrado.isPresent()) {
			System.out.println("Espaco encontrada: "+espacoFiltrado.get()+"\n\n");
		} else {
			System.out.println("Espaco não encontrada\n\n");
		}
		
	}

	private static void consultarSala(Scanner scan, List<Sala> listaSala) {
		String nome=lerInformacao("Digite o nome da sala", scan);
		Optional<Sala> salaFiltrada = listaSala.stream().filter(s -> s.getNome().contains(nome)).findFirst();
		if (salaFiltrada.isPresent()) {
			System.out.println("Sala encontrada: "+salaFiltrada.get()+"\n\n");
		} else {
			System.out.println("Sala não encontrada\n\n");
		}
		
	}

	private static void consultarPessoa(Scanner scan, List<Pessoa> listaPessoas) {
		String nome=lerInformacao("Digite o primeiro nome", scan);
		Optional<Pessoa> pessoaFiltrada = listaPessoas.stream().filter(p -> p.getNome().contains(nome)).findFirst();
		if (pessoaFiltrada.isPresent()) {
			System.out.println("Pessoa encontrada: "+pessoaFiltrada.get()+"\n\n");
		} else {
			System.out.println("Pessoa não encontrada\n\n");
		}
		
	}

	private static void cadastrarEspaco(Scanner scan, List<Espaco> listaEspaco) {
		String nome = lerInformacao("Digite o nome da espaco", scan);
		int lotacao= lerInformacaoInt("Digite a quantidade de lotação", scan);
		Espaco espaco=new Espaco(nome,lotacao);
		listaEspaco.add(espaco);
		
	}

	private static void cadastrarSala(Scanner scan, List<Sala> listaSala) {
		String nome = lerInformacao("Digite o nome da sala", scan);
		int lotacao= lerInformacaoInt("Digite a quantidade de lotação", scan);
		Sala sala=new Sala(nome,lotacao);
		listaSala.add(sala);
	}

	private static void cadastrarPessoa(Scanner scan, List<Pessoa> listaPessoas) {
		String nome = lerInformacao("Digite seu Nome", scan);
		String sobrenome = lerInformacao("Digite seu Sobrenome", scan);
		Pessoa pessoa = new Pessoa(nome, sobrenome);
		listaPessoas.add(pessoa);
	}

	private static String lerInformacao(String msg, Scanner scan) {
		System.out.println(msg);
		String entrada = scan.nextLine();
		return entrada;

	}

	private static int lerInformacaoInt(String msg, Scanner scan) {

		boolean entradaValida = false;
		int num = 0;

		while (!entradaValida) {

			try {

				System.out.println(msg);
				String entrada = scan.nextLine();

				num = Integer.parseInt(entrada);

				entradaValida = true;

			} catch (Exception e) {
				System.out.println("Entrada inválida, digite novamente");
			}
		}

		return num;
	}

	private static int obterOpcaoMenu(Scanner scan) {
		int opcao = 0;

		String entrada;
		boolean entradaValida = false;
		while (!entradaValida) {
			System.out.println("Digite a Opção de Entrada:");
			System.out.println("1: Cadastrar Pessoa");
			System.out.println("2: Cadastrar Sala");
			System.out.println("3: Cadastrar Espaço");
			System.out.println("4: Consultar Pessoa");
			System.out.println("5: Consultar Sala");
			System.out.println("6: Consultar Espaço");
			System.out.println("0: Sair");
			try {
				entrada = scan.nextLine();
				opcao = Integer.parseInt(entrada);

				if (opcao >= 0 && opcao <= 6) {
					entradaValida = true;
				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("Entrada invalida,digite novamente\n\n");
			}

		}

		return opcao;
	}
}
