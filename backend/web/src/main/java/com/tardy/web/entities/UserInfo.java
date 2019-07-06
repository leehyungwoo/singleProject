package com.tardy.web.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Getter
@Setter
@ToString
@Table(name = "userinfo")
public class UserInfo implements Serializable{  //매퍼역할
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  @Column(name="mid") private String mid;
  @Column(name="mpassword") private String mpassword;
  @Column(name="mname") private String mname;
  @Column(name="memail") private String memail;
  @Column(name="mphone") private String mphone;
  @Column(name="mgender") private String mgender;
   //이름이 같으면 생략가능


  @Override
  public String toString(){
    return "UserInfo :[id:"+id+",mid:" +mid+", mpassword:"+mpassword+", mname:"+mname+", memail:"+memail+", mphone:"+mphone+", mgender:"+mgender+"]"; 
  }

  //resultMap이라 생각
  @Builder
  private UserInfo(
 
      String mid,
      String mpassword,
      String mname,
      String memail,
      String mphone,
      String mgender){

      this.mid = mid;
      this.mpassword = mpassword;
      this.mname = mname;
      this.memail = memail;
      this.mphone = mphone;
      this.mgender = mgender;

  }


}