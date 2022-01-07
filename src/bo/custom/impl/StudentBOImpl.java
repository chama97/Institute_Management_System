package bo.custom.impl;

import bo.custom.StudentBO;
import dao.DAOFactory;
import dao.custom.StudentDAO;
import dao.custom.impl.StudentDAOImpl;
import dto.StudentDTO;
import entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {
    private final StudentDAO studentDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STUDENT);
    //StudentDAOImpl studentDAO = DAOFactory.getInstance().getDAO(STUDENT);

    @Override
    public boolean add(StudentDTO studentDTO) throws Exception {
        return studentDAO.add(new Student(
                studentDTO.getId(),
                studentDTO.getName(),
                studentDTO.getAddress(),
                studentDTO.getGender(),
                studentDTO.getDate(),
                studentDTO.getContact()
        ));
    }

    @Override
    public List<StudentDTO> selectAll() throws Exception {
        List<Student> all = studentDAO.selectAll();
        ArrayList<StudentDTO> studentList = new ArrayList<>();

        for (Student student : all) {
            studentList.add(new StudentDTO(
                    student.getId(),
                    student.getName(),
                    student.getAddress(),
                    student.getGender(),
                    student.getDate(),
                    student.getContact()
            ));
        }
        return studentList;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return studentDAO.delete(id);
    }

    @Override
    public boolean update(StudentDTO studentDTO) throws Exception {
        return studentDAO.update(new Student(
                studentDTO.getId(),
                studentDTO.getName(),
                studentDTO.getAddress(),
                studentDTO.getGender(),
                studentDTO.getDate(),
                studentDTO.getContact()
        ));
    }
}
