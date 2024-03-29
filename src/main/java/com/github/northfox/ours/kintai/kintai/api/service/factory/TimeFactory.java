package com.github.northfox.ours.kintai.kintai.api.service.factory;

import com.github.northfox.ours.kintai.api.model.TimeResource;
import com.github.northfox.ours.kintai.api.model.TimesResource;
import com.github.northfox.ours.kintai.kintai.api.domain.TimeEntity;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class TimeFactory {

  public TimesResource generateTimes(List<TimeEntity> times) {
    return new TimesResource()
        .times(times.stream()
            .map(t -> generateTime(t))
            .collect(Collectors.toList()));
  }

  public TimeResource generateTime(TimeEntity time) {
    Optional<OffsetDateTime> inTime = Optional
        .ofNullable(time.getInTime())
        .map(at -> at.atOffset(ZoneOffset.ofHours(9)));
    Optional<OffsetDateTime> outTime = Optional
        .ofNullable(time.getOutTime())
        .map(at -> at.atOffset(ZoneOffset.ofHours(9)));
    Optional<OffsetDateTime> deletedAt = Optional
        .ofNullable(time.getDeletedAt())
        .map(at -> at.atOffset(ZoneOffset.ofHours(9)));

    return new TimeResource()
        .id(time.getId())
        .category(time.getCategory())
        .userId(time.getUserId())
        .inTime(inTime.orElse(null))
        .outTime(outTime.orElse(null))
        .createdAt(time.getCreatedAt().atOffset(ZoneOffset.ofHours(9)))
        .updatedAt(time.getUpdatedAt().atOffset(ZoneOffset.ofHours(9)))
        .deletedAt(deletedAt.orElse(null));
  }

  public TimeEntity parse(TimeResource timeResource) {
    Optional<LocalDateTime> inTime = Optional.ofNullable(timeResource.getInTime())
        .map(t -> t.toLocalDateTime());
    Optional<LocalDateTime> outTime = Optional.ofNullable(timeResource.getOutTime())
        .map(t -> t.toLocalDateTime());

    TimeEntity user = TimeEntity.builder()
        .id(timeResource.getId())
        .category(timeResource.getCategory())
        .userId(timeResource.getUserId())
        .inTime(inTime.orElse(null))
        .outTime(outTime.orElse(null))
        .createdAt(LocalDateTime.now())
        .createdBy("api") // TODO want requester
        .updatedAt(LocalDateTime.now())
        .updatedBy("api") // TODO want requester
        .build();
    return user;
  }
}
