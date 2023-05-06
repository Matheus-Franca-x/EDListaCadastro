package model;

import javax.swing.JOptionPane;

public class Cliente 
{
	private String cpf = "";
	private String nome;
	private int idade;
	private double limitCredit;
	
	public Cliente(String cpf, String nome, int idade, double limitCredit)
	{
		this.nome = nome;
		this.idade = idade;
		this.limitCredit = limitCredit;
		
		String str = cpf; 					//como o construct e o primeiro a ser iniciado, 
		str = str.replaceAll("[^0-9]", ""); //eu decidi fazer uma pequena brincadeira de
											//ajeitar o cpf e caso ele nao exista na 
		if(str.length() == 11)				//verificacao, e lancado uma mensagem de
		{									//CPF Invalido.
											//Mas caso ele exista, ele transforma na formatacao
											//certinha de um CPF, com 2 ponto e 1 traco.
			String formataCpf = 
					str.substring(0, 3) + "." +
					str.substring(3, 6) + "." +
					str.substring(6, 9) + "-" +
					str.substring(9, 11);
			str = formataCpf;
			this.cpf = str;
		}
		else
		{
			JOptionPane.showMessageDialog(null, "CPF Invalido!");
		}
	}

	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}

	public double getLimitCredit() {
		return limitCredit;
	}

	
	
}
