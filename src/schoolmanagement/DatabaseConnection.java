/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagement;

import com.mysql.cj.xdevapi.PreparableStatement;
import java.io.Console;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.layout.Pane;
import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;
import javafx.util.Callback;
import javax.swing.text.TableView;
import schoolmanagement.mylibs.CustomControl;
import schoolmanagement.Administrator.user;

/**
 *
 * @author Group Team
 */

public class DatabaseConnection {
    Connection connection;
    public Connection getConnection(){
        String dbName="cs_db";
        String userName="root";
        String password="root";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName,userName,password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return connection;
    }
    
    //Signin
    public String Signin(String Username, String Password, String Role){
        String UserID = "";
        String _role = null;
        
        if(Role.equals("Student")){
            _role = "student_information";
            
        }else if(Role.equals("Staff")) {
            _role = "staff_information";
        }else if(Role.equals("Administrator")) {
            _role = "administrator";
        }

        String password = "";
        Statement stm;
        Connection con = getConnection();
        
        String query = "SELECT password,id FROM "+_role+" WHERE username = '"+Username+"'";
        try {
            stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                password = rs.getString("password");
                if(password.equals(Password)){
                    UserID = rs.getString("id");
                }else {
                    UserID = "";
                }
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return UserID;
    }
    // Load Basic Information
    public ArrayList<String> LoadUserBasicInformation(String UserID, String Role){
        ArrayList<String> user_information = new ArrayList<String>();
        String _role = null;

        
        if(Role.equals("Student")){
            _role = "student_information";
            
        }else if(Role.equals("Staff")) {
            _role = "staff_information";
        }else if(Role.equals("Administrator")) {
            _role = "administrator";
        }
        
        Connection con = getConnection();
        
        String SQL = "SELECT firstname,lastname FROM "+_role+" WHERE id = '"+UserID+"'";
        
        Statement statement;
        
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            
            while (rs.next()) {
                user_information.add(rs.getString("firstname"));
                user_information.add(rs.getString("lastname"));
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user_information;
        
    }
    
    
    // Load Full Information
    public ArrayList<String> LoadUserFullInformation(String UserID, String Role){
        ArrayList<String> user_information = new ArrayList<>();
        String _role = null;
        
        if(Role.equals("Student")){
            _role = "student_information";
            
        }else if(Role.equals("Staff")) {
            _role = "staff_information";
        }else if(Role.equals("Administrator")) {
            _role = "administrator";
        }
        
        Connection con = getConnection();
        
        //String SQL = "SELECT * FROM "+_role+" WHERE id = '"+UserID+"'";
        
        String SQL = "SELECT * FROM "+_role + " WHERE id = '"+UserID+"'";
        
        Statement statement;
        
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            
            while (rs.next()) {
                user_information.add(rs.getString("id")); // id
                user_information.add(rs.getString("firstname")); // firstname
                user_information.add(rs.getString("lastname")); // lastname
                user_information.add(rs.getString("email")); // email
                user_information.add(rs.getString("phone")); // phone
                user_information.add(rs.getString("street")); // street
                user_information.add(rs.getString("city")); // city
                user_information.add(rs.getString("state")); // state
                user_information.add(rs.getString("zip")); // zip
                user_information.add(rs.getString("birthday")); // birthday
                if(Role.equals("Student")){
                    user_information.add(rs.getString("degree")); // birthday
                    user_information.add(rs.getString("subject")); // birthday
                }
            }
           
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user_information;
        
    }
    // Update Student Information
    public void UpdateUserInformation(String UserID, String Role, String phone, String street, String city, String State, int zip){
        Connection con = getConnection();
        
        String _role = "";
        if(Role.equals("Student")){
            _role = "student_information";
        }else if(Role.equals("Staff")){
            _role = "staff_information";
        }
        
        String SQL = "UPDATE "+_role+" set phone = "+phone+", street = '"+street+"', city = '"+city+"', state = '"+State+"', zip = '"+zip+"' WHERE id = '"+UserID+"'";
        
        Statement statement;
        try {
            statement = con.createStatement();
            statement.executeUpdate(SQL);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Change Student Password
    public Boolean ChangeUserPassword(String UserID, String Role,String CurrentPassword, String NewPassword){
        Connection con = getConnection();
        String _role = "";
        String _currentPassword = "";
        Boolean equal = false;
        if(Role.equals("Student")){
            _role = "Student_information";
        }else if(Role.equals("Staff")){
            _role = "Staff_information";
        }       
        
        // get current password
        String SQL = "SELECT password FROM "+_role+" WHERE id = '"+UserID+"'";
        
        Statement statement;
        
        try{
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            
            while(rs.next()){
                _currentPassword = rs.getString("password");
            }
                    
        }catch(SQLException ex){
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        //check password to user current password
        if(_currentPassword.equals(CurrentPassword)){
            equal =true;
        }
        // Update New Password
        if(equal == true){
            String USQL = "UPDATE "+_role+"  SET password = '"+NewPassword+"' WHERE id = '"+UserID+"'";
            
            Statement Ustatement;
            
            try{      
                Ustatement = con.createStatement();
                Ustatement.executeUpdate(USQL);
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
        
        return equal;
    }
    // Administrator Role---------------------------------------------------------------
    
    // Load Current 
    
    // Count Total Student
    public Integer CountTotalUser(String table_name){
        int totaluser = 0;
        
        Connection con = getConnection();
        
        String SQL = "SELECT count(*) FROM "+table_name;
        
        Statement statement;
        
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            
            while(rs.next()){
                totaluser = rs.getInt("count(*)");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return totaluser;
    }
    
    // Create Student Account
    public void CreateStudentAccount(String FirstName, String LastName, String PhoneNumber, String Address, String City, String State, String Zip,LocalDate Birthday, String degree, String Major){
        Calendar cal = Calendar.getInstance(TimeZone.getDefault());
        Date date = cal.getTime();
        String ID = (Birthday.getYear()+"").charAt(2) + "" + + (Birthday.getYear()+"").charAt(3)+ (cal.get(Calendar.DAY_OF_MONTH))+cal.get(Calendar.MINUTE)+cal.get(Calendar.SECOND);
        
        int BirthYear = Birthday.getYear();
        int BirthDate = Birthday.getDayOfMonth();
        char DateNo = 0;
        if(BirthDate > 9){
            DateNo = (BirthDate+"").charAt(1);
        }else{
            DateNo = (BirthDate+"").charAt(0);
        }
        Connection con = getConnection();
        
        String query = 
                "INSERT INTO student_information" +
                "(id,username,firstname,lastname,password,email,phone,street,city,state,zip,birthday,subject,degree)" +
                "VALUES" +
                "('"+ID+"','"+LastName.toLowerCase()+FirstName.toLowerCase().charAt(0)+DateNo+"','"+FirstName+"','"+LastName+"','"+FirstName.toLowerCase()+LastName.toLowerCase()+ BirthYear +"','"+LastName.toLowerCase()+FirstName.toLowerCase().charAt(0)+DateNo+"@gator.uhd.edu','"+PhoneNumber+"','"+Address+"','"+City+"','"+State+"','"+Zip+"','"+Birthday+"','"+degree+"','"+Major+"')";
        
        Statement statement;
        try {
            statement = con.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    // Get Degree List
    public ArrayList<String> GetDegreeList(){
        ArrayList<String> list = new ArrayList<>();
        
        Connection con = getConnection();
        
        String SQL = "SELECT name FROM degree ";
        
        try {
            ResultSet rs = con.createStatement().executeQuery(SQL);
            while(rs.next()){
                list.add(rs.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    
    // Get Major List
    public ArrayList<String> GetMajorList(){
        ArrayList<String> list = new ArrayList<>();
        
        Connection con = getConnection();
        
        String SQL = "SELECT subject_name FROM course_subject";
        
        try {
            ResultSet rs = con.createStatement().executeQuery(SQL);
            while(rs.next()){
                list.add(rs.getString("subject_name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    
    // Create Professor Account
    public void CreateProfessorAccount(String FirstName, String LastName, String PhoneNumber, String Address, String City, String State, String Zip,LocalDate Birthday, Integer salary ){
        Calendar cal = Calendar.getInstance(TimeZone.getDefault());
        Date date = cal.getTime();
        String ID = (Birthday.getYear()+"").charAt(2) + "" + + (Birthday.getYear()+"").charAt(3)+ (cal.get(Calendar.DAY_OF_MONTH))+cal.get(Calendar.MINUTE)+cal.get(Calendar.SECOND);
        
        int BirthYear = Birthday.getYear();
        int BirthDate = Birthday.getDayOfMonth();
        char DateNo = 0;
        if(BirthDate > 9){
            DateNo = (BirthDate+"").charAt(1);
        }else{
            DateNo = (BirthDate+"").charAt(0);
        }
        Connection con = getConnection();
        
        
        String query = 
                "INSERT INTO staff_information" +
                "(id,username,firstname,lastname,password,email,phone,street,city,state,zip,birthday,job_id,salary)" +
                "VALUES" +
                "('"+ID+"','"+LastName.toLowerCase()+FirstName.toLowerCase().charAt(0)+DateNo+"','"+FirstName+"','"+LastName+"','"+FirstName.toLowerCase()+LastName.toLowerCase()+ BirthYear +"','"+LastName.toLowerCase()+FirstName.toLowerCase().charAt(0)+DateNo+"@uhd.edu','"+PhoneNumber+"','"+Address+"','"+City+"','"+State+"','"+Zip+"','"+Birthday+"',1,"+salary+")";
        
        Statement statement;
        try {
            statement = con.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    // Professor: Load all teaching courses
    public ArrayList<ArrayList<String>> ProfessorLoadTeachingCourses(String UserID)
    {
        CustomControl cc = new CustomControl();
        ArrayList<ArrayList<String>> list = cc.ctm_ArrayList(8);
        
        Connection con = getConnection();
        
        String SQL= "SELECT cr.course_record_id, cl.subject_id, cl.course_number, cl.course_name, cr.meeting_start, cr.meeting_end, cr.meeting_day1, cr.meeting_day2\n" +
                    "FROM course_record cr\n" +
                    "LEFT JOIN course_list cl ON cr.course_id = cl.course_id\n" +
                    "LEFT JOIN semester_term st ON cr.semester_id = st.term_id\n" +
                    "WHERE cr.staff_id = '"+UserID+"' AND st.term_current = '1'";
        
        Statement statement = null;
        
        try {
            statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(SQL);
            
            while(rs.next()){
                list.get(0).add(rs.getString("cr.course_record_id"));
                list.get(1).add(rs.getString("cl.subject_id"));
                list.get(2).add(rs.getString("cl.course_number"));
                list.get(3).add(rs.getString("cl.course_name"));
                list.get(4).add(rs.getString("cr.meeting_start"));
                list.get(5).add(rs.getString("cr.meeting_end"));
                list.get(6).add(rs.getString("cr.meeting_day1"));
                list.get(7).add(rs.getString("cr.meeting_day2"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
        
    }
    
    
    
    public ArrayList<ArrayList<String>> LoadAllUser(String UserRole){
        CustomControl cc = new CustomControl();
        ArrayList<ArrayList<String>> list = cc.ctm_ArrayList(7);

        String table = "";
        if(UserRole.equals("Student")){
            table = "student_information";
        }else if(UserRole.equals("Staff")){
            table = "staff_information";
        }
        
        Connection con = getConnection();
        String sql = "SELECT id, firstname, lastname, phone, email, birthday, street, city,state, zip FROM "+table;

        Statement statement = null;
        
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                list.get(0).add(rs.getString("id"));
                list.get(1).add(rs.getString("firstname"));
                list.get(2).add(rs.getString("lastname"));
                list.get(3).add(rs.getString("phone"));
                list.get(4).add(rs.getString("email"));
                list.get(5).add(rs.getString("birthday"));
                list.get(6).add(rs.getString("street") + ", " + rs.getString("city") + " " + rs.getString("state")+ ", " + rs.getString("zip"));
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;

    }
    
    // Load All Subject
    public ArrayList<ArrayList<String>> LoadAllSubject(){
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        ArrayList<String> id = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        Connection con = getConnection();
        String SQL = "SELECT * FROM course_subject";
        
        Statement statement;
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            
            while(rs.next()){
                id.add(rs.getString("subject_id"));
                name.add(rs.getString("subject_name"));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        list.add(id);
        list.add(name);
        
        return list; 
    }
    // Load All School Location
    public ArrayList<ArrayList<String>> LoadAllSchoolLocation(){
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        ArrayList<String> id = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        
        Connection con = getConnection();
        String SQL = "SELECT * FROM school_location";
        
        Statement statement;
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            
            while(rs.next()){
                id.add(rs.getString("location_id"));
                name.add(rs.getString("location_name"));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        list.add(id);
        list.add(name);
        
        return list; 
    }
    
    // Instructor Controller ----------------------------------------------
    // Load Anoucements
    // Load Annoucements
    public ArrayList<ArrayList<String>> ProLoadAnnoucements(String user_ID){
        Connection con = getConnection();
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        CustomControl cc = new CustomControl();
        list = cc.ctm_ArrayList(7);
        
        
        String SQL = "SELECT a.annouce_id, cl.subject_id, cl.course_number, cl.course_name, a.annouce_title, a.annouce_content, a.post_time  \n" +
                    "FROM annoucement a\n" +
                    "LEFT JOIN course_record cr ON a.course_id = cr.course_record_id\n" +
                    "LEFT JOIN course_list cl ON cr.course_id = cl.course_id\n" +
                    "LEFT JOIN semester_term st ON cr.semester_id = st.term_id\n" +
                    "WHERE cr.staff_id = '"+user_ID+"' AND st.term_current = '1'" + 
                    "ORDER BY a.post_time DESC";
        
        Statement statement = null;
        
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            ResultSetMetaData rsmd = rs.getMetaData();
            while(rs.next()){
                for(int i = 0; i < rsmd.getColumnCount(); i++){
                    list.get(i).add(rs.getString(i+1));
                    System.out.println("Data " +rs.getString(i+1));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    // Get All Student Id from course
    public ArrayList<String> ProfessorGetAllStudentID(String CourseID){
        Connection con = getConnection();
        
        CustomControl cc = new CustomControl();
        ArrayList<String> list = new ArrayList<>();
        
        String SQL = "SELECT student_id\n" +
                    "FROM student_course_record scr\n" +
                    "WHERE current_course_id = '"+CourseID+"'";
        
        Statement statement = null;
        
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            while(rs.next()){
                list.add(rs.getString("student_id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Student List: " + list);
        return list;
    }
    // Add Annoucement
    public void ProfessorAddNewAnnoucement(String StudentID, String CourseID, String AnnouceTitle, String AnnouceContent){
        Connection con = getConnection();
        
        int _id = (int)(Math.random()*1000000);
        
        
        String SQL = "INSERT INTO annoucement\n" +
                    "(annouce_id,student_id,course_id,annouce_title,annouce_content,post_time,annoucement.read)\n" +
                    "VALUES\n" +
                    "('"+_id+""+"','"+StudentID+"','"+CourseID+"','"+AnnouceTitle+"','"+AnnouceContent+"',now(),'0')";
        
        Statement statement = null;
        
        try {
            statement = con.createStatement();
            statement.executeUpdate(SQL);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    // Add Homework
    public void ProfessorAddNewHomework(ArrayList<String> StudentID, String CourseID, String Worktype, String Title, String Instruction, String Percentage, LocalDate duedate){
        Connection con = getConnection();
        
        int _id = (int)(Math.random()*1000000);
        
        String type_id = "";
        if(Worktype.equals("Homework")){
            type_id = "684351";
        }else if(Worktype.equals("Quiz")){
            type_id = "315486";
        }else if(Worktype.equals("Exam")){
            type_id = "158635";
        }
        
        
        String SQL = "INSERT INTO student_work\n" +
                    "(work_id,course_id,work_type_id,work_title,work_description,percentage,time_due)\n" +
                    "VALUES\n" +
                    "('"+_id+"','"+CourseID+"','"+type_id+"','"+Title+"','"+Instruction+"','"+Percentage+"','"+duedate+"');";
        
        Statement statement = null;
        
        try {
            statement = con.createStatement();
            statement.executeUpdate(SQL);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        } 
        for(int i =0; i< StudentID.size();i++){
            ProfessorAddNewHomeworkRecord(StudentID.get(i), CourseID, _id+"");
        }
    }
    // Add Homework to Student work record
    void ProfessorAddNewHomeworkRecord(String StudentID, String CourseID, String work_id){
        Connection con = getConnection();
        
        int _id = (int)(Math.random()*1000000);
        
        
        String SQL = "INSERT INTO student_work_record\n" +
"                    (student_work_record_id,student_id,course_id,work_id)\n" +
"                    VALUES\n" +
"                    ('"+_id+"','"+StudentID+"','"+CourseID+"','"+work_id+"');";
        
        Statement statement = null;
        
        try {
            statement = con.createStatement();
            statement.executeUpdate(SQL);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    // Load All work 
    public ArrayList<ArrayList<String>> LoadAllwork(String UserID, String Worktype, String CourseID){
        Connection con = getConnection();
        CustomControl cc = new CustomControl();
        ArrayList<ArrayList<String>> list = cc.ctm_ArrayList(5);
        
        Statement statement;

        String type_id = "";
        if(Worktype.equals("Homework")){
            type_id = "684351";
        }else if(Worktype.equals("Quiz")){
            type_id = "315486";
        }else if(Worktype.equals("Exam")){
            type_id = "158635";
        }

        String SQL = "SELECT sw.work_id, sw.work_title, sw.work_description, sw.percentage, sw.time_due\n" +
                    "FROM student_work sw\n" +
                    "LEFT JOIN course_record cr ON sw.course_id = cr.course_record_id\n" +
                    "WHERE cr.staff_id = '"+UserID+"' AND sw.work_type_id = '"+type_id+"' AND sw.course_id = '"+CourseID+"'";
        
        try{
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            
            while(rs.next()){
                list.get(0).add(rs.getString("sw.work_id"));
                list.get(1).add(rs.getString("sw.work_title"));
                list.get(2).add(rs.getString("sw.work_description"));
                list.get(3).add(rs.getString("sw.percentage"));
                list.get(4).add(rs.getString("sw.time_due"));
                
            }
        }catch(SQLException ex){
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
        
    }
    
    // Load All Course
    
    public ArrayList<ArrayList<String>> LoadAllCourse(String Subject_ID){
        Connection con = getConnection();
        Statement statement;

        ArrayList<ArrayList<String>> list = new ArrayList<>();
        ArrayList<String> id = new ArrayList<>();
        ArrayList<String> courseCode = new ArrayList<>();
        ArrayList<String> courseName = new ArrayList<>();

        String SQL = "SELECT * FROM course_list WHERE subject_id = '"+Subject_ID+"'";
        
        try{
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            
            while(rs.next()){
                id.add(rs.getString("course_id"));
                courseCode.add("["+rs.getString("subject_id")+ " " + rs.getString("course_number")+"] " + rs.getString("course_name"));
                courseName.add(rs.getString("course_name"));
                
            }
        }catch(SQLException ex){
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        list.add(id);
        list.add(courseCode);
        list.add(courseName);
        return list;
        
    }
    
    // Load All Sesseion
    
    public ArrayList<ArrayList<String>> LoadAllSession(){
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        ArrayList<String> id = new ArrayList<>();
        ArrayList<String> sessionName = new ArrayList<>();
        
        Connection con = getConnection();
        
        String SQL = "SELECT * FROM course_session";        
        Statement statement;
        
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            
            while(rs.next()){
                id.add(rs.getString("session_id"));
                sessionName.add(rs.getString("session_name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        list.add(id);
        list.add(sessionName);

        return list;
    }
    
    // Load All Mode
    
    public ArrayList<ArrayList<String>> LoadAllMode(){
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        ArrayList<String> id = new ArrayList<>();
        ArrayList<String> modeName = new ArrayList<>();
        
        Connection con = getConnection();
        
        String SQL = "SELECT * FROM course_mode";        
        Statement statement;
        
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            
            while(rs.next()){
                id.add(rs.getString("mode_id"));
                modeName.add(rs.getString("mode_name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        list.add(id);
        list.add(modeName);
        
        return list;
    }
    // Get Current Course ID
    public String CurrentTermID(){
        String _id = "";
        Connection con = getConnection();
        Statement statement;
        String SQL = "SELECT term_id FROM semester_term WHERE term_current = '1'";
        
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            while(rs.next()){
                _id = rs.getString("term_id");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return _id;
        
    }
    // Add New Course
    public void ProAddNewCourse(String Subject_ID, String Course_ID, String MeetingFrom, String MeetingTo, String Day1, String Day2, String Session_ID, String RoomNo, int StudentQty, String Location_ID, String TeachMode_ID, String Professor_ID){
        Connection con = getConnection();
        Statement statement;

        // Gen ID Value
        int current_id = ThreadLocalRandom.current().nextInt(100000, 1000000);
        
        String SQL = "INSERT INTO course_record "
                + "(course_record_id,subject_id, course_id, meeting_start, meeting_end, meeting_day1, meeting_day2, session_id, room, student_max, location_id, mode_id, staff_id, course_status, semester_id) "
                + "VALUES ("+current_id+",'"+Subject_ID+"','"+Course_ID+"','"+MeetingFrom+"','"+MeetingTo+"','"+Day1+"','"+Day2+"','"+Session_ID+"','"+RoomNo+"','"+StudentQty+"','"+Location_ID+"','"+TeachMode_ID+"','"+Professor_ID+"',1, '"+CurrentTermID()+"')";
        
        
        
        try {
            statement = con.createStatement();
            statement.executeUpdate(SQL);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    // Search Current Course

    public ArrayList<ArrayList<String>> getCurrentCourseList(String Subject_name, String Course_no, String Campus, String ClassMode, ArrayList<CheckBox> day, CheckBox _status, boolean loadAll){
        
        ArrayList<ArrayList<String>> ListContainer = new ArrayList<>();
        ArrayList<String> CourseID = new ArrayList<>();
        ArrayList<String> CourseNo = new ArrayList<>();
        ArrayList<String> CourseName = new ArrayList<>();
        ArrayList<String> CourseDesc = new ArrayList<>();
        ArrayList<String> CoursePrere = new ArrayList<>();
        ArrayList<String> CourseCredit = new ArrayList<>();
        ArrayList<String> CourseMeeting = new ArrayList<>();
        ArrayList<String> CourseSession = new ArrayList<>();
        ArrayList<String> CourseRoom = new ArrayList<>();
        ArrayList<String> CourseInstructor = new ArrayList<>();
        ArrayList<String> CourseMode = new ArrayList<>();
        ArrayList<String> CourseStatus = new ArrayList<>();
        
        ArrayList<String> List = new ArrayList<>();
        ArrayList<String> ConditionList = new ArrayList<>();
        ArrayList<String> DayConditionList = new ArrayList<>();
        
        if(loadAll == false){
            List.add("notloadall");
            ConditionList.add(" st.term_current = 1 ");
        }
        
        if(!Subject_name.equals("(All)")){
            List.add(Subject_name);
            ConditionList.add(" cs.subject_name = '"+ Subject_name +"'");
        }
        if(!Course_no.equals("")){
            List.add(Course_no);
            ConditionList.add(" cl.course_number = '"+ Course_no +"'");
        }
        if(!Campus.equals("(All)")){
            List.add(Campus);
            ConditionList.add(" sl.location_name = '"+ Campus +"'");
        }
        if(!ClassMode.equals("(All)")){
            List.add(ClassMode);
            ConditionList.add(" cm.mode_name = '"+ ClassMode +"'");
        }
        
        if(_status.isSelected()){
            List.add(_status.getText().toString());
            ConditionList.add(" cc.course_status = '"+1+"'");
        }
        
        if(day.size() > 0){
            for(int i =0; i < day.size();i++){
                if(day.get(i).isSelected()){
                    
                    List.add(day.get(i).getText().toString());
                    DayConditionList.add(" cc.meeting_day1 = '"+day.get(i).getText().toString()+"' OR cc.meeting_day2 = '"+day.get(i).getText().toString()+"' ");
                }
            }
            
        }
        
        String WHERE = "";
        String _condition = "";
        
        if(List.size() != 0){
            WHERE = "WHERE ";
            
            
            for(int i =0; i< ConditionList.size();i++){
                if(i == 0){
                    _condition +=  ConditionList.get(i);
                }else if(i < ConditionList.size()){
                    _condition += " AND " + ConditionList.get(i);
                }
            }
            
            if(DayConditionList.size() > 0){
                if(ConditionList.size() > 0){
                    _condition += " AND ";
                }
                _condition += "(";
                for(int i =0; i< DayConditionList.size();i++){
                    if(i == 0){
                        _condition +=  DayConditionList.get(i);
                    }else if(i < DayConditionList.size()){
                        _condition += " OR " + DayConditionList.get(i);
                    }
                } 
                _condition += ")";
            }

        }

        Connection con = getConnection();
        
        String SQL = "SELECT cc.course_record_id, cs.subject_id, cl.course_number, cl.course_name, cl.course_credits, cl.course_description, cl.course_prerequisite, cc.meeting_start, cc.meeting_end, cc.meeting_day1, cc.meeting_day2, cc.room, si.firstname, si.lastname, cm.mode_name, csn.session_name, sl.location_name, st.term_name, st.term_year, cc.course_status\n" +
                    "FROM course_record cc\n" +
                    "LEFT JOIN course_subject cs ON cc.subject_id = cs.subject_id\n" +
                    "LEFT JOIN course_list cl ON cc.course_id = cl.course_id\n" +
                    "LEFT JOIN staff_information si ON cc.staff_id = si.id\n" +
                    "LEFT JOIN course_session csn ON cc.session_id = csn.session_id\n" +
                    "LEFT JOIN school_location sl ON cc.location_id = sl.location_id\n" +
                    "LEFT JOIN semester_term st ON cc.semester_id = st.term_id\n" +
                    "LEFT JOIN course_mode cm ON cc.mode_id = cm.mode_id\n" +
                    "" + WHERE + _condition +  "ORDER BY cs.subject_id ASC";
        
        Statement statement;
        
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            
            while(rs.next()){
                CourseID.add(rs.getString("cc.course_record_id"));
                CourseNo.add(rs.getString("cs.subject_id") + " " + rs.getString("cl.course_number"));
                CourseName.add(rs.getString("cl.course_name"));
                CourseDesc.add(rs.getString("cl.course_description"));
                CoursePrere.add(rs.getString("cl.course_prerequisite"));
                CourseCredit.add(rs.getString("cl.course_credits"));
                String Day2 = "";
                if(!rs.getString("cc.meeting_day2").equals("")){
                    Day2 = "-"+rs.getString("cc.meeting_day2");
                }
                String meeting = rs.getString("cc.meeting_start") +"-"+rs.getString("cc.meeting_end") + " " +rs.getString("cc.meeting_day1")+Day2;
                CourseMeeting.add(meeting);
                CourseSession.add(rs.getString("csn.session_name"));
                CourseRoom.add(rs.getString("cc.room"));
                CourseInstructor.add(rs.getString("si.firstname") + " " + rs.getString("si.lastname") );
                CourseMode.add(rs.getString("cm.mode_name"));
                
                String status = "Open";
                if(rs.getString("cc.course_status").equals("0")){
                    status = "Close";
                }
                CourseStatus.add(status);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        ListContainer.add(CourseNo);
        ListContainer.add(CourseName);
        ListContainer.add(CourseCredit);
        ListContainer.add(CourseMeeting);
        ListContainer.add(CourseRoom);
        ListContainer.add(CourseInstructor);
        ListContainer.add(CourseMode);
        ListContainer.add(CourseStatus);
        ListContainer.add(CourseDesc);
        ListContainer.add(CoursePrere);
        ListContainer.add(CourseSession);
        ListContainer.add(CourseID);
        return ListContainer;
    
    }
    
    // Student Add Course
    boolean CheckCourseExist(String StudentID, String current_course_id){
        boolean existed = false;
        
        Connection con = getConnection();
        ArrayList<String> list = new ArrayList<>();
        
        String SQL = "SELECT * \n" +
                    "FROM student_course_record \n" +
                    "WHERE student_id = '"+StudentID+"' AND current_course_id = '"+current_course_id+"'";
        
        Statement statement = null;
        
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL);

            while(rs.next()){
                list.add(rs.getString(1));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        if(list.size() > 0){
            existed = true;
        }
        
        return existed;
    }
    
    public boolean StudentAddNewCourse(String Student_id, String Current_Course_Id){
        boolean CheckExisted = CheckCourseExist(Student_id,Current_Course_Id);
        
        if(CheckExisted == false){
            Connection con = getConnection();

            int _record_id =  (int)(Math.random() * 1000000);


            String SQL = "INSERT INTO student_course_record  (record_id,student_id, current_course_id) VALUES ('"+_record_id+"','"+Student_id+"','"+Current_Course_Id+"')";

            Statement statement;
            try {
                statement = con.createStatement();
                statement.executeUpdate(SQL);
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return CheckExisted;
    }
    // Student View Their Courses List
    public ArrayList<ArrayList<String>> StudentViewCourses(String Student_id){
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        CustomControl cc = new CustomControl();
        list = cc.ctm_ArrayList(11);
        
        Connection con = getConnection();
        
        String SQL = "SELECT cc.course_record_id, cs.subject_id, cl.course_number, cl.course_name, cc.meeting_start, cc.meeting_end, cc.meeting_day1, cc.meeting_day2, cc.room, si.firstname, si.lastname\n" +
"                    FROM student_course_record scr\n" +
"                    LEFT JOIN course_record cc ON scr.current_course_id = cc.course_record_id\n" +
                    "LEFT JOIN course_subject cs ON cc.subject_id = cs.subject_id\n" +
                    "LEFT JOIN course_list cl ON cc.course_id = cl.course_id\n" +
                    "LEFT JOIN staff_information si ON cc.staff_id = si.id\n" +
                    "LEFT JOIN semester_term st ON cc.semester_id = st.term_id\n" +
                    "WHERE scr.student_id = '"+Student_id+"' AND st.term_current = '1'"+
                    "ORDER BY cs.subject_id ASC";
        
        Statement statement ;
        
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            ResultSetMetaData rsmd = rs.getMetaData();
            
            while(rs.next()){
                for(int i = 0; i < rsmd.getColumnCount(); i++){
                    list.get(i).add(rs.getString(i+1));
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
    // Load Annoucements
    public ArrayList<ArrayList<String>> LoadAnnoucements(String user_ID, boolean LoadAll){
        Connection con = getConnection();
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        CustomControl cc = new CustomControl();
        list = cc.ctm_ArrayList(10);
        
        String condition = "AND a.read = 0";
        if(LoadAll == true){
            condition = "";
        }
        
        String SQL = "SELECT a.annouce_id,  cl.course_number, a.annouce_title, a.annouce_content, a.post_time, cl.subject_id, cl.course_name, a.read, si.firstname, si.lastname\n" +
                    "FROM annoucement a\n" +
                    "LEFT JOIN course_record cc ON a.course_id = cc.course_record_id\n" +
                    "LEFT JOIN course_list cl ON cc.course_id = cl.course_id\n" +
                    "LEFT JOIN staff_information si ON cc.staff_id = si.id\n" +
                    "WHERE student_id = '"+user_ID+"' "+condition+" \n" + 
                    "ORDER BY a.post_time DESC";
        
        Statement statement = null;
        
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            ResultSetMetaData rsmd = rs.getMetaData();
            while(rs.next()){
                for(int i = 0; i < rsmd.getColumnCount(); i++){
                    list.get(i).add(rs.getString(i+1));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    // Update Read Annoucements
    public void AnnoucementRead(String AnnouceID){
        Connection con = getConnection();
        
        String SQL = "UPDATE annoucement SET annoucement.read = '1' WHERE annouce_id = '"+AnnouceID+"'";
        
        Statement statement = null;
        
        try {
            statement = con.createStatement();
            statement.executeUpdate(SQL);
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Get Student Course ID List-------------------------------------------------
    public ArrayList<String> GetStudentCourseIDList(String UserID){
        Connection con = getConnection();
        Statement statement = null;
        // get Student Course ID List
        ArrayList<String> courseList = new ArrayList<>();
        String SQL1 = "SELECT current_course_id \n" +
                        "FROM student_course_record scr\n" +
                        "LEFT JOIN course_record cr ON scr.current_course_id = cr.course_record_id \n" +
                        "LEFT JOIN semester_term st ON cr.semester_id = st.term_id\n" +
                        "WHERE student_id = '"+UserID+"' AND st.term_current = '1'";
        
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL1);
            while(rs.next()){
                courseList.add(rs.getString("current_course_id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return courseList;

    }
      // Get Student Course Grade List-------------------------------------------------
    public ArrayList<ArrayList<String>> GetStudentCourseGradeList(String UserID, String CourseID){
        Connection con = getConnection();
        Statement statement = null;
        // get Student Course ID List
        ArrayList<ArrayList<String>> GradeList = new ArrayList<>();
        CustomControl cc = new CustomControl();
        GradeList = cc.ctm_ArrayList(6);
        
        String SQL1 = "SELECT sk.course_id, sk.grade_max, skr.grade_get, sk.percentage, cr.subject_id, cl.course_number, cl.course_name, wt.name\n" +
"                    FROM student_work_record skr\n" +
"                    LEFT JOIN student_work sk ON skr.work_id = sk.work_id\n" +
"                    LEFT JOIN course_record cr ON sk.course_id = cr.course_record_id\n" +
"                    LEFT JOIN course_list cl ON cr.course_id = cl.course_id\n" +
"                    LEFT JOIN work_type wt ON sk.work_type_id = wt.work_type_id\n" +
"                    LEFT JOIN semester_term st ON cr.semester_id = st.term_id\n" +
"                    WHERE student_id = '"+UserID+"' AND sk.course_id = '"+CourseID+"'";
        
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL1);
            while(rs.next()){
                GradeList.get(0).add(rs.getString("sk.grade_max"));
                GradeList.get(1).add(rs.getString("skr.grade_get"));
                GradeList.get(2).add(rs.getString("sk.percentage"));
                GradeList.get(3).add(rs.getString("cr.subject_id"));
                GradeList.get(4).add(rs.getString("cl.course_number"));
                GradeList.get(5).add(rs.getString("cl.course_name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return GradeList;

    }
    // Transcript Grade Courses
    public ArrayList<ArrayList<String>> GetTranscriptInformation(String UserID, String TermName, String TermYear){
        Connection con = getConnection();
        
        CustomControl cc = new CustomControl();
        ArrayList<ArrayList<String>>  list = cc.ctm_ArrayList(9);
        
        String SQL = "SELECT cl.subject_id, cl.course_number, cl.course_name, src.attempted , src.earned, src.final_letter_grade, src.points, st.term_name, st.term_year\n" +
                    "FROM student_course_record src\n" +
                    "LEFT JOIN course_record cr ON src.current_course_id = cr.course_record_id\n" +
                    "LEFT JOIN course_list cl ON cr.course_id = cl.course_id\n" +
                    "LEFT JOIN semester_term st ON cr.semester_id = st.term_id\n" +
                    "WHERE st.term_current = '0' AND src.student_id = '"+UserID+"' AND st.term_name = '"+TermName+"'  AND st.term_year = '"+TermYear+"'" +
                    "ORDER BY st.term_year ASC, FIELD(st.term_name ,'Spring','Summer','Fall')";
        
        Statement statement = null;
        
        try {
            statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(SQL);
            while(rs.next()){
                list.get(0).add(rs.getString("cl.subject_id"));
                list.get(1).add(rs.getString("cl.course_number"));
                list.get(2).add(rs.getString("cl.course_name"));
                list.get(3).add(rs.getString("src.attempted"));
                list.get(4).add(rs.getString("src.earned"));
                list.get(5).add(rs.getString("src.final_letter_grade"));
                list.get(6).add(rs.getString("src.points"));
                list.get(7).add(rs.getString("st.term_name"));
                list.get(8).add(rs.getString("st.term_year"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    
    }
    
    // Transcipt Term Order List
    public ArrayList<ArrayList<String>> GetTranscriptTermOrderList(boolean AtoZ){
        CustomControl cc = new CustomControl();
        ArrayList<ArrayList<String>> list = cc.ctm_ArrayList(4);
        Connection con = getConnection();
        
        String sort = "ASC";
        if(AtoZ == false){
            sort = "DESC";
        }
        
        String SQL = "SELECT term_name, term_year, date_format(term_start, '%Y/%m/%d'), date_format(term_end, '%Y/%m/%d') FROM semester_term\n" +
                    "WHERE term_current = '0'\n" +
                    "ORDER BY term_year "+sort+", FIELD(term_name,'Spring','Summer', 'Fall')";
        
        Statement statement = null;
        
        try {
            statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(SQL);
            while(rs.next()){
                list.get(0).add(rs.getString("term_name"));
                list.get(1).add(rs.getString("term_year"));
                list.get(2).add(rs.getString("date_format(term_start, '%Y/%m/%d')"));
                list.get(3).add(rs.getString("date_format(term_end, '%Y/%m/%d')"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
    
    // Student Load All work 
    public ArrayList<ArrayList<String>> StudentLoadAllwork(String UserID, String Worktype, String CourseID){
        Connection con = getConnection();
        CustomControl cc = new CustomControl();
        ArrayList<ArrayList<String>> list = cc.ctm_ArrayList(7);
        
        Statement statement;

        String type_id = "";
        if(Worktype.equals("Homework")){
            type_id = "684351";
        }else if(Worktype.equals("Quiz")){
            type_id = "315486";
        }else if(Worktype.equals("Exam")){
            type_id = "158635";
        }

        String SQL = "SELECT swr.student_work_record_id, sw.work_title, sw.work_description, sw.time_due, sw.percentage, swr.grade_get, sw.grade_max \n" +
                    "FROM student_work_record swr\n" +
                    "LEFT JOIN student_work sw ON swr.work_id = sw.work_id\n" +
                    "LEFT JOIN work_type wt ON sw.work_type_id = wt.work_type_id\n" +
                    "WHERE swr.student_id = '"+UserID+"' AND  wt.name = '"+Worktype+"' AND swr.course_id ='"+CourseID+"'";
        
        try{
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            
            while(rs.next()){
                list.get(0).add(rs.getString("swr.student_work_record_id"));
                list.get(1).add(rs.getString("sw.work_title"));
                list.get(2).add(rs.getString("sw.work_description"));
                list.get(3).add(rs.getString("sw.percentage"));
                list.get(4).add(rs.getString("sw.time_due"));
                list.get(5).add(rs.getString("swr.grade_get"));
                list.get(6).add(rs.getString("sw.grade_max"));
                
            }
        }catch(SQLException ex){
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
        
    }
    // Student Submit Work
    public void StudentSubmitWork(String grade_get, String work_submission, String time_complete, String student_word_record_id){
        Connection con = getConnection();
        
        String SQL = "UPDATE student_work_record \n" +
                    "SET grade_get = '"+grade_get+"', work_submission = '"+work_submission+"', time_complete = '"+time_complete+"'\n" +
                    "WHERE student_work_record_id = '"+student_word_record_id+"'";
        
        Statement statement = null;
        
        try {
            statement = con.createStatement();
            statement.executeUpdate(SQL);
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Load course detail using CourseID
    public ArrayList<String> LoadCourseDetail(String CourseID){
        ArrayList<String> list = new ArrayList<>();
        Connection con = getConnection();
        
        String SQL = "SELECT cr.subject_id, cl.course_number, cl.course_name, cr.meeting_start, cr.meeting_end, cr.meeting_day1, cr.meeting_day2\n" +
                    "FROM course_record cr\n" +
                    "LEFT JOIN course_list cl ON cr.course_id = cl.course_id\n" +
                    "WHERE cr.course_record_id = '"+CourseID+"'";
        
        Statement statement = null;
        
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            ResultSetMetaData rsmd = rs.getMetaData();
            while(rs.next()){
                for(int i = 0; i < rsmd.getColumnCount();i++){
                    list.add(rs.getString(i+1));
                }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return list;
    }
    
    // Load all works using StudentID
    public ArrayList<ArrayList<String>> LoadWorkDueDate(String StudentID, String CourseID){
        CustomControl cc = new CustomControl();
        ArrayList<ArrayList<String>> list = cc.ctm_ArrayList(7);
        
        if(CourseID != null){
            CourseID = "AND sw.course_id ='"+CourseID+"'";
        }else {
            CourseID = "";
        }
        
        Connection con = getConnection();
        
        String SQL = "SELECT swr.student_work_record_id, sw.work_title, sw.time_due, cl.subject_id , cl.course_number, cl.course_name, wt.name\n" +
                    "FROM student_work_record swr\n" +
                    "LEFT JOIN student_work sw ON swr.work_id = sw.work_id\n" +
                    "LEFT JOIN work_type wt ON sw.work_type_id = wt.work_type_id\n" +
                    "LEFT JOIN course_record cr ON swr.course_id = cr.course_record_id\n" +
                    "LEFT JOIN course_list cl ON cr.course_id = cl.course_id\n" +
                    "WHERE swr.student_id = '"+StudentID+"' "+CourseID+" ORDER BY sw.time_due DESC";
        
        Statement statement = null;
        
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            while(rs.next()){
                list.get(0).add(rs.getString("swr.student_work_record_id"));
                list.get(1).add(rs.getString("sw.work_title"));
                list.get(2).add(rs.getString("sw.time_due"));
                list.get(3).add(rs.getString("cl.subject_id"));
                list.get(4).add(rs.getString("cl.course_number"));
                list.get(5).add(rs.getString("cl.course_name"));
                list.get(6).add(rs.getString("wt.name"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return list;
    
    }
}


