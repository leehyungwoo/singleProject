package com.tardy.web.controller;

import java.util.HashMap;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.tardy.web.domain.UserInfoDTO;
import com.tardy.web.entities.UserInfo;
import com.tardy.web.repositories.UserInfoRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * MeetingController
 */
@RestController
@CrossOrigin(origins = "http://localhost:8080", maxAge = 9000)
@RequestMapping("/userinfo")
public class UserInfoController {
    @Autowired UserInfoRepository repo;
    @Autowired UserInfoDTO dto;
    @Autowired ModelMapper modelMapper;

   @Bean
   public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper ();
        return modelMapper;
    }

    @GetMapping("/join/confirm/{id}")
    public HashMap<String,Object> joinConfirm(@PathVariable String id){
      HashMap<String,Object> map =new HashMap<>();
      UserInfo entity = repo.findByMid(id);
      if(entity == null){
         map.put("msg","사용할수 있는 아이디입니다");
         map.put("result",true);
      }else{
         map.put("msg","사용할수 없는 아이디입니다");
         map.put("result",false);
      }
      return map;
   }

    @PostMapping("/join")
    public HashMap<String,Object> join(@RequestBody UserInfoDTO param) {
       UserInfo entity = new UserInfo();
       entity.setMid(param.getMid());
       entity.setMpassword(param.getMpassword());
       entity.setMname(param.getMname());
       entity.setMemail(param.getMemail());
       entity.setMphone(param.getMphone());
       entity.setMgender(param.getMgender());
       UserInfo result = repo.save(entity);
       HashMap<String,Object> map =new HashMap<>();
       if(result != null){
         map.put("result","user join sucess");
       }else{
         map.put("result","user join fail");
       }
       return map;
    }

    @PostMapping("/login")
    public HashMap<String,Object> login(@RequestBody UserInfoDTO param) {
      UserInfo result =repo.findByMidAndMpassword(param.getMid(), param.getMpassword());
      HashMap<String,Object> map =new HashMap<>();
      if(result != null){
         map.put("result","sucess");
         map.put("user",result.getMid());
      }else{
         map.put("result","fail");
      }
      return map;
   }

   @PostMapping("/find")
   public HashMap<String,Object> find(@RequestBody UserInfoDTO param) {
      UserInfo result =repo.findByMidAndMemail(param.getMid(), param.getMemail());  
      HashMap<String,Object> map =new HashMap<>();
      if(result != null){
         map.put("result","user  find sucess");
      }else{
         map.put("result","user  find fail");
      }
      return map;
   }

    @GetMapping("/mypage/{id}")
    public UserInfoDTO mypage(@PathVariable String id){
      UserInfo entity = repo.findByMid(id);
      UserInfoDTO target = modelMapper.map(entity, UserInfoDTO.class);
      return target;
   }

 
      // @PutMapping("/update")
      // public void put(@RequestBody UserInfoDTO param) {
      //    long id = Long.parseLong(param.getId());
      //    UserInfo entity = repo.findById(id).get();
      //    // Exception 문법이 발생하면 :: new로 처리하라는 뜻.
      //    //(a) -> { return new Object(a); }
      //    //Object::new; 
      //    entity.setMid(param.getMid());
      //    entity.setMpassword(param.getMpassword());
      //    entity.setMname(param.getMname());
      //    entity.setMemail(param.getMemail());
      //    entity.setMphone(param.getMphone());
      //    entity.setMgender(param.getMgender());
      //    repo.save(entity);
      // }

    @PutMapping("/update")
    public HashMap<String,Object> put(@RequestBody UserInfoDTO param) {
         //1.옵셔널을 엔티티로 체인지
         //2.엔티티 존재확인되면 셋팅하고 저장
         //3.엔티티 존재실패면 경고 리턴 
       long id = Long.parseLong(param.getId());
       Optional<UserInfo> entity = repo.findById(id);
       HashMap<String,Object> map = new HashMap<>();     
       if(entity.isPresent()){
            UserInfo result = entity.get();
            result.setMid(param.getMid());
            result.setMpassword(param.getMpassword());
            result.setMname(param.getMname());
            result.setMemail(param.getMemail());
            result.setMphone(param.getMphone());
            result.setMgender(param.getMgender());
            repo.save(result);
            map.put("result","user update sucess");
            return map;
         }else{
            map.put("result","user update Error fail");
            return map;
         }

       // Exception 문법이 발생하면 :: new로 처리하라는 뜻.
       //(a) -> { return new Object(a); }
       //Object::new;
      //  entity.setMid(param.getMid());
      //  entity.setMpassword(param.getMpassword());
      //  entity.setMname(param.getMname());
      //  entity.setMemail(param.getMemail());
      //  entity.setMphone(param.getMphone());
      //  entity.setMgender(param.getMgender());
      //  repo.save(entity);
    }

    @DeleteMapping("/delete/{id}")
    public HashMap<String,Object> delete(@PathVariable long id) {
     HashMap<String,Object> map = new HashMap<>();
      if(repo.existsById(id)){
      repo.deleteById(id);
      map.put("result","sucess");
     }else{
      map.put("result","fail");
     }
      return map;
   }


}