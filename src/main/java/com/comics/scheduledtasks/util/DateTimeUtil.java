package com.comics.scheduledtasks.util;

import com.comics.scheduledtasks.models.ManualSyncRequest;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Component
public class DateTimeUtil {
    public Timestamp getCurrentCDTTimestamp() {
        LocalDateTime localNow = LocalDateTime.now();
        ZonedDateTime todayCDT = localNow.atZone(ZoneId.of("America/Chicago"));

        return Timestamp.valueOf(todayCDT.toLocalDateTime());
    }

    public Timestamp getYesterdayTimestamp() {
        LocalDateTime localNow = LocalDateTime.now();
        ZonedDateTime todayCDT = localNow.atZone(ZoneId.of("America/Chicago"));
        ZonedDateTime yesterdayCDT = todayCDT.minusDays(1);

        return Timestamp.valueOf(yesterdayCDT.toLocalDate().toString() + " 00:00:00");
    }

    public Timestamp getTimestampFromRequest(ManualSyncRequest manualSyncRequest) {
        LocalDateTime localNow = LocalDateTime.now();
        ZonedDateTime todayCDT = localNow.atZone(ZoneId.of("America/Chicago"));
        ZonedDateTime zonedDateTime = todayCDT.minusDays(manualSyncRequest.getNumDays());
        zonedDateTime = zonedDateTime.minusMonths(manualSyncRequest.getNumMonths());
        zonedDateTime = zonedDateTime.minusYears(manualSyncRequest.getNumYears());

        return Timestamp.valueOf(zonedDateTime.toLocalDate().toString() + " 00:00:00");
    }
}
