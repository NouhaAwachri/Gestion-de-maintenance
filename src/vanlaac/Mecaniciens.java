package vanlaac;

public class Mecaniciens {
	//Attributs
	private Number CodeMec;
	private Number Cin;
	private String FullName;
	private Number TempsRep;//temps de reparation
	
	/**
	 * @param codeMec
	 * @param cin
	 * @param fullName
	 * @param tempsRep
	 */
	public Mecaniciens(Number codeMec, Number cin, String fullName, Number tempsRep) {
		super();
		CodeMec = codeMec;
		Cin = cin;
		FullName = fullName;
		TempsRep = tempsRep;
	}
	
	//methods
	
	public String Reparation(String Machine) {
		return " La machine "+ Machine +"est réparer par mr \t"+this.FullName;
	}
	//getters & setters
	public Number getCodeMec() {
		return CodeMec;
	}
	public void setCodeMec(Number codeMec) {
		CodeMec = codeMec;
	}
	public Number getCin() {
		return Cin;
	}
	public void setCin(Number cin) {
		Cin = cin;
	}
	public String getFullName() {
		return FullName;
	}
	public void setFullName(String fullName) {
		FullName = fullName;
	}
	public Number getTempsRep() {
		return TempsRep;
	}
	public void setTempsRep(Number tempsrep) {
		this.TempsRep = TempsRep;
	}
	
	

}
