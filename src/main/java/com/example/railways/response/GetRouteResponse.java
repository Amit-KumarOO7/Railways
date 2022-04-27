package com.example.railways.response;

import com.example.railways.models.RouteDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class GetRouteResponse {
    private @Getter
    @Setter
    Date timestamp;

    private @Getter
    @Setter
    String message;

    private @Getter
    @Setter
    String status;

    private @Getter
    @Setter
    List<RouteDetails> route;
}

