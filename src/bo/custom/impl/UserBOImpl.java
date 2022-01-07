package bo.custom.impl;

import bo.custom.UserBO;
import dao.DAOFactory;
import dao.custom.UserDAO;
import dto.UserDTO;
import entity.Users;

import java.util.ArrayList;
import java.util.List;

public class UserBOImpl implements UserBO {

    private final UserDAO userDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.USER);

    @Override
    public boolean add(UserDTO userDTO) throws Exception {
        return userDAO.add(new Users(
                userDTO.getName(),
                userDTO.getName(),
                userDTO.getRole()
        ));
    }

    @Override
    public List<UserDTO> selectAll() throws Exception {
        List<Users> all = userDAO.selectAll();
        ArrayList<UserDTO> userList = new ArrayList<>();

        for (Users users : all) {
            userList.add(new UserDTO(
                    users.getName(),
                    users.getPassword(),
                    users.getRole()
            ));
        }
        return userList;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return userDAO.delete(id);
    }

    @Override
    public boolean update(UserDTO userDTO) throws Exception {
        return false;
    }
}
