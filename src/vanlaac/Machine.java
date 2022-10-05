package vanlaac;

public class  Machine  {
	// il existe 4 types de machines donc ça va etre une classe mére et 4 classes d'heritages !
	// Association de chaque machine avec son mecanicien 
	
	//Attribut

	protected Number codeMachine;
	protected Number codeMec;
	protected String type;
	protected Number tempsArret;//temps d arret
	protected Number tempsRep;//temps de reparation
	
	// constructor
	/**
	 * @param codeMachine
	 * @param codeMec
	 * @param type
	 * @param tempsArret
	 * @param tempsRep
	 */
	public Machine(Number codeMachine, Number codeMec, Number tempsArret, Number tempsRep) {
		super();
		this.codeMachine = codeMachine;
		this.codeMec = codeMec;
		this.tempsArret = tempsArret;
		this.tempsRep = tempsRep;
	}
	
	//methods
	 /*public Number tempsArret();
	 public String codeMec();
	 public String type();*/
	
	//getters & setters
	
		public Number getCodeMachine() {
			return codeMachine;
		}
		
	public void setCodeMachine(Number codeMachine) {
		this.codeMachine = codeMachine;
	}
	public Number getCodeMec() {
		return codeMec;
	}
	public void setCodeMec(Number codeMec) {
		this.codeMec = codeMec;
	}
	
	public Number getTempsArret() {
		return tempsArret;
	}
	public void setTempsArret(Number tempsArret) {
		this.tempsArret = tempsArret;
	}
	public Number getTempsRep() {
		return tempsRep;
	}
	public void setTempsRep(Number tempsRep) {
		this.tempsRep = tempsRep;
	}
	
	
	
}