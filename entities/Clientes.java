package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Clientes {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private String name;
	private String email;
	private Date dtNascimento;
	
	public Clientes( ) {
		
	}

	public Clientes(String name, String email, Date dtNascimento) {
		this.name = name;
		this.email = email;
		this.dtNascimento = dtNascimento;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	
	@Override
	public String toString() {
		return name + " (" + sdf.format(dtNascimento) + ") - " + email;
 	}

}
