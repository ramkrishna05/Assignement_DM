package Dmap.Infotech.Assignment.Dto.ResponseDto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class TaskResponse {
    long id;
    String title;
    String description;
}
