package Base;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import Lista.LDE;

	public class Arquivo {

		public static void gravar(String conteudo, String nomeArquivo) throws Exception {
			FileOutputStream arquivo = new FileOutputStream(new File(nomeArquivo));
			BufferedWriter buffer = new BufferedWriter(new OutputStreamWriter(arquivo, "UTF-8"));
			buffer.write(conteudo);
			buffer.close();
			arquivo.close();
		}
		
		public static LDE getLinhas(String nomeArquivo) throws Exception {
			LDE lista = new LDE();
			String linha;
			FileInputStream arquivo = new FileInputStream(new File(nomeArquivo));
			BufferedReader buffer = new BufferedReader(new InputStreamReader(arquivo, "UTF-8"));
			buffer.readLine();
			do {
				linha = buffer.readLine();
				if (linha != null)
					lista.insereFim(linha);
			} while (linha != null);
			buffer.close();
			arquivo.close();
			return lista;
		}
	}
