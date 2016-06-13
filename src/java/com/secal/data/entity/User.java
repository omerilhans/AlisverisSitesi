package com.secal.data.entity;

import com.secal.base.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "USER")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private long userId;

    @Column(name = "userName")
    @NotNull
    @Size(min = 4, max = 32)
    private String userName;

    @Column(name = "password")
    @NotNull
    @Size(min = 4, max = 16)
    private String password;

    @NotNull
    @Column(name = "nickname", length = 32)
    @Size(min = 4, max = 32)
    private String nickname;

    //<editor-fold defaultstate="collapsed" desc="Get ve Set">
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
//</editor-fold>
}
