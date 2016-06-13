package com.secal.data.faces;

import com.secal.data.entity.User;
import com.secal.data.repository.UserRepository;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@RequestScoped
public class UserBean {

    UserRepository userRepo;

    private List<User> userList;
    private User user;

    public UserBean() {
        System.out.println("UserBean'den Geçti");
        userRepo = new UserRepository();
        long userId = 0;
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();

        if (request.getParameter("userId") != null) {
            userId = new Long(request.getParameter("userId"));
        }
        if (userId == 0) {
            user = new User();
            user.setUserId(0);
            user.setUserName("");
            user.setNickname("");
        } else {
            user = userRepo.find(userId);
        }
        userList = userRepo.list();
    }

    public void save() {
        userRepo = new UserRepository();
        long userId = 0;
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();

        if (request.getParameter("userId") != null) {
            userId = Long.parseLong(request.getParameter("userId"));
        }
        if (userId == 0) {
            userRepo.persist(user);
        } else {
            userRepo.merge(user);
        }
        userRepo.close();
    }

    public void delete() {
        userRepo = new UserRepository();
        long userId = 0;
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();

        if (request.getParameter("userId") != null) {
            userId = Long.parseLong(request.getParameter("userId"));
        }
        if (userId != 0) {
            userRepo.remove(userId);
            userList = userRepo.list();
            userRepo.close();
        }
    }

    //<editor-fold defaultstate="collapsed" desc="Getter - Setter">
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
//</editor-fold>

}
