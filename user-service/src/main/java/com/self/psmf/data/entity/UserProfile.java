package com.self.psmf.data.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import com.self.psmf.contstant.UserRole;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "USER_PROFILE", schema = "USERS")
public class UserProfile extends BaseModel {

    @Id
    @Column(name = "ID",nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "REF_NO", nullable = false)
    private String refNo;
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "USER_MOBILE_NO")
    private String userMobileNo;
    @Column(name = "USER_EMAIL")
    private String userEmail;
    @Column(name = "IS_ACTIVE")
    private Boolean isActive;
    @Column(name= "PASSWORD")
    private String password;
    @Column(name = "USER_ROLE")
    private UserRole userRole;
    @Column(name = "REFER_CODE")
    private String referalCode;
    
}
