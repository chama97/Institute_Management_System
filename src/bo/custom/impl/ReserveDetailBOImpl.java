package bo.custom.impl;

import bo.custom.ReserveDetailBO;
import dao.DAOFactory;
import dao.custom.ProgramDAO;
import dao.custom.ReserveDetailDAO;
import dto.ProgramDTO;
import dto.ReserveDTO;
import entity.Program;
import entity.ReserveDetails;

import java.util.ArrayList;
import java.util.List;

public class ReserveDetailBOImpl implements ReserveDetailBO {

    private final ReserveDetailDAO reserveDetailDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.RESERVE);

    @Override
    public boolean add(ReserveDTO reserveDTO) throws Exception {
        return reserveDetailDAO.add(new ReserveDetails(
                reserveDTO.getStudentId(),
                reserveDTO.getProId(),
                reserveDTO.getDate()
        ));
    }

    @Override
    public List<ReserveDTO> selectAll() throws Exception {
        List<ReserveDetails> all = reserveDetailDAO.selectAll();
        ArrayList<ReserveDTO> reserveList = new ArrayList<>();

        for (ReserveDetails reserveDetails : all) {
            reserveList.add(new ReserveDTO(
                    reserveDetails.getReserveDetailPK().getsId(),
                    reserveDetails.getReserveDetailPK().getpId(),
                    reserveDetails.getDate()
            ));
        }
        return reserveList;
    }
}
