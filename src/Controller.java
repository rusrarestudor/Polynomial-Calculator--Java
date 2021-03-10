package Assigmen1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Controller {
	private View view;
	
	public Controller(View view) {
		this.view = view;
		view.addActionListener(new Add(), new Subb(), new Multp(), new Deriv(), new Integr() ,new Div());
	}
	
	class Add implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Operation op = new Operation();
			Polynom pol1 = view.textToPolynom(view.getPolTxt1());
			Polynom pol2 = view.textToPolynom(view.getPolTxt2());
			Polynom rez = op.addPolynoms(pol1,pol2);
			String s = rez.polynomToString();
			view.setPolRez(s);
		}
	}
	
	class Subb implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Operation op = new Operation();
			Polynom pol1 =view.textToPolynom(view.getPolTxt1());
			Polynom pol2 = view.textToPolynom(view.getPolTxt2());
			Polynom rez = op.subbPolynoms(pol1,pol2);
			String s = rez.polynomToString();
			view.setPolRez(s);
		}
	}
	
	class Multp implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Operation op = new Operation();
			Polynom pol1 =view.textToPolynom(view.getPolTxt1());
			Polynom pol2 = view.textToPolynom(view.getPolTxt2());
			Polynom pol3 = op.mulPolynoms(pol1,pol2);
			String s = pol3.polynomToString();
			view.setPolRez(s);
		}
	}
	
	class Div implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Operation op = new Operation();
			Polynom pol1 =view.textToPolynom(view.getPolTxt1());
			Polynom pol2 = view.textToPolynom(view.getPolTxt2());
			if(pol2.getPolynom().get(0).getCof() != 0)
			{
				Polynom pol3 = op.divPolynoms(pol1,pol2);
				String s = pol3.polynomToString();
				view.setPolRez(s);
			}
			else
				view.setPolRez("Can't divide by ZERO!");			
		}
		
	}
	
	class Deriv implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Operation op = new Operation();
			Polynom pol1 = view.textToPolynom(view.getPolTxt1());
			Polynom rez = op.derivPolynom(pol1);
			String s = rez.polynomToString();
			view.setPolRez(s);
		}
	}
	
	class Integr implements  ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Operation op = new Operation();
			Polynom pol1 = view.textToPolynom(view.getPolTxt1());
			Polynom rez = op.integrPolynom(pol1);
			String s = rez.polynomToString();
			view.setPolRez(s);
		}
	}
	
	
}

