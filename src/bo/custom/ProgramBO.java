package bo.custom;

import bo.SuperBO;
import dto.ProgramDTO;
import dto.StudentDTO;

import java.util.List;

public interface ProgramBO extends SuperBO {
    public boolean add(ProgramDTO programDTO) throws Exception;

    public List<ProgramDTO> selectAll() throws Exception;

    public boolean delete(String id) throws Exception;

    public boolean update(ProgramDTO programDTO) throws Exception;
}
