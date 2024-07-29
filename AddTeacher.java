package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class AddTeacher extends JFrame implements ActionListener{
    
    JTextField tfname ,tffname,tfaddress,tfphone,tfemail,tfx,tfxII, tfaadhar;
    JLabel labelempId;
    JDateChooser dcdob;
    JComboBox cbcourse,cbbranch;
    JButton submit,cancel;
    
    Random ran = new Random();
    long first4=Math.abs((ran.nextLong() % 9000L)+1000L);
    
    AddTeacher(){
        setSize(900,700);
        setLocation(350,50);
        setLayout(null);
        
        JLabel heading =new JLabel("New Teacher Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);
        
        JLabel lbname=new JLabel("Name");
        lbname.setBounds(50,150,100,30);
        lbname.setFont(new Font("serif",Font.BOLD ,20));
        add(lbname);
        
        tfname=new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname); 
        
        JLabel lbfname=new JLabel("Father's Name");
        lbfname.setBounds(400,150,200,30);
        lbfname.setFont(new Font("serif",Font.BOLD ,20));
        add(lbfname);
        
        tffname=new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);
        
        JLabel lbempid=new JLabel("Employee Id");
        lbempid.setBounds(50,200,200,30);
        lbempid.setFont(new Font("serif",Font.BOLD ,20));
        add(lbempid);
        
        labelempId=new JLabel("101"+first4);
        labelempId.setBounds(200,200,200,30);
        labelempId.setFont(new Font("serif",Font.BOLD ,20));
        add(labelempId);
        
        JLabel lbdob=new JLabel("Date Of Birth");
        lbdob.setBounds(400,200,200,30);
        lbdob.setFont(new Font("serif",Font.BOLD,20));
        add(lbdob);
                
        dcdob=new JDateChooser();
        dcdob.setBounds(600,200,150,30);
        add(dcdob);
        
        JLabel lbaddress=new JLabel("Address");
        lbaddress.setBounds(50,250,200,30);
        lbaddress.setFont(new Font("serif",Font.BOLD ,20));
        add(lbaddress);
        
        tfaddress=new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);
        
        JLabel lbphone=new JLabel("Phone Number");
         lbphone.setBounds(400,250,250,30);
         lbphone.setFont(new Font("serif",Font.BOLD ,20));
        add( lbphone);
        
        tfphone=new JTextField();
        tfphone.setBounds(600,250,150,30);
        add(tfphone);
        
        JLabel lbemail=new JLabel("Email Id");
        lbemail.setBounds(50,300,100,30);
        lbemail.setFont(new Font("serif",Font.BOLD ,20));
        add(lbemail);
        
        tfemail=new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail); 
        
        JLabel lblx=new JLabel("Class X (%)");
        lblx.setBounds(400,300,200,30);
        lblx.setFont(new Font("serif",Font.BOLD ,20));
        add(lblx);
        
        tfx=new JTextField();
        tfx.setBounds(600,300,150,30);
        add(tfx);
        
        JLabel lblxII=new JLabel("Class XII (%)");
        lblxII.setBounds(50,350,200,30);
        lblxII.setFont(new Font("serif",Font.BOLD ,20));
        add(lblxII);
        
        tfxII=new JTextField();
        tfxII.setBounds(200,350,150,30);
        add(tfxII);
        
        JLabel lblaadhar=new JLabel("Aadhar Number");
        lblaadhar.setBounds(400,350,200,30);
        lblaadhar.setFont(new Font("serif",Font.BOLD ,20));
        add(lblaadhar);
        
        tfaadhar=new JTextField();
        tfaadhar.setBounds(600,350,150,30);
        add(tfaadhar);
        
        JLabel lblcourse=new JLabel("Qualification");
        lblcourse.setBounds(50,400,200,30);
        lblcourse.setFont(new Font("serif",Font.BOLD ,20));
        add(lblcourse);
        
        String course[]={"B.Tech","BBA","BCA","MCA","BA","MCom","MBA","Bsc"};
        cbcourse=new JComboBox(course);
        cbcourse.setBounds(200,400,150,30);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);
        
        JLabel lblbranch=new JLabel("Department");
        lblbranch.setBounds(400,400,200,30);
        lblbranch.setFont(new Font("serif",Font.BOLD ,20));
        add(lblbranch);
        
        String branch[]={"Compute Science","civil","IT","Mechanical","DSA","AIML"};
        cbbranch=new JComboBox(branch);
        cbbranch.setBounds(600,400,150,30);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);
        
        submit =new JButton("Submit");
        submit.setBounds(250, 550, 120, 30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma",Font.BOLD,16));
        add(submit);
        
        cancel =new JButton("Cancel");
        cancel.setBounds(450, 550, 120, 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,16));
        add(cancel);
        
        setVisible(true);   
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == submit){
            String name=tfname.getText();
            String fname=tfname.getText();
            String rollno=labelempId.getText();
            String dob=((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String address=tfaddress.getText();
            String phone=tfphone.getText();
            String email=tfemail.getText();
            String x=tfx.getText();
            String xii=tfxII.getText();
            String aadhar=tfaadhar.getText();
            String course=(String)cbcourse.getSelectedItem();
            String branch=(String)cbbranch.getSelectedItem();
            
            try{
                
                String query="insert into teacher values('"+name+"','"+fname+"','"+rollno+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+x+"','"+xii+"','"+aadhar+"','"+course+"','"+branch+"')";
                Conn con=new Conn();
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Teacher Details Inserted Successfully");
                setVisible(false);
                
            }catch(Exception ex){
                ex.printStackTrace();
            }  
        }
        else {
            setVisible(false);
        }
    }
    
    public static void  main(String []args){
        new AddTeacher();
    }
}
