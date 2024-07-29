
package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentFeeForm extends JFrame implements ActionListener{
    
    Choice crollno;
    JComboBox cbcourse,cbbranch,cbsemester;
    JLabel labeltotal;
    JButton update,pay,back;
    
    StudentFeeForm(){
        
        setSize(900,500);
        setLocation(300,100);
        setLayout(null);
        
        getContentPane().setBackground(Color.white);
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
        Image i2=i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,500,300);
        add(image);
        
        JLabel lbrollnumber=new JLabel("Select roll No");
        lbrollnumber.setBounds(40,60,150,20);
        lbrollnumber.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lbrollnumber);
        
        crollno =new Choice();
        crollno.setBounds(200,60,150,20);
        add(crollno);
        
        try{
            
            Conn c = new Conn();//for create connection.
            ResultSet rs=c.s.executeQuery("select * from student");//for storing result of query .
            while(rs.next()){
                crollno.add(rs.getString("rollno"));
                
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        
        JLabel lbname=new JLabel("Name");
        lbname.setBounds(40,100,150,20);
        lbname.setFont(new Font("Tahoma",Font.BOLD ,16));
        add(lbname);
        
        JLabel labelname=new JLabel();
        labelname.setBounds(200,100,150,20);
        labelname.setFont(new Font("Tahoma",Font.PLAIN ,16));
        add(labelname); 
        
        JLabel lbfname=new JLabel("Father's Name");
        lbfname.setBounds(40,140,150,20);
        lbfname.setFont(new Font("Tahoma",Font.BOLD ,16));
        add(lbfname);
        
        JLabel labelfname=new JLabel();
        labelfname.setBounds(200,140,150,20);
        labelfname.setFont(new Font("Tahoma",Font.PLAIN ,16));
        add(labelfname);
        
        try{
            Conn c=new Conn();
            String query="select * from student where rollno='"+crollno.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));       
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        crollno.addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent ie){
          
            
             try{
            Conn c=new Conn();
            String query="select * from student where rollno='"+crollno.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
                
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
}
    });
        
        JLabel lblcourse=new JLabel("Course");
        lblcourse.setBounds(40,180,150,20);
        lblcourse.setFont(new Font("Tahoma",Font.BOLD ,16));
        add(lblcourse);
        
        String course[]={"BTech","BBA","BCA","MCA","BA","MCom","MBA","Bsc"};
        cbcourse=new JComboBox(course);
        cbcourse.setBounds(200,180,150,20);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);
        
        JLabel lblbranch=new JLabel("Branch");
        lblbranch.setBounds(40,220,150,20);
        lblbranch.setFont(new Font("Tahoma",Font.BOLD ,20));
        add(lblbranch);
        
        String branch[]={"Compute Science","civil","IT","Mechanical","DSA","AIML"};
        cbbranch=new JComboBox(branch);
        cbbranch.setBounds(200,220,150,20);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);
        
        
        JLabel lblsemester=new JLabel("Semester");
        lblsemester.setBounds(40,260,150,20);
        lblsemester.setFont(new Font("Tahoma",Font.BOLD ,16));
        add(lblsemester);
        
        String semester[]={"semester1","semester2","semester3","semester4","semester5","semester6","semester7","semester8"};
        cbsemester=new JComboBox(semester);
        cbsemester.setBounds(200,260,150,20);
        cbsemester.setBackground(Color.white);
        add(cbsemester);
        
        
         
        JLabel lbltotal=new JLabel("Total Payable");
        lbltotal.setBounds(40, 300, 150, 20);
        lbltotal.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lbltotal);
        
        labeltotal=new JLabel();
        labeltotal.setBounds(200, 300, 150, 20);
        labeltotal.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labeltotal);
        
        update =new JButton("Update");
        update.setBounds(30, 380, 100, 25);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.addActionListener(this);
      //  update.setFont(new Font("Tahoma",Font.BOLD,16));
        add(update);
        
        pay =new JButton("Pay");
        pay.setBounds(150, 380, 100, 25);
        pay.setBackground(Color.black);
        pay.setForeground(Color.white);
        pay.addActionListener(this);
        pay.setFont(new Font("Tahoma",Font.BOLD,16));
        add(pay);
        
        back =new JButton("Back");
        back.setBounds(270, 380, 120, 25);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setFont(new Font("Tahoma",Font.BOLD,16));
        add(back);
        
        
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==update){
            
            String course = (String)cbcourse.getSelectedItem();
            String semester=(String)cbsemester.getSelectedItem();
            try{
                Conn c= new Conn();
                ResultSet rs=c.s.executeQuery("select * from fee where course = '"+course+"'");
                while(rs.next()){
                    labeltotal.setText(rs.getString(semester));
                    
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            
            
        }else if(ae.getSource()==pay){
           String rollno=crollno.getSelectedItem();
           String course = (String)cbcourse.getSelectedItem();
           String semester=(String)cbsemester.getSelectedItem();
           String branch=(String)cbbranch.getSelectedItem();
           String total=labeltotal.getText();
           
           try{
                Conn c= new Conn();
                String query="insert into collegefee values('"+rollno+"','"+course+"','"+branch+"','"+semester+"','"+total+"')";
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "College Fee submitted successfully");
                
             
            }catch(Exception e){
                e.printStackTrace();
            }
            
            
        }else {
            setVisible(false);
        }
    }
    
    public static void main(String []args){
        new StudentFeeForm();
    }
}