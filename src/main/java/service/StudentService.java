package service;

import entity.Student;
import repository.StudentDao;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;

public class StudentService {

    StudentDao studentDao = new StudentDao();

    public List<Student> getListStudent() {
        return studentDao.getAll();
    }

    public Student findID(int id) {
        return studentDao.findById(id);
    }

    public boolean insert(Student student) {
        List<Student> students = studentDao.getAll();
        students.sort((o1, o2) -> o1.getId() < o2.getId() ? 1 : -1);
        int id = students.get(0).getId() + 1;

        student.setId(id);
        if (student.getFullName() == null) {
            return false;
        }
        return studentDao.insert(student);
    }

    public boolean update(Student student){
        return studentDao.update(student);
    }

    public boolean removeStudent(int id) {
        return studentDao.removeStudent(id);
    }

    public List<Student> search(){

        return null;
    }

    public List<Student> todayBirthday(){
        return studentDao.searchTodayBirthday();
    }

    public String validateData(Student student){

        if (!student.getFullName().matches(".{0,50}")){
            return "Tên có độ dài đã vượt quá 50 ký tự";
        }
        if(student.getFullName().equals("")){
            return "Chưa nhập họ tên";
        }
        if(student.getBirthday().equals("")){
            return "Chưa nhập ngày sinh";
        }
        if(Period.between(student.getBirthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now()).getYears()> 120){
            return "Tuổi đã vượt quá 120";
        }
        if(student.getBirthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getYear() - LocalDate.now().getYear() > 0){
            return "Tuổi phải lớn hơn 0";
        }
        if(student.getGender().equals("")){
            return "Chưa nhập giới tính";
        }
        if(student.getClassName().equals("")){
            return "Chưa nhập tên lớp";
        }
        if(student.getMajor().equals("")){
            return "Chưa nhập ngành học";
        }
        if(student.getHometown().equals("")){
            return "Chưa nhập quê quán";
        }
        if(student.getAverageMark() < 0 || student.getAverageMark() > 10){
            return "Điểm trung bình phải lớn 0 và nhỏ hơn 10";
        }
        if (!student.getGender().equalsIgnoreCase("nam")
                & !student.getGender().equalsIgnoreCase("nữ")
                & !student.getGender().equalsIgnoreCase("khác")){
            return "Giới tính phải là: nam, nữ hoặc khác.";
        }
        return "";
    }
}
