import javax.swing.*;
import java.awt.*;
import java.awt.event.*;




public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    //Array of J buttons
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton,subButton,mulButton,divButton;
    JButton decButton,equButton,delButton,clrButton,negButton;
    JButton fileReaderButton;
    JPanel panel;



    //Declare Font to reuse
    Font myFont = new Font("Ink Free", Font.BOLD,30);

    //declare double values
    double num1=0,num2=0,result=0;
    char operatorAdd;
    char operator;
    final char PLUS = '+', MINUS = '-', MULTIPLY = '*', DIVIDE = '/';

    //Constructor
    Calculator(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 800);
        frame.setLayout(null);

        textField = new JTextField();
        //setting textField bounds cause we run no layout
        textField.setBounds(150,40,350,50);
        textField.setFont(myFont);
        textField.setEditable(false);

        //adding buttons

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");
        negButton = new JButton("(-)");
        fileReaderButton = new JButton("FileReader");
        fileReaderButton.addActionListener(this);

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        for( int i=0;i<9;i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        for(int i=0;i<10;i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        negButton.setBounds(120,630,150,100);
        delButton.setBounds(270,630,150,100);
        clrButton.setBounds(420,630,150,100);

        panel = new JPanel();
        panel.setBounds(120,200,400,400);
        panel.setLayout(new GridLayout(4,4,10,10));
       // panel.setBackground(Color.GRAY);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(fileReaderButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);


        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);

    }

    public static void main(String[] args){

        Calculator calc = new Calculator();

    }

    @java.lang.Override
    public void actionPerformed(java.awt.event.ActionEvent e) {

        for(int i=0;i<10;i++){
            if(e.getSource() == numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        //adding functionality to buttons
        if(e.getSource()==decButton){
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource()==addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText(" ");
        }
        if(e.getSource()==subButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText(" ");
        }
        if(e.getSource()==mulButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText(" ");
        }
        if(e.getSource()==divButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText(" ");
        }
        if(e.getSource()==equButton){
            num2=Double.parseDouble(textField.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    try {
                        xmlWriter.writeXML(num1, num2);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    break;

                case'-':
                    result=num1-num2;
                    try {
                        xmlWriter.writeXML(num1, num2);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    break;

                case'*':
                    result=num1*num2;
                    try {
                        xmlWriter.writeXML(num1, num2);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    break;

                case'/':
                    result=num1/num2;
                    try {
                        xmlWriter.writeXML(num1, num2);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
            }
            textField.setText(String.valueOf(result));
            num1=result;
        }
        if(e.getSource()==clrButton) {
            textField.setText(" ");
        }
        if(e.getSource()==delButton){
            String string = textField.getText();
            textField.setText("");
            for(int i=0; i <string.length()-1;i++) {
                textField.setText(textField.getText() + string.charAt(i));
            }
        }
        if(e.getSource()==negButton){
            double temp = Double.parseDouble(textField.getText());
            temp*=-1;
            textField.setText(String.valueOf(temp));

        }
        if(e.getSource()==fileReaderButton){

            xmlParser.parseXML("C:\\Users\\lange\\IdeaProjects\\tests\\Calculator\\src\\tester.xml",textField);
            textField.setText(String.valueOf(result));
        }

    }
}
