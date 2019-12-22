package com.github.northfox.ours.kintai.kintai.api.presentation;

import com.github.northfox.ours.kintai.api.handler.UserApi;
import com.github.northfox.ours.kintai.api.model.UserResource;
import com.github.northfox.ours.kintai.api.model.UsersResource;
import com.github.northfox.ours.kintai.kintai.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/")
@RequiredArgsConstructor
public class UserApiImpl implements UserApi {

  private final UserService userService;

  @Override
  public ResponseEntity<UsersResource> getUsers() {
    UsersResource result = userService.findAll();
    return ResponseEntity.ok(result);
  }

  @Override
  public ResponseEntity<UserResource> getUserById(Integer userId) {
    UserResource result = userService.findById(userId);
    return ResponseEntity.ok(result);
  }
}
