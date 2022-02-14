package edu.eci.IETILAB021.repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import edu.eci.IETILAB021.data.User;
@Service  
public interface UserRepository extends MongoRepository<User, String>
{

    List<User> findByName(String queryText);
    List<User> findBylastName(String queryText);
    List<User> findBycreatedAtAfter(Date date);
    User findByEmail(String email);
}