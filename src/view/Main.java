package view;

import controller.ModificacaoCadastroController;

public class Main {

	public static void main(String[] args) 
	{
		ModificacaoCadastroController controll = new ModificacaoCadastroController();
		
		controll.cadastroPadrao(); //Criacao do arquivo cadastro com as informacoes do pdf
		
		try {
			controll.novoCadastro(41, 60, 8000.00); //metodos do exercicio
			controll.novoCadastro(31, 40, 5000.00); //idade min, idade max e limite de credito
			controll.novoCadastro(21, 30, 3000.00); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
