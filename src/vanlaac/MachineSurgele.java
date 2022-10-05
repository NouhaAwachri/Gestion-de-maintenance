package vanlaac;

public class MachineSurgele extends Machine {

	public MachineSurgele(Number codeMachine, Number codeMec, String type, Number tempsArret, Number tempsRep) {
			
			super(codeMachine,codeMec,tempsArret, tempsRep);
			this.type=type;
		}
		//attributs
	    private String type;
		//getters & setters
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		
	}

