package bo.custom.impl;

import bo.custom.ProgramBO;
import dao.DAOFactory;
import dao.custom.ProgramDAO;
import dto.ProgramDTO;
import entity.Program;

import java.util.ArrayList;
import java.util.List;

public class ProgramBOImpl implements ProgramBO {

    private final ProgramDAO programDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PROGRAM);

    @Override
    public boolean add(ProgramDTO programDTO) throws Exception {
        return programDAO.add(new Program(
                programDTO.getId(),
                programDTO.getProgram(),
                programDTO.getDuration(),
                programDTO.getFee()
        ));
    }

    @Override
    public List<ProgramDTO> selectAll() throws Exception {
        List<Program> all = programDAO.selectAll();
        ArrayList<ProgramDTO> programList = new ArrayList<>();

        for (Program program : all) {
            programList.add(new ProgramDTO(
                    program.getId(),
                    program.getProgram(),
                    program.getDuration(),
                    program.getFee()
            ));
        }
        return programList;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return programDAO.delete(id);
    }

    @Override
    public boolean update(ProgramDTO programDTO) throws Exception {
        return programDAO.update(new Program(
                programDTO.getId(),
                programDTO.getProgram(),
                programDTO.getDuration(),
                programDTO.getFee()
        ));
    }
}
