package com.tardy.web.domain;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * MeetingDTO
 */
@Data
@Component
@Lazy
public class UserInfoDTO {
    private String id,
                   mid,
                   mpassword,
                   mname,
                   memail,
                   mphone,
                   mgender; 
}