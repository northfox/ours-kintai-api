package com.github.northfox.ours.kintai.kintai.api.presentation;

import com.github.northfox.ours.kintai.api.handler.TimeApi;
import com.github.northfox.ours.kintai.api.model.TimeResource;
import com.github.northfox.ours.kintai.api.model.TimesResource;
import com.github.northfox.ours.kintai.kintai.api.service.TimeService;
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
public class TimeApiImpl implements TimeApi {

  private final TimeService timeService;

  @Override
  public ResponseEntity<TimesResource> getTimesForUsersById(Integer userId) {
    TimesResource result = timeService.findAllByUserId(userId);
    return ResponseEntity.ok(result);
  }

  @Override
  public ResponseEntity<TimeResource> getTimeByTimeIdForUsersById(Integer userId, Integer timeId) {
    TimeResource result = timeService.findByIdForUserById(userId, timeId);
    return ResponseEntity.ok(result);
  }

  @Override
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<TimeResource> postTimeForUsersById(Integer userId, @Valid TimeResource timeResource) {
    TimeResource result = timeService.createForUserById(userId, timeResource);
    return ResponseEntity.ok(result);
  }

  @Override
  public ResponseEntity<TimeResource> putTimeByIdForUserById(Integer userId, Integer timeId,
      @Valid TimeResource timeResource) {
    TimeResource result = timeService.updateForUserById(userId, timeId, timeResource);
    return ResponseEntity.ok(result);
  }
}
