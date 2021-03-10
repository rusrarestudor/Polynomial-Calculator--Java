package Assigmen1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class View extends JFrame{
	private JFrame frame = new JFrame();

	private JLabel pol1 = new JLabel("Polinom1:");
	private JTextField pol1Txt = new JTextField();
	
	private JLabel pol2 = new JLabel("Polinom2:");
	private JTextField pol2Txt = new JTextField();
	
	private JLabel pol3 = new JLabel("Rezultat:");
	private JLabel pol3Txt = new JLabel();
	
	private JButton add = new JButton("Add");
	private JButton sub = new JButton("Subb");
	private JButton multp = new JButton("Multp");
	private JButton div = new JButton("Div");
	private JButton integr = new JButton("Integrate");
	private JButton deriv = new JButton("Derivate");
	
	public View() {
		frame.setSize(600,400);
		frame.setBackground(Color.YELLOW);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		pol1.setFont(new Font("Serif", Font.PLAIN, 30));
		pol1.setBackground(Color.GREEN);
		pol2.setFont(new Font("Serif", Font.PLAIN, 30));
		pol2.setBackground(Color.GREEN);
		pol3.setFont(new Font("Serif", Font.BOLD, 30));
		pol3.setBackground(Color.red);
		pol3Txt.setFont(new Font("Serif", Font.PLAIN, 30));
		pol1Txt.setPreferredSize(new Dimension(200,40));
		pol2Txt.setPreferredSize(new Dimension(200,40));
		panel1.add(pol1);
		panel1.add(pol1Txt);
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		panel2.add(pol2);
		panel2.add(pol2Txt);
		JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout());
		panel3.add(pol3);
		panel3.add(pol3Txt);
		JPanel panel4 = new JPanel();
		panel4.setLayout(new FlowLayout());
		panel4.add(add);
		panel4.add(sub);		
		panel4.add(multp);
		panel4.add(div);
		panel4.add(integr);
		panel4.add(deriv);
		JPanel panel5 = new JPanel();
		panel5.setLayout(new BoxLayout(panel5, BoxLayout.Y_AXIS));
		panel5.add(panel1);
		panel5.add(panel2);
		panel5.add(panel3);
		panel5.add(panel4);
		
		frame.setContentPane(panel5);
		frame.setVisible(true);
	}
	
	public void addActionListener(ActionListener add, ActionListener subb, ActionListener multp, ActionListener deriv, ActionListener integr, ActionListener div){
		this.add.addActionListener(add);
		this.sub.addActionListener(subb);	
		this.multp.addActionListener(multp);
		this.deriv.addActionListener(deriv);
		this.integr.addActionListener(integr);
		this.div.addActionListener(div);
	}
	
		
	public Polynom textToPolynom(JTextField inputField){

        ArrayList<Monom> monoms = new ArrayList<>();
        String stringInput = inputField.getText();

        String[] splits = stringInput.split("\\+");
        for (int i = 0; i < splits.length; i++){
            String[] parts = splits[i].split("X\\^");
            if (parts.length > 0)
               monoms.add(new Monom( Float.parseFloat(parts[0]),Integer.parseInt(parts[1])));
            
            else monoms.add(new Monom( Float.parseFloat(parts[0]),0));
        }

        Polynom rez = new Polynom(monoms);
		return rez;
       
    }

	
	public JTextField getPolTxt1() {
		return pol1Txt;
	}
	
	public JTextField getPolTxt2() {  
		return pol2Txt;
	}
	
	public void setPolRez(String s) {
		this.pol3Txt.setText(s);
	}
	
	
	public static void main(String[] args) {
										
	}

}
