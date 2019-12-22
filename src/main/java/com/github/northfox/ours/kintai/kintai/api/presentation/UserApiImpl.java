package com.github.northfox.ours.kintai.kintai.api.presentation;

import com.github.northfox.ours.kintai.api.handler.UserApi;
import com.github.northfox.ours.kintai.api.model.UserResource;
import org.springframework.http.ResponseEntity;

public class UserApiImpl implements UserApi {

  @Override
  public ResponseEntity<UserResource> getUserById(String userId) {
    UserResource result = new UserResource();
    return ResponseEntity.ok(result);
  }
}
