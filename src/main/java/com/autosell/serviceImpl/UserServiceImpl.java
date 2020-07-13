package com.autosell.serviceImpl;

import com.autosell.domains.BillingAddress;
import com.autosell.domains.User;
import com.autosell.repositories.UserRepository;
import com.autosell.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import java.util.List;
=======
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
>>>>>>> 7568a5dcf8a3ff1368d5df6aacaab4cb2de6581b

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }


    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    @Override
    public User findByUserName(String username) {
        return userRepository.findByUserName(username);
    }
<<<<<<< HEAD
//    @Override
//    @Query(value = "SELECT * FROM BillingAddress e WHERE e.id = :id")
//    public List<BillingAddress> saveBillingAddressByID(long id){
//        return userRepository.save(List<BillingAddress>);
//    }
=======

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User FindById(Long id) {
         Optional<User> userOptional = userRepository.findById(id);
         if(userOptional.isPresent()){
             return userOptional.get();
         }
        return null;
    }

    @Override
    public boolean acceptById(Long id) {
        if(userRepository.changeStatus(true,id)>0){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public boolean declinedById(Long id) {
        if(userRepository.changeStatus(false,id)>0){
            return true;
        }else{
            return false;
        }
    }
>>>>>>> 7568a5dcf8a3ff1368d5df6aacaab4cb2de6581b
}
