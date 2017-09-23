import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class guia extends pessoa implements baseRoteiro {
	private int registro;

	public int getRegistro() {
		return registro;
	}

	public void setRegistro(int registro) {
		this.registro = registro;
	}

	@Override
	public void gerarLinha() throws IOException {
		@SuppressWarnings("resource")
		Scanner scanV = new Scanner(System.in);
		System.out.println("Informe o Nome:");
		this.setNome(scanV.nextLine());
		System.out.println("Informe a data de nascimento:");
		this.setDataNasc(scanV.nextLine());
		System.out.println("Informe o número de registro:");
		this.setRegistro(Integer.parseInt(scanV.nextLine()));
		FileWriter fwLocal = new FileWriter("guia.txt", true);
		PrintWriter pw = new PrintWriter(fwLocal);
		pw.println(this.getNome() + ";" + this.getDataNasc().toString() + ";" + this.getRegistro());
		pw.flush();
		pw.close();

	}

	@Override
	public void lerLinha() throws IOException {
		BufferedReader inputStream = null;
		try {
			inputStream = new BufferedReader(new FileReader("guia.txt"));
			String leitura;
			while ((leitura = inputStream.readLine()) != null) {
				String[] valor = leitura.split(";");
				this.setNome(valor[0]);
				this.setDataNasc(valor[1]);
				this.setRegistro(Integer.parseInt(valor[2]));
				System.out.println("Nome: " + this.getNome());
				System.out.println("Data de nascimento: " + this.getDataNasc());
				System.out.println("Registro: " + this.getRegistro());
				System.out.println("");
			}
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
	}
}
