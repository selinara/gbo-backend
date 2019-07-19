package com.chl.gbo.cental.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @Auther: BoYanG
 * @Describe 权限
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_authority")
public class Authority {
    @Id
    @GeneratedValue
    private Integer id;
    private String dataUrl;
    private String menuClass;
    private String menuCode;
    private String menuName;
    private String parentMenucode;
    private Integer sequence;
    private String menuType;
    private String createTime;

//    @OneToMany
//    @JoinColumn
//    private List<Role> roles;
}
