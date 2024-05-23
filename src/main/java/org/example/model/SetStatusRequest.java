package org.example.model;

import lombok.*;

@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class SetStatusRequest {
    private long id;
    private String status;
}
