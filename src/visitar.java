import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class visitar extends local implements baseRoteiro {
	private String observacao;
	private Float custo;

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Float getCusto() {
		return custo;
	}

	public void setCusto(Float custo) {
		this.custo = custo;
	}

	@Override
	public void gerarLinha() throws IOException {
		@SuppressWarnings("resource")
		Scanner scanV = new Scanner(System.in);
		System.out.println("Informe o Local:");
		this.setNome(scanV.nextLine());
		System.out.println("Informe o endereço::");
		this.setEndereco(scanV.nextLine());
		System.out.println("Informe o custo da visita:");
		this.setCusto(Float.parseFloat(scanV.nextLine()));
		System.out.println("Relate alguma observação:");
		String obs = scanV.nextLine();
		this.setObservacao(obs);
		FileWriter fwLocal = new FileWriter("localV.txt", true);
		PrintWriter pw = new PrintWriter(fwLocal);
		pw.println(this.getNome() + ";" + this.getEndereco() + ";" + this.getCusto().toString() + ";"
				+	this.getObservacao());
		pw.flush();
		pw.close();
	}

	@Override
	public void lerLinha() throws IOException {
		BufferedReader inputStream = null;
		try {
			inputStream = new BufferedReader(new FileReader("localV.txt"));
			String leitura;
			while ((leitura = inputStream.readLine()) != null) {
				String[] valor = leitura.split(";");
				this.setNome(valor[0]);
				this.setEndereco(valor[1]);
				this.setCusto(Float.parseFloat(valor[2]));
				this.setObservacao(valor[3]);
				System.out.println("Nome: "+this.getNome());
				System.out.println("Endereço: "+this.getEndereco());
				System.out.println("Custo: "+this.getCusto());
				System.out.println("Obervação:"+this.getObservacao());
				System.out.println("");
			}
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
	}
}
