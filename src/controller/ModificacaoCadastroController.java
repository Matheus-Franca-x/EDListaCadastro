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
		File dir = new File("C:\\TEMP");
		
		if(!dir.exists())
		{
			dir.mkdirs();
		}
		
		boolean existe = false;
		Cliente cad = null;
		File arq = new File("C:\\TEMP", arquivo);
		existe = false;
		if(arq.exists())
		{
			existe = true;
		}
		
		FileWriter abreArq = new FileWriter(arq, existe);
		PrintWriter escreveArq = new PrintWriter(abreArq);
		String conteudo = "";
		
		escreveArq.write("CPF;Nome;Idade;LimiteCredito\n");
		escreveArq.flush();
		
		while(!l.isEmpty())
		{
			cad = (Cliente) l.get(0);
			conteudo = cad.getCpf() + ";" + cad.getNome() + ";" + cad.getIdade() + ";" + cad.getLimitCredit() + "\n";
			escreveArq.write(conteudo);
			escreveArq.flush();
			l.removeFirst();
		}
		
		escreveArq.close();
		abreArq.close();
	}
	
	public void cadastroPadrao()
	{
		ListaObject padrao = new ListaObject();
		Cliente[] clientPadrao = 
		{
				new Cliente("54707521304", "Cliente A", 45, 11108.88),
				new Cliente("19003628372", "Cliente B", 41, 9756.00),
				new Cliente("54446710134", "Cliente C", 33, 7217.00),
				new Cliente("93126907239", "Cliente D", 40, 14353.00),
				new Cliente("34935227995", "Cliente E", 30, 7342.00),
				new Cliente("26679245568", "Cliente F", 53, 9491.00),
				new Cliente("47817135372", "Cliente G", 31, 5244.00),
				new Cliente("88160205180", "Cliente H", 31, 12817.00),
				new Cliente("13667799861", "Cliente I", 28, 12686.00),
				new Cliente("27977151616", "Cliente J", 21, 11092.00),
				new Cliente("56634688310", "Cliente K", 18, 7697.00),
				new Cliente("77407950202", "Cliente L", 45, 8877.00),
				new Cliente("76113821167", "Cliente M", 26, 3865.00),
				new Cliente("60505933383", "Cliente N", 18, 3978.00),
				new Cliente("38134578281", "Cliente O", 26, 9574.00),
				new Cliente("39557597722", "Cliente P", 27, 6476.00),
				new Cliente("43535332258", "Cliente Q", 34, 3776.00),
				new Cliente("13897841035", "Cliente R", 32, 7964.00),
				new Cliente("22264929711", "Cliente S", 34, 4204.00),
				new Cliente("24246599452", "Cliente T", 31, 4869.00),
				new Cliente("94461659861", "Cliente U", 22, 12770.00),
				new Cliente("95029452114", "Cliente V", 49, 11877.00),
				new Cliente("61587656636", "Cliente W", 43, 4802.00),
				new Cliente("33660496913", "Cliente X", 46, 8208.00),
				new Cliente("73014492090", "Cliente Y", 19, 6177.00),
				new Cliente("46043531381", "Cliente Z", 20, 10641.00)
		};
		
		for (Cliente each: clientPadrao)
		{
			if (padrao.isEmpty())
			{
				padrao.addFirst(each);
			}
			else
			{
				try {
					padrao.addLast(each);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		try {
			novoArquivo(padrao, "Cadastro.csv");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	

}
