package com.meetdoc.api.response;

import com.meetdoc.common.model.response.BaseResponseBody;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class OpeningTimeGetRes extends BaseResponseBody {
    List<String> result;

    private List<String> mapResult(List<LocalDateTime> timeList) {
        return timeList
                .stream()
                .map((time)-> time.format(DateTimeFormatter.ofPattern("HH:mm")))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static OpeningTimeGetRes of(int statusCode, String message, List<LocalDateTime> appointments) {
        OpeningTimeGetRes res = new OpeningTimeGetRes();
        res.setStatusCode(statusCode);
        res.setMessage(message);
        res.setResult(res.mapResult(appointments));
        return res;
    }
}
