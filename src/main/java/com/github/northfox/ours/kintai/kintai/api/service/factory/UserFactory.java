package com.github.northfox.ours.kintai.kintai.api.service.factory;

import com.github.northfox.ours.kintai.api.model.UserResource;
import com.github.northfox.ours.kintai.api.model.UsersResource;
import com.github.northfox.ours.kintai.kintai.api.domain.UserEntity;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class UserFactory {

  public UsersResource generateUsers(List<UserEntity> users) {
    return new UsersResource()
        .users(users.stream()
            .map(u ->
                new UserResource()
                    .id(u.getId())
                    .name(u.getName()))
            .collect(Collectors.toList()));
  }

  public UserResource generateUser(UserEntity user) {
    return new UserResource()
        .id(user.getId())
        .name(user.getName());
  }

  public UserEntity parseUser(UserResource userResource) {
    UserEntity user = UserEntity.builder()
        .id(userResource.getId())
        .name(userResource.getName())
        .createdAt(LocalDateTime.now())
        .createdBy("api") // TODO want requester
        .updatedAt(LocalDateTime.now())
        .updatedBy("api") // TODO want requester
        .build();
    return user;
  }
}
