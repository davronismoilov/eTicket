package uz.ticket.eticket.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uz.ticket.eticket.model.User;
import uz.ticket.eticket.response.ApiResponse;
import uz.ticket.eticket.response.BaseResponse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static uz.ticket.eticket.response.BaseResponse.SUCCESS;
import static uz.ticket.eticket.response.BaseResponse.USER_NOT_FOUND;

@Component
public class UserRepository extends BaseDatabase<User> {
    @Autowired
     BaseResponse response;

    static final String LOGIN = "select * from login ( ? , ?  , ? )";

    @Override
    public boolean add(User user) {
        return false;
    }

    @Override
    public List<User> getList() {
        return null;
    }

    @Override
    public long delete(Long id) {
        return 0;
    }

    public  ApiResponse login(User user) {


        try {
            Connection con = getConnection();
            PreparedStatement pr = con.prepareStatement(LOGIN);
            pr.setString(1, user.getEmail());
            pr.setString(2, user.getPhoneNumber());
            pr.setString(3, user.getPassword());

            ResultSet resultSet = pr.executeQuery();
            if (resultSet.first()) {
                if (resultSet.getBoolean(1)) {
                    SUCCESS.setData(user);
                    return SUCCESS;
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return USER_NOT_FOUND;
    }
}
