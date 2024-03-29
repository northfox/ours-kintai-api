package com.github.northfox.ours.kintai.kintai.api.presentation;

import com.github.northfox.ours.kintai.api.handler.UserApi;
import com.github.northfox.ours.kintai.api.model.UserResource;
import com.github.northfox.ours.kintai.api.model.UsersResource;
import com.github.northfox.ours.kintai.kintai.api.service.UserService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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

  @Override
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<UserResource> postUser(@Valid UserResource userResource) {
    UserResource result = userService.create(userResource);
    return ResponseEntity.ok(result);
  }

  @Override
  public ResponseEntity<UserResource> putUser(Integer userId, @Valid UserResource userResource) {
    UserResource result = userService.update(userId, userResource);
    return ResponseEntity.ok(result);
  }

  @Override
  public ResponseEntity<Void> deleteUser(Integer userId) {
    userService.delete(userId);
    return new ResponseEntity<Void>(HttpStatus.OK);
  }
}
