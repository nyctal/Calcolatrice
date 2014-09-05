import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Calcolatrice extends JFrame{

	Container finestra;
	JPanel tasti,pan1,pan2,pan3;
	JTextField display;
	JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,piu,meno,div,per,ris,azzera;
	ActionListener lis;
	GridLayout griglia;
	public	float tot=0;
	float a1, a2;
	char op;
	int s=0;
	
	/*Metodi da utilizzare*/
	
	void numeri(int n){
		tot=(tot*10)+n;
		display.setText(""+tot);
		if (s==0) s=1;
		if (s==2) s=3;
	}

	void risultato(){
		switch (op){
			case '+':
				tot=a1+a2;
				break;
			case '-':
				tot=a1-a2;
				break;
			case '*':
				tot=a1*a2;
				break;
			case '/':
				tot=a1/a2;
				break;
		}
	}

	void operazione(char c){
		op=c;
		if (s==1) {
			a1=tot;
			tot=0;
			display.setText(""+tot);
			s=2;
		}
		if (s==3) {
			a2=tot;
			risultato();
			a1=tot;
			tot=0;
			display.setText(""+tot);
			s=2;	
		}
	}
	/* fine*/

	class ListenerUnico implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Object sorgente=e.getSource();
			if (sorgente==b0) numeri(0);
			if (sorgente==b1) numeri(1);
			if (sorgente==b2) numeri(2);
			if (sorgente==b3) numeri(3);
			if (sorgente==b4) numeri(4);
			if (sorgente==b5) numeri(5);
			if (sorgente==b6) numeri(6);
			if (sorgente==b7) numeri(7);
			if (sorgente==b8) numeri(8);
			if (sorgente==b9) numeri(9);	
			if (sorgente==azzera){
				tot=0;
				display.setText(""+tot);
				s=0;
			}
			if (sorgente==piu) operazione('+');
			if (sorgente==meno) operazione('-');
			if (sorgente==div) operazione('/');
			if (sorgente==per) operazione('*');
			if (sorgente==ris){
				if (s==3){
					a2=tot;
					risultato();
					display.setText(""+tot);
					a1=tot;
					//tot=0;
					s=1;
				}
			}
		}
	}

	public Calcolatrice(){
		 
		lis=new ListenerUnico();

		display=new JTextField(""+tot);
		display.setEditable(false);
		display.setHorizontalAlignment(JTextField.RIGHT);
		
		b0=new JButton("0");
		b1=new JButton("1");
		b2=new JButton("2");
		b3=new JButton("3");
		b4=new JButton("4");
		b5=new JButton("5");
		b6=new JButton("6");
		b7=new JButton("7");
		b8=new JButton("8");
		b9=new JButton("9");
		piu=new JButton("+");
		meno=new JButton("-");
		div=new JButton("/");
		per=new JButton("*");
		ris=new JButton("=");
		azzera=new JButton("C");
		
		b0.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		b0.setMaximumSize(new Dimension(1,1));
		
		
		b0.addActionListener(lis);
		b1.addActionListener(lis);
		b2.addActionListener(lis);
		b3.addActionListener(lis);
		b4.addActionListener(lis);
		b5.addActionListener(lis);
		b6.addActionListener(lis);
		b7.addActionListener(lis);
		b8.addActionListener(lis);
		b9.addActionListener(lis);
		piu.addActionListener(lis);
		meno.addActionListener(lis);
		div.addActionListener(lis);
		per.addActionListener(lis);
		ris.addActionListener(lis);
		azzera.addActionListener(lis);

		tasti=new JPanel();
		griglia=new GridLayout(4,4);
		tasti.setLayout(griglia);
			
		griglia.setHgap(10);
		griglia.setVgap(10);
		
		
		tasti.add(b1);
		tasti.add(b2);
		tasti.add(b3);
		tasti.add(piu);
		tasti.add(b4);
		tasti.add(b5);
		tasti.add(b6);
		tasti.add(meno);
		tasti.add(b7);
		tasti.add(b8);
		tasti.add(b9);
		tasti.add(per);
		tasti.add(b0);
		tasti.add(azzera);
		tasti.add(ris);
		tasti.add(div);
		
		pan1=new JPanel();
		pan2=new JPanel();
		pan3=new JPanel();
		
		finestra= getContentPane();
		finestra.setLayout(new BorderLayout(7,7));
		finestra.add(display,BorderLayout.NORTH);
		finestra.add(tasti,BorderLayout.CENTER);
		finestra.add(pan1,BorderLayout.SOUTH);
		finestra.add(pan2,BorderLayout.EAST);
		finestra.add(pan3,BorderLayout.WEST);
		
		addWindowListener(new WindowAdapter(){
		
			public void windowClosing(WindowEvent e){
				System.exit(0);
				} 
			});
		pack();
		setVisible(true);
	}


	public static void main(String[] args)
	{
		Calcolatrice app=new Calcolatrice();
	}
}
