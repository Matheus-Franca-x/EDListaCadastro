package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import matheus.ListaObject.ListaObject;
import model.Cliente;

public class ModificacaoCadastroController {

	public ModificacaoCadastroController() 
	{
		super();
	}
	
	
	private void novoArquivo(ListaObject l, String arquivo) throws Exception
	{
		Cliente cad = null;
		File arq = new File("C:\\TEMP", arquivo);
		File geraArq = new File("C:\\TEMP", arquivo);
		boolean existe = false;
		if(geraArq.exists())
		{
			existe = true;
		}
		
		FileWriter abreArq = new FileWriter(geraArq, existe);
		PrintWriter escreveArq = new PrintWriter(abreArq);
		String conteudo = "";
		int i = 0;
		while(!l.isEmpty())
		{
			cad = (Cliente) l.get(i);
			conteudo = cad.getCpf() + ";" + cad.getNome() + ";" + cad.getIdade() + ";" + cad.getLimitCredit();
			conteudo = l.get(i);
			escreveArq.write(conteudo);
			escreveArq.flush();
			
		}
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	

}
