package com.moreece.userservice.ValueObject;

import com.moreece.userservice.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseObject {
    private User user;
    private Department department;

}
