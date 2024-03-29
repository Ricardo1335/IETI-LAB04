package edu.eci.IETILAB021.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.IETILAB021.data.User;
import edu.eci.IETILAB021.dto.UserDto;
import edu.eci.IETILAB021.service.UserService;
@Service
public class UserServiceMongoDB
   implements UserService
   {
   
    private final UserRepository userRepository;

    public UserServiceMongoDB(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        System.out.print("entra"); 
        return userRepository.save(user); 
    }

    @Override
    public User findById(String id) {
        if(userRepository.existsById(id))return userRepository.findById(id).get();
        return null; 
    }

    @Override
    public boolean deleteById(String id) {
        userRepository.deleteById(id);
        return true;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll(); 
    }

    @Override
    public User update(User user, String userId) {
        if(userRepository.existsById(userId)){
            User actualUser = userRepository.findById(userId).get(); 
            actualUser.setCreatedAt(user.getCreateAt());
            actualUser.setEmail(user.getEmail());
            actualUser.setLastname(user.getLastName());
            actualUser.setName(user.getName());
            userRepository.save(actualUser); 
            return actualUser; 
            
        } 
        return null; 
    }
    @Override
    public User update(UserDto userDto) {
        if(userRepository.existsById(userDto.getId())) {
            User actualUser = userRepository.findById(userDto.getId()).get();
            actualUser.setEmail(userDto.getEmail());
            actualUser.setName(userDto.getName());
            actualUser.setLastname(userDto.getLastName());
            userRepository.save(actualUser);
            return actualUser;
        }
        return null;
    }
    @Override
    public List<User> findUsersWithNameOrLastNameLike(String queryText) {
        List<User> users = new ArrayList<>(); 
        users.addAll(userRepository.findBylastName(queryText)); 
        users.addAll(userRepository.findByName(queryText)); 
        return users;
    }

    @Override
    public List<User> findUsersCreatedAfter(Date startDate) {
        return userRepository.findBycreatedAtAfter(startDate) ; 
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
   }