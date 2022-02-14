package edu.eci.IETILAB021.service;

import java.util.*;

import org.springframework.stereotype.Service;

import edu.eci.IETILAB021.data.User;
import edu.eci.IETILAB021.dto.UserDto;

public class UserServiceHashMap implements UserService {
    HashMap <String, User> map = new HashMap <String, User> ();
    @Override
    public User create(User user) {
        map.put(user.id, user);
        return map.get(user.id);
    }

    @Override
    public User findById(String id) {
        
        return map.get(id);
    }

    @Override
    public List<User> getAll() {
        List<User> li = new ArrayList<User>();
        for (User u : map.values()) {
            li.add(u);
        }
        return li;
    }

    @Override
    public boolean deleteById(String id) {
        map.remove(id);
        return true;
        
    }

    @Override
    public User update(User user, String userId) {
        map.put(userId, user);
        return map.get(userId);
    }

    @Override
    public List<User> findUsersWithNameOrLastNameLike(String queryText) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<User> findUsersCreatedAfter(Date startDate) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User update(UserDto userDto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User findByEmail(String email) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
