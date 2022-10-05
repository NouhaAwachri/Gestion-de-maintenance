package vanlaac;

public class MachineSimple extends Machine {

	public MachineSimple(Number codeMachine, Number codeMec, String type, Number tempsArret, Number tempsRep) 
	{
		// TODO Auto-generated constructor stub
		super(codeMachine,codeMec,tempsArret, tempsRep);
		this.type=type;
	}
	
   //attribut
	private String type;
	
	//getters & setters
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	

}
