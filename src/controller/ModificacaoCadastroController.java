package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import matheus.ListaObject.ListaObject;
import model.Cliente;

public class ModificacaoCadastroController {

	public ModificacaoCadastroController() 
	{
		super();
	}
	
	
	private void novoArquivo(ListaObject l, String arquivo) throws Exception //criacao do novo arquivo
	{
		File dir = new File("C:\\TEMP");
		
		if(!dir.exists()) //caso nao exista um diretorio, ele criara um diretorio \TEMP no C:\
		{
			dir.mkdirs();
		}
		
		boolean existe = false; //verificacao da existencia do arquivo
		Cliente cad = null; //cliente com null para entrada de outro cliente
		File arq = new File("C:\\TEMP", arquivo); //arquivo que sera criado e buscado
		existe = false;
		if(arq.exists()) //teste para saber se o arquivo exista, caso existe, ele criara um novo
		{
			existe = true;
		}
		
		FileWriter abreArq = new FileWriter(arq, existe); //arquivo sera criado por aqui
		PrintWriter escreveArq = new PrintWriter(abreArq);
		String conteudo = "";
		
		escreveArq.write("CPF;Nome;Idade;LimiteCredito\n"); //primeiras celula da planilha
		escreveArq.flush();
		
		while(!l.isEmpty())
		{
			cad = (Cliente) l.get(0); //aqui entrara o cliente que esta na lista como Object
			conteudo = cad.getCpf() + ";" +  //conteudo ira pegar todos os valores
					   cad.getNome() + ";" + //dentro do Cliente
					   cad.getIdade() + ";" + 
					   cad.getLimitCredit() + "\n";
			
			escreveArq.write(conteudo); //entrada de valor na planilha
			escreveArq.flush();
			l.removeFirst();
		}
		
		escreveArq.close();
		abreArq.close();
	}
	
	public void novoCadastro(int idadeMin, int idadeMax, double limiteCredit) throws Exception
	{
		
		File arq = new File("C:\\TEMP", "Cadastro.csv"); //verificacao do cadastro.csv para saber se existe
		
		if (arq.exists() && arq.isFile())
		{
			
			ListaObject listaCad = new ListaObject(); //criacao da lista
			
			FileInputStream abreFlux = new FileInputStream(arq);
			InputStreamReader lerFlux = new InputStreamReader(abreFlux);
			BufferedReader buffer = new BufferedReader(lerFlux);
			String linha = buffer.readLine();
			linha = buffer.readLine(); //ha dois readline para nao pegar a primeira celula da plan
			
			while (linha != null)
			{
				String[] vet = linha.split(";"); 
				
				if (Integer.parseInt(vet[2]) >= idadeMin && //verificacao para saber se e o valor
					Integer.parseInt(vet[2]) <= idadeMax && //desejado que estao no parametro
					Double.parseDouble(vet[3]) > limiteCredit)
				{
					//criacao de um novo cliente com os parametro
					//desejado, entrando como um Object na lista
					
					Cliente cad = new Cliente(vet[0], 
							vet[1], 
							Integer.parseInt(vet[2]), 
							Double.parseDouble(vet[3]));
					
					if (listaCad.isEmpty()) //add na primeira
					{
						listaCad.addFirst(cad);
					}
					else //add na ultima, para ficar organizado
					{
						listaCad.addLast(cad);
					}
					
				}
				linha = buffer.readLine();
			}
			
			buffer.close();
			lerFlux.close();
			abreFlux.close();
			
			novoArquivo(listaCad, "Idade-" +  //tipo de arquivo que sera criado na hora de gerar
						idadeMin + "-A-" + 	  //uma nova lista
						idadeMax + "-Limite-" + 
						limiteCredit + ".csv");
			
		}
		else
		{ //caso cadastro.csv nao exista, sera enviado um Exception
			throw new Exception("Nao existe o arquivo necessario!");
		}
		
	}
	
	public void cadastroPadrao() //Nao e tao necessario, mas para teste e interessante ter
	{							 //um cadastro padrao, no caso a que esta no pdf
		File arq = new File("C:\\TEMP", "Cadastro.csv"); //verificacao para saber se o arquivo existe,
														 //caso existe, ele nao criara.
		if (!arq.exists() && !arq.isFile())
		{
			ListaObject padrao = new ListaObject();
			Cliente[] clientPadrao = //Vetor de cliente com as chamadas padrao
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
			
			for (Cliente each: clientPadrao) //para cada cliente, sera add na lista
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
				novoArquivo(padrao, "Cadastro.csv"); //lancado na lista para a criacao do Cadastro.csv
			} catch (Exception e) {
				e.printStackTrace();
			
			}
		}
	}
}

