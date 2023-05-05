package pl.portfolio.Planner_App.Model.Dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class CreateEventDto {
    private String title;
    private String description;
    private String date;
}
