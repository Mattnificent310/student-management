/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.management.app;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author matt.maree
 */
public class DataAccessLayer {
    public Connection Connect(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
        } catch (Exception ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    } 
    public List<Student> GetStudent() throws SQLException{
        List<Student> studentList = new ArrayList<>();
        Statement st = Connect().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM Students");
        while(rs.next()){
            studentList.add(new Student(rs.getInt(0),
                                        rs.getString(1), 
                                        rs.getString(2), 
                                        rs.getString(3),
                                        rs.getString(4),
                                        rs.getString(5), 
                                        rs.getString(6)));
        }
        return studentList;
    }
public List<Lecturer> GetLecturers() throws SQLException{
        List<Lecturer> lecturerList = new ArrayList<>();
        Statement st = Connect().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM Lecturers");
        while(rs.next()){
            lecturerList.add(new Lecturer(rs.getInt(0),
                                        rs.getString(1), 
                                        rs.getString(2), 
                                        rs.getString(3),
                                        rs.getString(4),
                                        rs.getString(5), 
                                        rs.getString(6)));
        }
        return lecturerList;
    }
    public List<Subject> GetSubjects() throws SQLException{
        List<Subject> subjectList = new ArrayList<>();
        Statement st = Connect().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM Subjects");
        while(rs.next()){
            subjectList.add(new Subject(rs.getInt(0),
                                        rs.getString(1), 
                                        rs.getInt(2),
                                        rs.getInt(3)));
        }
        return subjectList;
    }
    
     public Student insertStudent(Student student) throws SQLException{
         String sql = "INSERT INTO Students (StudentName, StudentSurname, StudentAge, StudentGender, StudentPhone, StudentEmail) VALUES (?, ?, ?, ?, ?, ?)";
         String lastRow = "SELECT TOP 1 FROM Students ORDER BY DESC";
         PreparedStatement ps = Connect().prepareStatement(sql);
         ps.setString(0, student.getName());
         ps.setString(1, student.getSurname());
         ps.setString(2, student.getBirthDate());
         ps.setString(3, student.getGender());
         ps.setString(4, student.getPhone());
         ps.setString(5, student.getEmail());
         ps.executeUpdate();
         ResultSet rs = ps.executeQuery(lastRow);
         return new Student(rs.getInt(0),rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
         
     }
     
     public Lecturer insertLecturer(Lecturer lecturer) throws SQLException{
         String sql = "INSERT INTO Lecturers (LecturerName, LecturerSurname, LecturerAge, LecturerGender, LecturerPhone, LecturerEmail) VALUES (?, ?, ?, ?, ?, ?)";
         String lastRow = "SELECT TOP 1 FROM Lecturers ORDER BY DESC";
         PreparedStatement ps = Connect().prepareStatement(sql);
         ps.setString(0, lecturer.getName());
         ps.setString(1, lecturer.getSurname());
         ps.setString(2, lecturer.getBirthDate());
         ps.setString(3, lecturer.getGender());
         ps.setString(4, lecturer.getPhone());
         ps.setString(5, lecturer.getEmail());
         ps.executeUpdate();
         ResultSet rs = ps.executeQuery(lastRow);
         return new Lecturer(rs.getInt(0),rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
         
     }
     
     public Subject insertSubject(Subject subject) throws SQLException{
         String sql = "INSERT INTO Subjects (SubjectTitle, SubjectWeigt, SubjectDuration) VALUES (?, ?, ?)";
         String lastRow = "SELECT TOP 1 FROM Subjects ORDER BY DESC";
         PreparedStatement ps = Connect().prepareStatement(sql);
         ps.setString(0, subject.getName());
         ps.setInt(1, subject.getWeight());
         ps.setInt(2, subject.getDuration());
         ps.executeUpdate();
         ResultSet rs = ps.executeQuery(lastRow);
         return new Subject(rs.getInt(0),rs.getString(1), rs.getInt(2),rs.getInt(3));
         
     }
     public boolean updateStudent(Student student) throws SQLException{
         String sql = "UPDATE Students SET StudentName = ?, StudentSurname = ?, StudentAge = ?, StudentGender = ?, StudentPhone = ?, StudentEmail = ?";
         PreparedStatement ps = Connect().prepareStatement(sql);
         ps.setString(0, student.getName());
         ps.setString(1, student.getSurname());
         ps.setString(2, student.getBirthDate());
         ps.setString(3, student.getGender());
         ps.setString(4, student.getPhone());
         ps.setString(5, student.getEmail());
         return ps.executeUpdate() > 0;
         
     }
     public boolean updateLecturer(Lecturer lecturer) throws SQLException{
         String sql = "UPDATE Lecturers SET LecturerName = ?, LecturerSurname = ?, LecturerAge = ?, LecturerGender = ?, LecturerPhone = ?, LecturerEmail = ?";
         PreparedStatement ps = Connect().prepareStatement(sql);
         ps.setString(0, lecturer.getName());
         ps.setString(1, lecturer.getSurname());
         ps.setString(2, lecturer.getBirthDate());
         ps.setString(3, lecturer.getGender());
         ps.setString(4, lecturer.getPhone());
         ps.setString(5, lecturer.getEmail());
         return ps.executeUpdate() > 0;
         
     }
}
