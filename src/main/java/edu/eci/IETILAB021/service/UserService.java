package edu.eci.IETILAB021.service;

import java.util.Date;
import java.util.List;

import edu.eci.IETILAB021.data.User;
import edu.eci.IETILAB021.dto.UserDto;

public interface UserService
{
    User create( User user );
    User update(UserDto userDto);

    User findById( String id );
    
    List<User> getAll();

    boolean deleteById( String id );

    User update( User user, String userId );

    List<User> findUsersWithNameOrLastNameLike(String queryText);
    
    List<User> findUsersCreatedAfter(Date startDate);

    User findByEmail(String email);
    
}  