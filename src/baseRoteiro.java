import java.io.FileNotFoundException;
import java.io.IOException;

public interface baseRoteiro {
	public void gerarLinha() throws IOException;

	public void lerLinha() throws FileNotFoundException, IOException;
}
