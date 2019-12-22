package com.github.northfox.ours.kintai.kintai.api.service.factory;

import com.github.northfox.ours.kintai.api.model.UserResource;
import com.github.northfox.ours.kintai.kintai.api.domain.UserEntity;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javassist.NotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserFactory {

  public List<UserResource> generateUsers(List<UserEntity> users) {
    return users.stream()
        .map(u ->
            new UserResource()
                .id(u.getId())
                .name(u.getName()))
        .collect(Collectors.toList());
  }

  public UserResource generateUser(UserEntity user) {
    return new UserResource()
        .id(user.getId())
        .name(user.getName());
  }
}
