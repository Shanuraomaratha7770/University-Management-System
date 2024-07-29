
package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener {
    
    Project(){
       setSize(1540,820);
       
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2=i1.getImage().getScaledInstance(1500, 750, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        JMenuBar mb=new JMenuBar();
        
        //information .
        
        JMenu newInformation =new JMenu("New Information");
        newInformation.setForeground(Color.blue);
        mb.add(newInformation);
        
        JMenuItem facultyInfo =new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.white);
        facultyInfo.addActionListener(this);
        newInformation.add(facultyInfo);
        
        JMenuItem studentInfo =new JMenuItem("New Student Information");
        studentInfo.setBackground(Color.white);
        studentInfo.addActionListener(this);
        newInformation.add(studentInfo);
        
        //details 
        
        JMenu details =new JMenu("View details");
        details.setForeground(Color.red);
        mb.add(details);
        
        JMenuItem facultydetails =new JMenuItem("view Faculty details");
        facultydetails.setBackground(Color.white);
        facultydetails.addActionListener(this);
        details.add(facultydetails);
        
        JMenuItem studentdetails =new JMenuItem("view Student details");
        studentdetails.setBackground(Color.white);
        studentdetails.addActionListener(this);
        details.add(studentdetails);
        
        
        //leave.
         
        JMenu leave =new JMenu("Apply Leave");
        leave.setForeground(Color.blue);
        mb.add(leave);
        
        JMenuItem facultyLeave =new JMenuItem("Faculty leave");
        facultyLeave.setBackground(Color.white);
        facultyLeave.addActionListener(this);
        leave.add(facultyLeave);
        
        JMenuItem studentLeave =new JMenuItem("Student leave");
        studentLeave.setBackground(Color.white);
        studentLeave.addActionListener(this);
        leave.add(studentLeave);
        
         //leave details.
         
        JMenu leaveDetails=new JMenu("Leave Details");
        leaveDetails.setForeground(Color.red);
        mb.add(leaveDetails);
        
        JMenuItem facultyLeavedetails =new JMenuItem("Faculty leave details");
        facultyLeavedetails.setBackground(Color.white);
        facultyLeavedetails.addActionListener(this);
        leaveDetails.add(facultyLeavedetails);
        
        
        JMenuItem studentLeavedetails =new JMenuItem("Student leave details");
        studentLeavedetails.setBackground(Color.white);
        studentLeavedetails.addActionListener(this);
        leaveDetails.add(studentLeavedetails);
        
        
         //Exam .
         
        JMenu exam=new JMenu("Examination");
        exam.setForeground(Color.blue);
        mb.add(exam);
        
        JMenuItem examinationdetails =new JMenuItem("Examination Results");
        examinationdetails.setBackground(Color.white);
        examinationdetails.addActionListener(this);
        exam.add(examinationdetails);
        
        JMenuItem enterMarks =new JMenuItem("Enter Marks");
        enterMarks.setBackground(Color.white);
        enterMarks.addActionListener(this);
        exam.add(enterMarks);
        
        //Update Information.
         
        JMenu updateInfo=new JMenu("Update Details");
        updateInfo.setForeground(Color.red);
        mb.add(updateInfo);
        
        JMenuItem updatefacultyinfo =new JMenuItem("Update Faculty Details");
        updatefacultyinfo.setBackground(Color.white);
        updatefacultyinfo.addActionListener(this);
        updateInfo.add(updatefacultyinfo);
        
        JMenuItem updatestudentinfo =new JMenuItem("Update Student Details");
        updatestudentinfo.setBackground(Color.white);
        updatestudentinfo.addActionListener(this);
        updateInfo.add(updatestudentinfo);
        
         //fee .
         
        JMenu fee=new JMenu("Fee Details");
        fee.setForeground(Color.blue);
        mb.add(fee);
        
        JMenuItem feestructure =new JMenuItem("Fee Structure");
        feestructure.setBackground(Color.white);
        feestructure.addActionListener(this);
        fee.add(feestructure);
        
        JMenuItem feeform =new JMenuItem("Student Fee Form");
        feeform.setBackground(Color.white);
        feeform.addActionListener(this);
        fee.add(feeform);
        
        //utility .
        
        JMenu utility=new JMenu("Utility");
        utility.setForeground(Color.red);
        mb.add(utility);
        
        JMenuItem notepad=new JMenuItem("NotePad");
        notepad.setBackground(Color.white);
        notepad.addActionListener(this);
        utility.add(notepad);
        
        JMenuItem calc=new JMenuItem("Calculator");
        calc.setBackground(Color.white);
        calc.addActionListener(this);
        utility.add(calc);
        
        //About .
        
        JMenu about=new JMenu("About");
        about.setForeground(Color.blue);
        mb.add(about);
        
        JMenuItem ab=new JMenuItem("About");
        ab.setBackground(Color.white);
        ab.addActionListener(this);
        about.add(ab);
        
        //Exit.
        
        JMenu exit=new JMenu("Exit");
        exit.setForeground(Color.red);
        mb.add(exit);
        
        JMenuItem ex=new JMenuItem("Exit");
        ex.setBackground(Color.white);
        ex.addActionListener(this);
        exit.add(ex);
      
        setJMenuBar(mb);
                
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String msg=ae.getActionCommand(); //return string 
        if(msg.equals("Exit")){
            setVisible(false);
        }
        else if(msg.equals("Calculator")){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else if(msg.equals("NotePad")){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else if(msg.equals("New Faculty Information")){
            new AddTeacher();
        }
        else if(msg.equals("New Student Information")){
            new AddStudent();
        }
        else if(msg.equals("view Faculty details")){
            new TeacherDetails();
        }
        else if(msg.equals("view Student details")){
            new StudentDetails();
        }
        
        else if(msg.equals("Faculty leave")){
            new TeacherLeave();
        }
        else if(msg.equals("Student leave")){
            new StudentLeave();
        }
        
        else if(msg.equals("Faculty leave details")){
            new TeacherLeaveDetails();
        }
        else if(msg.equals("Student leave details")){
            new StudentLeaveDetails();
        }
        
        else if(msg.equals("Update Faculty Details")){
            new UpdateTeacher();
        }
        else if(msg.equals("Update Student Details")){
            new UpdateStudent();
        }
        else if(msg.equals("Enter Marks")){
            new EnterMarks();
        }
        else if(msg.equals("Examination Results")){
            new ExaminationDetails();
        }
        else if(msg.equals("Fee Structure")){
            new FeeStructure();
        }
         else if(msg.equals("About")){
            new About();
        }
         else if(msg.equals("Student Fee Form")){
            new StudentFeeForm();
        }
       }
    
    
    public static void main(String args[]){
        new Project();
    }
}
