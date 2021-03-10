package Assigmen1;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class JUnitTest {

	@Test
	void testAdd() {
		Operation op = new Operation();
		List<Monom> pol1 = new ArrayList<Monom>();
		List<Monom> pol2 = new ArrayList<Monom>();
		Monom m11 = new Monom(2,2);
		Monom m12 = new Monom(3,1);
		Monom m21 = new Monom(-4,2);
		Monom m22 = new Monom(5,0);
		pol1.add(m11);
		pol1.add(m12);
		pol2.add(m21);
		pol2.add(m22);
		Polynom p1 = new Polynom(pol1);
		Polynom p2 = new Polynom(pol2);
		Polynom rez = op.addPolynoms(p1,p2);
		String outp = rez.polynomToString();
		assertEquals("-2X^2+3X^1+5X^0", outp);
	}
	
	@Test
	void testSubb() {
		Operation op = new Operation();
		List<Monom> pol1 = new ArrayList<Monom>();
		List<Monom> pol2 = new ArrayList<Monom>();
		Monom m11 = new Monom(2,2);
		Monom m12 = new Monom(3,1);
		Monom m21 = new Monom(-4,2);
		Monom m22 = new Monom(5,0);
		pol1.add(m11);
		pol1.add(m12);
		pol2.add(m21);
		pol2.add(m22);
		Polynom p1 = new Polynom(pol1);
		Polynom p2 = new Polynom(pol2);
		Polynom rez = op.subbPolynoms(p1,p2);
		String outp = rez.polynomToString();
		assertEquals("+6X^2+3X^1-5X^0", outp);
	}
	
	@Test
	void testMul() {
		Operation op = new Operation();
		List<Monom> pol1 = new ArrayList<Monom>();
		List<Monom> pol2 = new ArrayList<Monom>();
		Monom m11 = new Monom(2,2);
		Monom m12 = new Monom(3,0);
		Monom m21 = new Monom(1,2);
		Monom m22 = new Monom(1,1);
		pol1.add(m11);
		pol1.add(m12);
		pol2.add(m21);
		pol2.add(m22);
		Polynom p1 = new Polynom(pol1);
		Polynom p2 = new Polynom(pol2);
		Polynom rez = op.mulPolynoms(p1,p2);
		String outp = rez.polynomToString();
		assertEquals("+2X^4+2X^3+3X^2+3X^1", outp);
	}
	
	@Test
	void testDeriv() {
		Operation op = new Operation();
		List<Monom> pol1 = new ArrayList<Monom>();
		Monom m11 = new Monom(3,2);
		Monom m12 = new Monom(4,1);
		pol1.add(m11);
		pol1.add(m12);
		Polynom p1 = new Polynom(pol1);
		Polynom rez = op.derivPolynom(p1);
		String outp = rez.polynomToString();
		assertEquals("+6X^1+4X^0", outp);
	}
	
	@Test
	void testIntegr() {
		Operation op = new Operation();
		List<Monom> pol1 = new ArrayList<Monom>(); 
		Monom m11 = new Monom(3,2);
		Monom m12 = new Monom(4,1);
		pol1.add(m11);
		pol1.add(m12);
		Polynom p1 = new Polynom(pol1);
		Polynom rez = op.integrPolynom(p1);
		String outp = rez.polynomToString();
		assertEquals("+1X^3+2X^2", outp); 
	}
}
