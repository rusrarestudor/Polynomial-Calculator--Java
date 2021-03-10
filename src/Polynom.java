package Assigmen1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Polynom {
		
	private  List<Monom> poli = new ArrayList<Monom>();

	public Polynom(List<Monom> poli) {			
		this.poli = poli;		
		
	}
	
	public List<Monom> getPolynom(){		
		return this.poli;		
	}
	
	public Polynom setPolynom(List<Monom> list){		
		this.poli = list;
		return this;
	}
	
	public float searchBigestPower() {		
		float power = -1;
		List<Monom> rez = this.getPolynom();
		for(Monom item : rez) {
			if(item.getPwr() > power)
				power = item.getPwr();
		}
		return power;		
	}
	
	public boolean searchByPower(float power) {		
		boolean ok = false;
		List<Monom> rez = this.getPolynom();
		for(Monom item : rez) {
			if(item.getPwr() == power) 
				ok = false;				
		}
		return ok;		
	}
	 
	public Polynom arrangeTermsInPoly(){				
		this.getPolynom().sort(Comparator.comparing(Monom::getPwr).reversed());
		return this;				
	}
			
	public Polynom removeNullFromPoly(){				
		List<Monom> rez = this.getPolynom();
		Monom lucru = new Monom(0,0);
		for(Monom item : rez) {
			lucru = item;
			if(item.getPwr() == 0 && item.getCof() == 0)
				this.getPolynom().remove(lucru);
			else if(item.getCof() == 0 || item.getPwr() == -1)
				this.getPolynom().remove(lucru);
		}		
		return this;				
	}
				
	public String polynomToString() {
		String sir = new String();
		List <Monom> lst = this.getPolynom();
		int zero = 0;
		for(Monom item : lst) 
			if(item.getCof() != 0)
			{
				sir = sir.concat(item.monomToString());
				zero++;
			}
		if(zero == 0)
			sir = sir.concat("0");
		return sir;  
	}
	
	public Polynom clearPolynom(){				
		this.getPolynom().clear();		
		return this;				
	}
	
	public Monom findMonomWithPower(double power) {
		List<Monom> rez = this.getPolynom();
		Monom santinel = new Monom(0,0);
		for(Monom item : rez)
			if(item.getPwr() == power)
				santinel = item;			
		return santinel;
		
	}
				
	}
