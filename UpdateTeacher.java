package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateTeacher extends JFrame implements ActionListener {
    
    JTextField tfcourse ,tfaddress,tfphone,tfemail,tfbranch;
    JLabel labelempId;
    JButton submit,cancel;
    Choice cempId;
    
    UpdateTeacher(){
        setSize(900,650);
        setLocation(350,50);
        
        setLayout(null);
        
        JLabel heading =new JLabel("Update Teacher Details");
        heading.setBounds(50,10,500,50);
        heading.setFont(new Font("Tahoma",Font.ITALIC,35));
        add(heading);
        
        JLabel lbrollnumber=new JLabel("Select Employee Number");
        lbrollnumber.setBounds(50,100,200,20);
        lbrollnumber.setFont(new Font("Serif",Font.PLAIN,20));
        add(lbrollnumber);
        
        cempId =new Choice();
        cempId.setBounds(250,100,200,20);
        add(cempId);
        
        try{
            
            Conn c = new Conn();//for create connection.
            ResultSet rs=c.s.executeQuery("select * from teacher");//for storing result of query .
            while(rs.next()){
                cempId.add(rs.getString("emp_Id"));
                
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        JLabel lbname=new JLabel("Name");
        lbname.setBounds(50,150,100,30);
        lbname.setFont(new Font("serif",Font.BOLD ,20));
        add(lbname);
        
        JLabel labelname=new JLabel();
        labelname.setBounds(200,150,150,30);
        labelname.setFont(new Font("Tahoma",Font.PLAIN ,18));
        add(labelname); 
        
        JLabel lbfname=new JLabel("Father's Name");
        lbfname.setBounds(400,150,200,30);
        lbfname.setFont(new Font("serif",Font.BOLD ,20));
        add(lbfname);
        
        JLabel labelfname=new JLabel();
        labelfname.setBounds(600,150,150,30);
        labelfname.setFont(new Font("Tahoma",Font.PLAIN ,18));
        add(labelfname);
        
        JLabel lbrollno =new JLabel("Employee Id");
        lbrollno.setBounds(50,200,200,30);
        lbrollno.setFont(new Font("serif",Font.BOLD ,20));
        add(lbrollno);
        
        labelempId=new JLabel();
        labelempId.setBounds(200,200,200,30);
        labelempId.setFont(new Font("Tahoma",Font.PLAIN ,18));
        add(labelempId);
        
        JLabel lbdob=new JLabel("Date Of Birth");
        lbdob.setBounds(400,200,200,30);
        lbdob.setFont(new Font("serif",Font.BOLD,20));
        add(lbdob);
                
        JLabel labeldob=new JLabel();
        labeldob.setBounds(600,200,150,30);
        labeldob.setFont(new Font("Tahoma",Font.PLAIN ,18));
        add(labeldob);
        
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
        
        JLabel labelx=new JLabel();
        labelx.setBounds(600,300,150,30);
        labelx.setFont(new Font("Tahoma",Font.PLAIN ,18));
        add(labelx);
        
        JLabel lblxII=new JLabel("Class XII (%)");
        lblxII.setBounds(50,350,200,30);
        lblxII.setFont(new Font("serif",Font.BOLD ,20));
        add(lblxII);
        
        JLabel labelxII=new JLabel();
        labelxII.setBounds(200,350,150,30);
        labelxII.setFont(new Font("Tahoma",Font.PLAIN ,18));
        add(labelxII);
        
        JLabel lblaadhar=new JLabel("Aadhar Number");
        lblaadhar.setBounds(400,350,200,30);
        lblaadhar.setFont(new Font("serif",Font.BOLD ,20));
        add(lblaadhar);
        
        JLabel labelaadhar=new JLabel();
        labelaadhar.setBounds(600,350,150,30);
        labelaadhar.setFont(new Font("Tahoma",Font.PLAIN ,18));
        add(labelaadhar);
        
        JLabel lblcourse=new JLabel("Education");
        lblcourse.setBounds(50,400,200,30);
        lblcourse.setFont(new Font("serif",Font.BOLD ,20));
        add(lblcourse);
        
       
        tfcourse=new JTextField();
        tfcourse.setBounds(200,400,150,30);
        add(tfcourse);
        
        JLabel lblbranch=new JLabel("Department");
        lblbranch.setBounds(400,400,200,30);
        lblbranch.setFont(new Font("serif",Font.BOLD ,20));
        add(lblbranch);
        
        
        tfbranch=new JTextField();
        tfbranch.setBounds(600,400,150,30);
        add(tfbranch);
        
        try{
            Conn c=new Conn();
            String query="select * from teacher where emp_Id='"+cempId.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
                labeldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                labelx.setText(rs.getString("class_x"));
                labelxII.setText(rs.getString("class_xii"));
                labelaadhar.setText(rs.getString("aadhar"));
                labelempId.setText(rs.getString("emp_Id"));
                tfcourse.setText(rs.getString("education"));
                tfbranch.setText(rs.getString("department"));
                
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        cempId.addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent ie){
          
            
        try{
            Conn c=new Conn();
            String query="select * from teacher where emp_Id='"+cempId.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
                labeldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                labelx.setText(rs.getString("class_x"));
                labelxII.setText(rs.getString("class_xii"));
                labelaadhar.setText(rs.getString("aadhar"));
                labelempId.setText(rs.getString("emp_Id"));
                tfcourse.setText(rs.getString("education"));
                tfbranch.setText(rs.getString("department"));
                
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
}
    });
        
        submit =new JButton("Update");
        submit.setBounds(250, 500, 120, 30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma",Font.BOLD,16));
        add(submit);
        
        cancel =new JButton("Cancel");
        cancel.setBounds(450, 500, 120, 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,16));
        add(cancel);
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == submit){
            
            String empId=labelempId.getText();
            String address=tfaddress.getText();
            String phone=tfphone.getText();
            String email=tfemail.getText();
            String course=tfcourse.getText();
            String branch=tfbranch.getText();
            
            try{
                
                String query="update teacher set address='"+address+"',phone='"+phone+"',email='"+email+"',education='"+course+"',department='"+branch+"'where emp_Id='"+empId+"'";
                Conn con=new Conn();
                con.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"teacher Details Updated Successfully");
                setVisible(false);
                
            }catch(Exception ex){
                ex.printStackTrace();
              //  System.out.println(ex);
            }
            
        }
        else {
            setVisible(false);
        }
    }
    
    public static void  main(String []args){
         
        new UpdateTeacher();
    }
}
