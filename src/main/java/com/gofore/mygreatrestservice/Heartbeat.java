package com.gofore.mygreatrestservice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Heartbeat implements Serializable {

    private static final long serialVersionUID = 4048861576368846345L;

    private String appName;

    private String appVersion;

    private LocalDateTime systemTime;
}
