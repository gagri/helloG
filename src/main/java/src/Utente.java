package src;

public class Utente {
	
	public String usernameU;
	public String passwordU;
	public String nome;
	public String cognome;
			
	public Utente(String usernameU, String passwordU,String nome, String cognome) {
		this.usernameU = usernameU;
		this.passwordU = passwordU;
		this.nome = nome;
		this.cognome = cognome;
	}
	
	public String getUsernameU() {
		return usernameU;
	}

	public void setUsernameU(String usernameU) {
		this.usernameU = usernameU;
	}

	public String getPasswordU() {
		return passwordU;
	}

	public void setPasswordU(String passwordU) {
		this.passwordU = passwordU;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	@Override
	public String toString() {
		//return "Utente=" + usernameU +", Password=" + passwordU + ", Nome= "+nome+", Cognome="+cognome + "\n";
		
		return "Username=" + usernameU + "\n" + "Password=" + passwordU + "\n";
	}
}