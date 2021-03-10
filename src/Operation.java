package Assigmen1;

import java.util.ArrayList;
import java.util.List;

public class Operation {

public Polynom addPolynoms(Polynom p1, Polynom p2) {
	List<Monom> rezultat = new ArrayList<Monom>();	
	Monom monom1 = new Monom(0,0);	
	Monom monom2 = new Monom(0,0);	
	float maxPower1 = p1.searchBigestPower();
	float maxPower2 = p2.searchBigestPower();
	float maxPower = Math.max(maxPower1,maxPower2);			
	while(maxPower >= 0) {
		monom1 =p1.findMonomWithPower(maxPower); 
		monom2 = p2.findMonomWithPower(maxPower);									
		if(monom1.getCof() == 0 && monom2.getCof() != 0)
			rezultat.add(monom2);
		else if (monom1.getCof() != 0 && monom2.getCof() == 0)
			rezultat.add(monom1);
		else if (monom1.getCof() != 0 && monom2.getCof() != 0)
			rezultat.add(monom1.addMonoms(monom2));
		else if (monom1.getCof() == 0 && monom2.getCof() == 0)
		{}
		maxPower--;					
	}					
	Polynom result = new Polynom(rezultat);
	return result;
}

public Polynom subbPolynoms(Polynom p1, Polynom p2) {
	List<Monom> rezultat = new ArrayList<Monom>();	
	Monom monom1 = new Monom(0,0);	
	Monom monom2 = new Monom(0,0);	
	float maxPower1 = p1.searchBigestPower();
	float maxPower2 = p2.searchBigestPower();
	float maxPower = Math.max(maxPower1,maxPower2);			
	while(maxPower >= 0) {
		monom1 =p1.findMonomWithPower(maxPower); 
		monom2 = p2.findMonomWithPower(maxPower);							
		if(monom1.getCof() == 0 && monom2.getCof() != 0) {
			monom2.setCof(-monom2.getCof());
			rezultat.add(monom2);}
		else if (monom1.getCof() != 0 && monom2.getCof() == 0)
			rezultat.add(monom1);
		else if (monom1.getCof() != 0 && monom2.getCof() != 0)
			rezultat.add(monom1.subbMonoms(monom2));
		else if (monom1.getCof() == 0 && monom2.getCof() == 0)
		{}
		maxPower--;					
	}					
	Polynom result = new Polynom(rezultat);
	return result;
}

public Polynom mulPolynoms(Polynom p1, Polynom p2) {
	List<Monom> aux = new ArrayList<Monom>();	
	List<Monom> rezultat = new ArrayList<Monom>();	
	
	Polynom auxPolynom = new Polynom(aux);
	Polynom resultPolynom = new Polynom(rezultat);
	
	List<Monom> poliList1 = p1.getPolynom();
	List<Monom> poliList2 = p2.getPolynom();
		
	for(Monom item1 : poliList1) {
		for(Monom item2 : poliList2) {
			Monom monomAux = new Monom((item1.getCof() * item2.getCof()), item1.getPwr() + item2.getPwr());
			aux.add(monomAux);
		}				
		auxPolynom.setPolynom(aux);
		resultPolynom = addPolynoms(auxPolynom,resultPolynom);		
		aux.clear();
	}
	
	return resultPolynom;
}

public Polynom divPolynoms(Polynom p1, Polynom p2) {
	
	List<Monom> aux = new ArrayList<Monom>();	
	List<Monom> rezultat = new ArrayList<Monom>();	
	
	Polynom auxPolynom = new Polynom(aux);
	Polynom resultPolynom = new Polynom(rezultat);
	return resultPolynom;
}

public Polynom derivPolynom(Polynom p1) {	
	List<Monom> poliList1 = p1.getPolynom();
	float coef;
	int power;
	
	List<Monom> rezultat = new ArrayList<Monom>();
	
	for(Monom item : poliList1) {
		coef = item.getCof() * item.getPwr();
		power=item.getPwr() - 1;
		if(power == -1)
		{}
		else if(power == 0) {
			item.setCof(coef );
			item.setPwr(power);
			rezultat.add(item);
		}
		else{
			item.setCof(coef);
			item.setPwr(power);
			rezultat.add(item);
		}
	}
	Polynom result = new Polynom(rezultat);
	return result;
}

public Polynom integrPolynom(Polynom p1) {	
	List<Monom> poliList1 = p1.getPolynom();
	float coef;
	int power;
	
	List<Monom> rezultat = new ArrayList<Monom>();
	
	for(Monom item : poliList1) {
		coef = item.getCof() / (item.getPwr() + 1);
		power=item.getPwr() + 1;
		if(power == -1)
		{}
		else {
			item.setCof(coef);
			item.setPwr(power);
			rezultat.add(item);
		}
	}
	Polynom result = new Polynom(rezultat);
	return result;
}
}