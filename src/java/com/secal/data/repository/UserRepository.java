
package com.secal.data.repository;

import com.secal.base.BaseRepository;
import com.secal.data.entity.User;
import javax.persistence.NoResultException;
import javax.persistence.Query;


public class UserRepository extends BaseRepository<User> {

    public UserRepository() {
        super(User.class);
    }
    
    public User findByNickname(String nickname)
    {
        try {
            String jpql = "select user from User as user"
                    + " where user.nickname = :nickname";
            Query query = entityManager.createQuery(jpql);
            query.setParameter("nickname", nickname);
            User user = (User) query.getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null;
        }
    }

}
