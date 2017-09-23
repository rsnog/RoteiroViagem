import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		while (true) {
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			System.out.println("   .: ROTEIRO DE VIAGENS :.   ");
			System.out.println("");
			System.out.println("SELECIONE UMA OP플O:   ");
			System.out.println("1 - LOCAIS");
			System.out.println("2 - GUIAS");
			System.out.println("2 - VISITANTES");
			int escolha = (Integer.parseInt(scan.nextLine()));
			switch (escolha) {
			case 1:
				local();
				break;
			case 2:
				guia();
				break;
			case 3:
				visitante();
				break;
			default:
				break;
			}
		}
	}

	public static void local() throws IOException {
		@SuppressWarnings("resource")
		Scanner scan2 = new Scanner(System.in);
		naoVisitar NVisit = new naoVisitar();
		visitar Visit = new visitar();
		System.out.println(" .: ROTEIRO DE VIAGENS :. ");
		System.out.println("");
		System.out.println("SELECIONE UMA OP플O: ");
		System.out.println("1 - GRAVAR LOCAL A SER VISITADO");
		System.out.println("2 - GRAVAR LOCAL A SER EVITADO");
		System.out.println("3 - MOSTAR LOCAIS");
		int escolha2 = scan2.nextInt();
		switch (escolha2) {
		case 1:
			Visit.gerarLinha();
			break;
		case 2:
			NVisit.gerarLinha();
			break;
		case 3:
			Visit.lerLinha();
			NVisit.lerLinha();
			break;
		default:
			break;
		}
	}

	public static void guia() throws IOException {
		guia g = new guia();
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println(" .: ROTEIRO DE VIAGENS :. ");
		System.out.println("");
		System.out.println("SELECIONE UMA OP플O: ");
		System.out.println("1 - GRAVAR GUIA");
		System.out.println("2 - MOSTAR GUIAS");
		int escolha = scan.nextInt();
		switch (escolha) {
		case 1:
			g.gerarLinha();
			break;
		case 2:
			g.lerLinha();
			break;
		default:
			break;
		}
	}

	public static void visitante() throws IOException {
		visitante v = new visitante();
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println(" .: ROTEIRO DE VIAGENS :. ");
		System.out.println("");
		System.out.println("SELECIONE UMA OP플O: ");
		System.out.println("1 - GRAVAR VISITANTE");
		System.out.println("2 - MOSTAR VISITANTES");
		int escolha = scan.nextInt();
		switch (escolha) {
		case 1:
			v.gerarLinha();
			break;
		case 2:
			v.lerLinha();
			break;
		default:
			break;
		}
	}
}
