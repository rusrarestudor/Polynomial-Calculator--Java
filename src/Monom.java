package Assigmen1;

import java.text.DecimalFormat;


public class Monom {
	
	private int pwr;
	private float cof;
	
	public Monom(float f, int g) {		
		this.pwr = g;
		this.cof = f;			
	}
	
	public int getPwr() {		
		return pwr;		
	}
	
	public float getCof() {		
		return cof;		
	}
	
	public void setCof(float c) {		
		this.cof = c;		
	}
	
	public void setPwr(int p) {		
		this.pwr = p;		
	}
		 
	public Monom addMonoms(Monom x2) {
		Monom rez = new Monom((this.getCof() + x2.getCof()), this.getPwr());
		return rez;
	}

	public Monom subbMonoms(Monom x2) {
		Monom rez = new Monom((this.getCof() - x2.getCof()), this.getPwr());
		return rez;
	}

	public String monomToString() {
		String rez = null;
		if(this.getPwr() == 0)
			if(this.getCof() >= 0) 
				rez = '+' + String.valueOf(new DecimalFormat("##.##").format(this.getCof()))+ "X^0";		
			else 
				rez = String.valueOf(new DecimalFormat("##.##").format(this.getCof()))+ "X^0";
		else
			if(this.getCof() >= 0) 
				rez = '+' + String.valueOf(new DecimalFormat("##.##").format(this.getCof())) + "X^" + this.getPwr();		
			else 
				rez =  String.valueOf(new DecimalFormat("##.##").format(this.getCof())) + "X^" + this.getPwr();					
		return rez;
	}

}
