package vanlaac;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// instanciation des mecanicien w n7othom fl liste
		//same pour les machines a reparer
		// ask bout date et les mettre dans une autre liste 
	//	affichage sous forme de fenetre fiha  cin mec w ism el meca, type machine rep et temps d'arret wl date ili 
		//saret fiha el operation
		//tkoun sous forme de tableau de 4 chmps avec stockage sql 
		//tji fi fenetre  kima mt3 el spring 

		//Lpartie hedi lezemha toul tet7at fl BD lawej aliha plz !
		ArrayList <Mecaniciens> groupMec = new ArrayList <Mecaniciens>(50);
	
		
		System.out.println("Numero Code :");
		Scanner codeMec=new Scanner("System.in");//type scanner !!!!
		System.out.println("Numero CIN :");
		Scanner cin=new Scanner("System.in");
		System.out.println("Nom et Prenom:");
		Scanner fullName=new Scanner("System.in");
		System.out.println("temps de reparation");
		Scanner tempsRep=new Scanner("System.in");
		
		
		//Mecaniciens Mecanicien1 = new Mecaniciens(codeMec,cin,fullName,tempsRep);
		Scanner scMec = new Scanner(System.in);
	
		for(Mecaniciens  C : groupMec) {
			groupMec.add(C);
		}
		
		ArrayList <Machine> groupMa = new ArrayList <Machine>(100);
		Scanner scMa = new Scanner(System.in);
	
		for(Machine  C : groupMa) {
			groupMa.add(C);
		}

	}

}
