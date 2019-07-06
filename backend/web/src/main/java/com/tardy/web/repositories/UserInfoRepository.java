package com.tardy.web.repositories;

import com.tardy.web.domain.UserInfoDTO;
import com.tardy.web.entities.UserInfo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * MeetingRepository
 */
public interface UserInfoRepository extends CrudRepository<UserInfo, Long>{
    public UserInfo findByMidAndMpassword(String mId, String mPassword);
    public UserInfo findByMidAndMemail(String mId, String memail);
    public UserInfo findByMid(String mId);
           
    // @Modifying	// update , delete Query시 @Modifying 어노테이션을 추가
	// @Query(value="UPDATE userinfo u SET u.name = :name WHERE u.no = :no", nativeQuery=false)
	// Integer update(@Param("name") UserInfoDTO name);           
}