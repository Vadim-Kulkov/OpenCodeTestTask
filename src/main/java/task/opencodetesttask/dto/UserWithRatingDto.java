package task.opencodetesttask.dto;

import lombok.Data;

@Data
public class UserWithRatingDto {

    private long id;
    private String mail;
    private long points;
}
