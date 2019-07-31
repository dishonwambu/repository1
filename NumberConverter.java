package numberconverter;
import java.awt.*;
import java.awt.event.*;
public class NumberConverter extends Frame{

    private final  Label lblEnter;
    private final Label lblConvert;
    private final Label lblResult;
    private CheckboxGroup numbers;
    private final Checkbox bin;
    private final Checkbox hexa;
    private final Checkbox octa;
    int n,result;
    private TextField txtInput,txtOutput;
    private final Panel pnlouter;
    private final Panel pnlFirst;
    private final Panel pnlSecond;
    private final Button btnclear;
    private final Button btnconvert;
public NumberConverter(){
lblEnter=new Label("Enter a positive integer only");
lblConvert=new Label("Convert To:");
lblResult=new Label("Result:");
txtInput=new TextField("",1);
txtOutput=new TextField("",1);
numbers=new CheckboxGroup();
bin=new Checkbox("Binary",numbers,true);
hexa=new Checkbox("Hexadcimal",numbers,false);
octa=new Checkbox("Octal",numbers,false);
btnclear=new Button("Clear");
btnconvert=new Button("convert");

pnlouter=new Panel();
pnlFirst=new Panel();
pnlSecond=new Panel();

add(pnlouter,BorderLayout.CENTER);
pnlouter.add(pnlFirst,BorderLayout.CENTER);
pnlouter.add(pnlSecond,BorderLayout.CENTER);

pnlFirst.setLayout(new GridLayout(10,1));
pnlFirst.add(lblEnter);
pnlFirst.add(txtInput);
pnlFirst.add(lblConvert);
pnlFirst.add(bin);
pnlFirst.add(hexa);
pnlFirst.add(octa);
pnlFirst.add(lblResult);
pnlFirst.add(txtOutput);
pnlFirst.add(btnconvert);
pnlFirst.add(btnclear);
 
btnconvert.addActionListener(new ActionListener(){
    
    @Override
    public void actionPerformed(ActionEvent ae) {
       int count=Integer.parseInt(txtInput.getText());
        
       if(bin.getState()==true)
       {
           new Conversion().decToBinary();
       }
       else if(hexa.getState()==true)
       {
           
       new Conversion().decToHexa();
       }
       else
       {
       
       new Conversion().decToOctal();

       }
    }
}

);
btnclear.addActionListener(new ActionListener()
{
    @Override
    public void actionPerformed(ActionEvent evt) {
        txtInput.setText("");
        bin.setState(true);
        txtOutput.setText("");
  
    }
});
 addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent evt) {
            System.exit(0);
         }
      });

setSize(450,400);
    setVisible(true);
}
   
    public static void main(String[] args) {
        new NumberConverter();
    }
 class Conversion 
{
     void decToBinary()
    {
       int count=Integer.parseInt(txtInput.getText());
        int[] binaryNum = new int[1000];
        int i = 0;
        while (count > 0) 
        {
          binaryNum[i] = count % 2;
            count = count / 2;
            
            i++;
        }
        String Str="";
        for (int j = i - 1; j >= 0; j--)
        {
            Str+=Integer.toString(binaryNum[j]);
      
        txtOutput.setText(Str);
        
        }
    }
     void decToHexa() {
         
      int n=Integer.parseInt(txtInput.getText());
        char[] hexaDeciNum = new char[100]; 
       
        int i = 0; 
        while(n!=0) 
        {    
           int temp  = 0; 
         
            temp = n % 16; 
           
           if(temp < 10) 
            { 
                hexaDeciNum[i] = (char)(temp + 48); 
                i++; 
            } 
            else
            { 
                hexaDeciNum[i] = (char)(temp + 55); 
                i++; 
            } 
            n = n/16; 
        } 
        String str="";
        for(int j=i-1; j>=0; j--) {
           
            str+=hexaDeciNum[j];
            txtOutput.setText(str);
        }
     }
    void decToOctal() 
    { 
        int n=Integer.parseInt(txtInput.getText());
        int[] octalNum = new int[100]; 
  
        int i = 0; 
        while (n != 0)  
        { 
            octalNum[i] = n % 8; 
            n = n / 8; 
            i++; 
        } 
  
        String str="";
        for (int j = i - 1; j >= 0; j--) {
            str+=Integer.toString(octalNum[j]);
            txtOutput.setText(str);
      } 
    }
 }
}
   