package hotel1;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;          

class Hotel1 implements ActionListener
{
JLabel heading,lpubname,lphone,laddress,htl,chkin,chkout,lb1,rst;
JTextField pub_name,pub_phone,pub_address,pub_city,pub_state,pub_zip;
JButton insert,exit,view,Reset,clear;
JPanel p1;
JFrame f1,frame1;
JTable table;
JRadioButton c1,c2,c3;
JComboBox v1,v2,v3,v4,v5,v6;
Connection cont;
Statement stmt;
PreparedStatement statr,statr1;
ResultSet rs;
ImageIcon image1;
ButtonGroup bg;
 String dte[];
 String mte[];
 String yr[];
  String[] columnNames = {"NAME", "ROOMTYPE" , "MOBILE", "CHECKIN", "CHECKOUT", "AMOUNT"};
 static int status=1;
 static int stat=0,stat1=0,stat2=0,stat3=0;
 String from;
 
 public Hotel1()
         {
   String url="jdbc:derby://localhost:1527/panda";
   String username="panda";
   String password="12345";
   String Query="select * from customers";
   try{
        cont=DriverManager.getConnection(url,username,password);        
      }
    catch(SQLException e)
    {
        System.out.println("error has occureed "+e);
    }
}
public void compshow()
{
    dte= new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    mte=new String[]{"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
    yr=new String[]{"2016","2017","2018","2019"};
  
    c1=new JRadioButton("DELUXE");
    c2=new JRadioButton("SUPER DELUXE");
    c3=new JRadioButton("SUITE");
    v1=new JComboBox(dte);
    v2=new JComboBox(mte);
    v3=new JComboBox(yr);
    v4=new JComboBox(dte);
    v5=new JComboBox(mte);
    v6=new JComboBox(yr);
    f1=new JFrame("HOTEL");
    p1=new JPanel();
    heading=new JLabel("ENTER DETAILS");
    rst=new JLabel("CONFIRM BOOKING");

    lpubname=new JLabel("ENTER NAME");
    lphone=new JLabel("ENTER MOBILENUMBER");
    laddress=new JLabel("ENTER ADDRESS");
    htl=new JLabel("SELECT ROOM:");
    chkin=new JLabel("CHECK-IN DATE");
    chkout=new JLabel("CHECK-OUT DATE");

    pub_name=new JTextField(50);
    pub_phone=new JTextField(10);
    pub_address=new JTextField(50);  
         
    insert=new JButton("BOOK");
    insert.setBackground(java.awt.Color.green);
    exit=new JButton("Exit");
    exit.setBackground(java.awt.Color.red);
    view=new JButton("view");
    view.setBackground(java.awt.Color.white);
    Reset=new JButton("CLEAR RECORDS");
    Reset.setBackground(java.awt.Color.red);
    insert.setBackground(java.awt.Color.green);
    p1.setLayout(null);
    heading.setBounds(250,75,200,50);
    p1.add(heading);    
   
    lpubname.setBounds(75,140,200,30);
    pub_name.setBounds(350,140,200,25);
    p1.add(lpubname);
    p1.add(pub_name);
    
    
    lphone.setBounds(75,170,200,30);
    pub_phone.setBounds(350,170,200,25);
    p1.add(lphone);
    p1.add( pub_phone);
   
    laddress.setBounds(75,200,200,30);
    pub_address.setBounds(350,200,200,25);
    p1.add(laddress);
    p1.add(pub_address);    
    c1.setBounds(130,250,200,30);
    c2.setBounds(130,270,200,30);
    c3.setBounds(130,290,200,30);
    
    htl.setBounds(75,225,200,30);
    bg=new ButtonGroup();
    bg.add(c1);
    bg.add(c2);
    bg.add(c3);
    p1.add(c1);
    p1.add(c2);
    p1.add(c3);
    p1.add(htl);
    v1.setBounds(250,330,60,18);
    v2.setBounds(320,330,60,18);
    v3.setBounds(390,330,60,18);
    v4.setBounds(250,360,60,18);
    v5.setBounds(320,360,60,18);
    v6.setBounds(390,360,60,18);
    chkin.setBounds(75,322,200,30);
    chkout.setBounds(75,352,200,30);
    p1.add(chkin);
    p1.add(chkout);
    p1.add(v1);
    p1.add(v2);
    p1.add(v3);
    p1.add(v4);
    p1.add(v5);
    p1.add(v6);
    
 image1 = new ImageIcon(("ff3d5db63f4238634f249c9821312d61.png"));
 lb1=new JLabel(image1);
 lb1.setBounds(8,8,200,125);
  p1.add(lb1);   
      
    insert.setBounds(130,400,100,30);
    exit.setBounds(350,400,100,30);
    view.setBounds(240,420,100,30);
     p1.add(insert);
     p1.add(exit);
      p1.add(view);
    
         
    f1.add(p1);
    f1.setSize(680,500);
    f1.setVisible(true);
    p1.setBackground(java.awt.Color.cyan);
    c1.setBackground(java.awt.Color.cyan);
    c2.setBackground(java.awt.Color.cyan);
    c3.setBackground(java.awt.Color.cyan);
    pub_name.setBackground(java.awt.Color.yellow);
    pub_phone.setBackground(java.awt.Color.yellow);
    pub_address.setBackground(java.awt.Color.yellow);
    v1.setBackground(java.awt.Color.magenta);
    v2.setBackground(java.awt.Color.magenta);
    v3.setBackground(java.awt.Color.magenta);
    v4.setBackground(java.awt.Color.magenta);
    v5.setBackground(java.awt.Color.magenta);
    v6.setBackground(java.awt.Color.magenta);
   // image1 = new ImageIcon(("ff3d5db63f4238634f249c9821312d61.png"));
    
    f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    insert.addActionListener(this);
    view.addActionListener(this);
    exit.addActionListener(this);
}

   
@Override
public void actionPerformed(ActionEvent ae)
{
    if("Exit".equals(ae.getActionCommand()))
    {
        System.exit(0);
    }
    
   else  if("BOOK".equals(ae.getActionCommand()))
     {
                  int i = 0;
                  int d1=0,d2=0,m1=0,m2=0,y1=0,y2=0;
                  if(c1.isSelected())
                          i=1;
                  if(c2.isSelected())
                          i=2;
                   if(c3.isSelected())
                          i=3;         
                    for(int j=0;j<dte.length;j++)
                          if(dte[j].equals(v1.getSelectedItem().toString()))
                              d1=j+1;
                    for(int j=0;j<mte.length;j++)
                          if(mte[j].equals(v2.getSelectedItem().toString()))
                              m1=j+1;
                    for(int j=0;j<yr.length;j++)
                          if(yr[j].equals(v3.getSelectedItem().toString()))
                              y1=j+1;
                    for(int j=0;j<dte.length;j++)
                          if(dte[j].equals(v4.getSelectedItem().toString()))
                              d2=j+1;
                    for(int j=0;j<mte.length;j++)
                          if(mte[j].equals(v5.getSelectedItem().toString()))
                              m2=j+1;
                    for(int j=0;j<yr.length;j++)
                          if(yr[j].equals(v6.getSelectedItem().toString()))
                              y2=j+1;             
                                             
                customer s=new customer();
                FileHandle h=new FileHandle("E:\\JAVA\\Hotel\\names.txt");
       
                         s.setName(pub_name.getText());
                  s.setRoomType(i);
                  s.setCheckIn(y1,m1,d1);
                  s.setCheckOut(y2,m2,d2);
                  double feet=s.getFees();
                  String pphone=pub_phone.getText();
                  try
                  {
                      stat3=1;
                      if(pub_name.getText().isEmpty()){
                       throw new InvalNmAdd("Exception");
                      }
                  }
                  catch(InvalNmAdd e1)
                  {
                      stat3=0;
                     JOptionPane.showMessageDialog(f1,"Please enter a name","Warning",JOptionPane.WARNING_MESSAGE);
                      pub_name.setText("");
                  }
                          
                  try{
                      stat=1;
                      pphone=pub_phone.getText();
                      if((pphone.length()!=10)||(!(pphone.matches("[0-9]+"))))
                          throw new MobileNoException("Exception");                                  
                  }
                  catch(MobileNoException r)
                  { stat3=0;
                     JOptionPane.showMessageDialog(f1,"Invalid Mobile No.","Warning",JOptionPane.WARNING_MESSAGE);
                       pub_phone.setText("");
                  }
                  try
                  {
                      if(stat != 0)
                      stat1=1;
                     
                     if(s.checkDate() || !s.isValidDate())
                        throw new InvalidDateExp("Exception");
                  }
                  catch(InvalidDateExp e)
                      {
                          stat1=0;
                       JOptionPane.showMessageDialog(f1,"Invalid Date.","Warning",JOptionPane.WARNING_MESSAGE);
                      System.out.println("Date catc"+stat);
                       if(stat1==0){
                   f1.setVisible(true);
                   v1.setSelectedIndex(0);
                   v2.setSelectedIndex(0);
                   v3.setSelectedIndex(0);
                   v4.setSelectedIndex(0);
                   v5.setSelectedIndex(0);
                   v6.setSelectedIndex(0);    
                      }
                       }
                   try{
                          stat2=1;
                      if(!c1.isSelected()&&!c2.isSelected()&&!c3.isSelected())                       
                          throw new Nobutttonsel("Exception");
                     }
                      catch(Nobutttonsel e)
                              {
                                  stat2=0;
                                   JOptionPane.showMessageDialog(f1,"Please select a room type.","Warning",JOptionPane.WARNING_MESSAGE);
                                   if(stat2==0)
                                      bg.clearSelection();
                              }
                  String paddress=pub_address.getText();
           
                  String room="";  
                  String room1="";
                  String name="NAME: "+ pub_name.getText();
                  int s1 = 1;
                  if(stat==1&&stat1==1&&stat2==1&&stat3==1)
                {
                  if(c1.isSelected()){
                           room="ROOM: "+c1.getText(); 
                           room=""+c1.getText();
                  }
                  if(c2.isSelected()){
                           room="ROOM: "+c2.getText(); 
                           room=""+c2.getText();
                  }
                  if(c3.isSelected()){
                      room="ROOM: "+c3.getText(); 
                      room=""+c3.getText();
                  }
                  
                      String dtci="DATE OF CHECK-IN: "+v1.getSelectedItem().toString()+"/"+v2.getSelectedItem().toString()+"/"+v3.getSelectedItem().toString();
                      String dtco="DATE OF CHECK-OUT: "+v4.getSelectedItem().toString()+"/"+v5.getSelectedItem().toString()+"/"+v6.getSelectedItem().toString();
                      String feest="AMOUNT: "+feet;
             
                      String finl=name+"\n"+room+"\n"+dtci+"\n"+dtco+"\n"+feest;
                    s1=JOptionPane.showConfirmDialog(rst,finl,"CONFIRM BOOKING",JOptionPane.YES_NO_OPTION);
                }  
                    if(s1==0 && stat==1&&stat1==1&&stat2==1&&stat3==1)
                    {
                    try {
                       String dtci1=""+v1.getSelectedItem().toString()+"/"+v2.getSelectedItem().toString()+"/"+v3.getSelectedItem().toString();
                      String dtco1=""+v4.getSelectedItem().toString()+"/"+v5.getSelectedItem().toString()+"/"+v6.getSelectedItem().toString();
                      String feest1=""+feet;
                            h.SaveName(pub_name.getText()+"\t"+room1+"\t"+pub_phone.getText()+"\t"+dtci1+"\t"+dtco1+"\t"+feest1);
                          } 
                     catch (IOException ex) {
                            Logger.getLogger(Hotel1.class.getName()).log(Level.SEVERE, null, ex);
                              }                              
                      try {
                          statr=cont.prepareStatement("INSERT INTO CUSTOMERS VALUES(?,?,?,?,?,?)");
                                                String dtci=v1.getSelectedItem().toString()+"/"+v2.getSelectedItem().toString()+"/"+v3.getSelectedItem().toString();
                      String dtco=v4.getSelectedItem().toString()+"/"+v5.getSelectedItem().toString()+"/"+v6.getSelectedItem().toString();
                      String feest=""+feet;
                                 String pname=pub_name.getText();
                   pphone=pub_phone.getText();
                   String chkn=dtci;
                  String chko=dtco;    
                  String stk=room;
                  Double r=feet;
                  statr.setString(1, pname);
                  statr.setString(2, pphone);
                  statr.setString(3, stk);
                  statr.setString(4, dtci);
                  statr.setString(5, dtco);
                  statr.setDouble(6, r);           
                  statr.executeUpdate();
                  JOptionPane.showMessageDialog(f1,"Information has beeen inserted.","Information",JOptionPane.INFORMATION_MESSAGE);
              }
              catch(SQLException e)
                      {
                          String msg=e.getMessage();
                          if(e.getMessage().equals(msg))
                          {
                             JOptionPane.showMessageDialog(f1,"Record Already Exists.","Warning Message",JOptionPane.WARNING_MESSAGE);
                             pub_name.setText("");
                             pub_phone.setText("");
                             pub_address.setText("");
                             bg.clearSelection();
                             f1.setVisible(true);
                              v1.setSelectedIndex(0);
                            v2.setSelectedIndex(0);
                           v3.setSelectedIndex(0);
                          v4.setSelectedIndex(0);
                          v5.setSelectedIndex(0);
                        v6.setSelectedIndex(0);    
                          }
                      }                                         
                 status=JOptionPane.showConfirmDialog(rst,"Do you want to do more bookings","Confirmatin",JOptionPane.YES_NO_OPTION);
                 }
                 if(status==0){
                   pub_name.setText("");
                   pub_phone.setText("");
                   pub_address.setText("");
                   bg.clearSelection();
                   f1.setVisible(true);
                   v1.setSelectedIndex(0);
                   v2.setSelectedIndex(0);
                   v3.setSelectedIndex(0);
                   v4.setSelectedIndex(0);
                   v5.setSelectedIndex(0);
                   v6.setSelectedIndex(0);                   
                    }                  
                 else
                  {
               JOptionPane.showMessageDialog(f1,"Please fill details properly","ERROR Message",JOptionPane.ERROR_MESSAGE);
                  }
     }
  if("view".equals(ae.getActionCommand()))
     {
        try {
            showTableData();
        } catch (SQLException ex) {
            Logger.getLogger(Hotel1.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     }
 public void showTableData() throws SQLException 
 {
        frame1 = new JFrame("Database Search Result");
        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame1.setLayout(new BorderLayout());
         
//TableModel tm = new TableModel();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
      
//DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames()); 
//table = new JTable(model);
        table = new JTable();       
        table.setModel(model);
        table.setRowHeight(40);
        table.setBackground(Color.yellow);
        //table.setColumnModel(columnModel);
table.getColumn("NAME").setCellRenderer(new ButtonRenderer());
table.getColumn("NAME").setCellEditor( new ButtonEditor(new JCheckBox()));
        //table.setColumnWidth(100);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
             TableColumn column = null;
    //for (int i = 0; i < 6; i++) {         
     //     if (i==3||i==4) {
    //        column.setPreferredWidth(700);  
    //    } else {
   //         column.setPreferredWidth(500);
   //     }
  //  }
       JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
         //scroll.setPreferredSize(1000,1000);
        //String textvalue = textbox.getText();
         String Query="select * FROM CUSTOMERS";
         try(Statement tmt=cont.createStatement())
         {
            ResultSet rt=tmt.executeQuery(Query);
             //ResultSetMetaData rsdm=rs.getMetaData();
            while(rt.next()){            
            String name = rt.getString("NAME");
            String job = rt.getString("ROOMTYPE");
            String mob = rt.getString("MOBILE");           
            String cib = rt.getString("CHECKIN");
            String cob = rt.getString("CHECKOUT");
            double kob = rt.getDouble("AMOUNT");
            model.addRow(new Object[]{name,job,mob,cib,cob,kob});
               
         }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
         frame1.setBackground(Color.blue);
        frame1.add(scroll);
        frame1.setVisible(true);
        frame1.setSize(800,300);
    }
 
    public static void main(String[] args) {
        Hotel1 p=new Hotel1();
        p.compshow();
     } 
    
 class ButtonRenderer extends JButton implements TableCellRenderer {
  public ButtonRenderer() {
    setOpaque(true);
  }

  public Component getTableCellRendererComponent(JTable table, Object value,
      boolean isSelected, boolean hasFocus, int row, int column) {
    if (isSelected) {
      setForeground(table.getSelectionForeground());
      setBackground(table.getSelectionBackground());
    } else {
      setForeground(table.getForeground());
      setBackground(UIManager.getColor("Button.background"));
    }
    setText((value == null) ? "" : value.toString());
    return this;
  }
}
 class ButtonEditor extends DefaultCellEditor {
  protected JButton button;

  private String label;

  private boolean isPushed;

  public ButtonEditor(JCheckBox checkBox) {
    super(checkBox);
    button = new JButton();
   // button.setBackground(java.awt.Color.magenta);
    button.setOpaque(true);
    button.setBackground(java.awt.Color.magenta);
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        fireEditingStopped();
      }
    });
  }

  public Component getTableCellEditorComponent(JTable table, Object value,
      boolean isSelected, int row, int column) {
    if (isSelected) {
      button.setForeground(table.getSelectionForeground());
      button.setBackground(table.getSelectionBackground());
    } else {
      button.setForeground(table.getForeground());
      button.setBackground(table.getBackground());
    }
    label = (value == null) ? "" : value.toString();
    button.setText(label);
    isPushed = true;
    return button;
  }

  public Object getCellEditorValue() {
    if (isPushed) {
   
            int x=JOptionPane.showConfirmDialog(f1,"Do you wish to delete record","Information",JOptionPane.YES_NO_CANCEL_OPTION);
           System.out.println("as");
           if(x==JOptionPane.YES_OPTION)
            try {
                   statr=cont.prepareStatement("DELETE FROM CUSTOMERS WHERE NAME=?");   
                   statr.setString(1,button.getText());
                  statr.executeUpdate();
                  JOptionPane.showMessageDialog(f1,"Information has beeen deleted.","Information",JOptionPane.INFORMATION_MESSAGE);            
            
        }   catch (SQLException ex) {
                Logger.getLogger(Hotel1.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
            else
               frame1.setVisible(true);
    isPushed = false;
    return new String(label);
  
  }
  public boolean stopCellEditing() {
    isPushed = false;
    return super.stopCellEditing();
  }

  protected void fireEditingStopped() {
    super.fireEditingStopped();
  }
}

}