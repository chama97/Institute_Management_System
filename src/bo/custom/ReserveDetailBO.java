package bo.custom;

import bo.SuperBO;
import dto.ProgramDTO;
import dto.ReserveDTO;

import java.util.List;

public interface ReserveDetailBO extends SuperBO {
    public boolean add(ReserveDTO reserveDTO) throws Exception;
    public List<ReserveDTO> selectAll() throws Exception;
}
