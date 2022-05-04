package com.project.demo.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.project.demo.security.entity.User;
import com.project.demo.security.entity.UserDTO;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(imports = Collectors.class)
public interface WMTMapper {
    WMTMapper INSTANCE = Mappers.getMapper(WMTMapper.class);
    List<UserDTO> getUserDTO(List<User> user);

    UserDTO getUserDto(User user);





}
