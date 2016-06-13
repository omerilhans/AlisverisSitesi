package com.secal.data.faces;

import com.secal.data.entity.User;
import com.secal.data.repository.UserRepository;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class LoginBean {

    UserRepository userRepo;
    HttpSession session;

    private User user;
    private boolean isLogin;

    public LoginBean() {
        System.out.println("LoginBean Geçti");
        userRepo = new UserRepository();
        user = new User();
    }

    public String logout() {
        isLogin = false;
        user = new User();
        userRepo = new UserRepository();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Çıkış Yapıldı."));
        session.setAttribute("nickName", null);
        return "Home?faces-redirect=true";
    }

    public String login() {
        userRepo = new UserRepository();
        isLogin = true;

        User girilenUser = userRepo.findByNickname(user.getNickname());
        userRepo.close();

        if (girilenUser == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Böyle Bir Kullanıcı Yok !"));
            return null;
        } else if (!girilenUser.getNickname().equals(user.getNickname())
                || !girilenUser.getPassword().equals(user.getPassword())) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Kullanıcı Adı veya Parola Yanlış !"));
            return null;
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Giriş Başarıyla Yapıldı."));
            session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            user = girilenUser;
            session.setAttribute("nickName", girilenUser.getNickname());
            return "Home?faces-redirect=true";
        }
    }

    //<editor-fold defaultstate="collapsed" desc="Getter - Setter">
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isIsLogin() {
        return isLogin;
    }

    public void setIsLogin(boolean isLogin) {
        this.isLogin = isLogin;
    }
//</editor-fold>
}
