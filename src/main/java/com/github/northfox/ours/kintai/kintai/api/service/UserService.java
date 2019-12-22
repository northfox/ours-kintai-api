package com.github.northfox.ours.kintai.kintai.api.service;

import com.github.northfox.ours.kintai.api.model.UserResource;
import com.github.northfox.ours.kintai.api.model.UsersResource;
import com.github.northfox.ours.kintai.kintai.api.domain.UserEntity;
import com.github.northfox.ours.kintai.kintai.api.repository.UserRepository;
import com.github.northfox.ours.kintai.kintai.api.service.factory.UserFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserFactory userFactory;
  private final UserRepository userRepository;

  public UsersResource findAll() {
    List<UserEntity> users = userRepository.findAll();
    UsersResource result = userFactory.generateUsers(users);
    return result;
  }

  public UserResource findById(String id) {
    UserEntity user = userRepository.findById(Integer.valueOf(id))
        .orElseThrow(() -> new RuntimeException("存在しないユーザ"));
    UserResource result = userFactory.generateUser(user);
    return result;
  }
}
