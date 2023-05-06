package model;

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
		
		String str = cpf;
		str = str.replaceAll("[^0-9]", "");
		
		System.out.println(str);
				
			if(str.length() == 11)
			{
				System.out.println("E um cpf");
					
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
				System.out.println("CPF Invalido");			
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
