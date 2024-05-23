package org.example.model;

import lombok.*;

@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Order {
    private long id;

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", sum='" + sum + '\'' +
                ", status='" + status + '\'' +
                ", size='" + size + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }

    private String sum;
    private String status;
    private String size;
    private String comment;


}
