package bo.custom;

import bo.SuperBO;
import dto.StudentDTO;

import java.util.List;

public interface StudentBO extends SuperBO {
    public boolean add(StudentDTO studentDTO) throws Exception;

    public List<StudentDTO> selectAll() throws Exception;

    public boolean delete(String id) throws Exception;

    public boolean update(StudentDTO studentDTO) throws Exception;
}
