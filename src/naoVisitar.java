import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class naoVisitar extends local implements baseRoteiro {
	private String observacao;

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public void gerarLinha() throws IOException {
		@SuppressWarnings("resource")
		Scanner scanV = new Scanner(System.in);
		System.out.println("Informe o Local:");
		this.setNome(scanV.nextLine());
		System.out.println("Informe o endereço::");
		this.setEndereco(scanV.nextLine());
		System.out.println("Relate alguma observação:");
		String obs = "NÃO VISITAR: " + scanV.nextLine();
		this.setObservacao(obs);
		FileWriter fwLocal = new FileWriter("localNV.txt", true);
		PrintWriter pw = new PrintWriter(fwLocal);
		pw.println(this.getNome() + ";" + this.getEndereco() + ";" + this.getObservacao());
		pw.flush();
		pw.close();

	}

	@Override
	public void lerLinha() throws IOException {
		BufferedReader inputStream = null;
		try {
			inputStream = new BufferedReader(new FileReader("localNV.txt"));
			String leitura;
			while ((leitura = inputStream.readLine()) != null) {
				String[] valor = leitura.split(";");
				this.setNome(valor[0]);
				this.setEndereco(valor[1]);
				this.setObservacao(valor[2]);
				System.out.println("Nome: " + this.getNome());
				System.out.println("Endereço: " + this.getEndereco());
				System.out.println("Obervação:" + this.getObservacao());
				System.out.println("");
			}
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}

	}
}
