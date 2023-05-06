package view;

import controller.ModificacaoCadastroController;
import matheus.ListaObject.ListaObject;
import model.Cliente;

public class Main {

	public static void main(String[] args) 
	{
		ListaObject l = new ListaObject();
		Cliente a = new Cliente("12345678911", "Matheus", 23, 500);
		
		l.addFirst(a);
		
		ModificacaoCadastroController controll = new ModificacaoCadastroController();
		
		controll.cadastroPadrao();
		
	}

}
