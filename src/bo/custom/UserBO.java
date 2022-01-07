package bo.custom;

import bo.SuperBO;
import dto.ProgramDTO;
import dto.UserDTO;

import java.util.List;

public interface UserBO extends SuperBO {
    public boolean add(UserDTO userDTO) throws Exception;

    public List<UserDTO> selectAll() throws Exception;

    public boolean delete(String id) throws Exception;

    public boolean update(UserDTO userDTO) throws Exception;
}
