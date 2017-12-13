import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TemperatureWindow extends JFrame implements ActionListener{
    private Container pane;
    private JButton CtoF;
    private JButton FtoC;
    private JLabel i;
    private JLabel o;
    private JTextField t;
    private JTextField a;
 
    //CONSTRUCTOR SETS EVERYTHING UP
    public TemperatureWindow() {
	this.setTitle("Farenheit 451 = Celsius 232.777777777777777777777777777777777777777777777777777777...");
	this.setSize(400,100);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());  //NOTE!! THIS CAN BE CHANGED (see below)
    
	CtoF = new JButton("Celsius to Farenheit");
	CtoF.addActionListener(this);
	FtoC = new JButton("Farenheit to Celsius");
	FtoC.addActionListener(this);
	i = new JLabel("INPUT:");
	o = new JLabel("OUTPUT:");
	t = new JTextField(12);
	t.addActionListener(this);
	a = new JTextField(12);
	a.addActionListener(this);
	pane.add(CtoF);
	pane.add(FtoC);
	pane.add(i);
	pane.add(t);
	pane.add(o);
	pane.add(a);
    }

    public void actionPerformed(ActionEvent e){
	String event = e.getActionCommand();
	System.out.println(event);
	if(event.equals("Celsius to Farenheit") || event.equals("Farenheit to Celsius")){
	    String text = t.getText();
	    double n = 0;
	    try{
		n = Double.parseDouble(text);
	    }
	    catch(NumberFormatException x){
		a.setText("Sorry, that is not a valid temperature measure.");
	    }
	    if (event.equals("Celsius to Farenheit")){
		a.setText("" + TempConversion.CtoF(n));
	    } else {
		a.setText("" + TempConversion.FtoC(n));
	    }
	    //a.setText(t.getText());
	}
    }

    //MAIN JUST INSTANTIATES + MAKE VISIBLE
    public static void main(String[] args) {
	TemperatureWindow g = new TemperatureWindow();
	g.setVisible(true);
    }
}
