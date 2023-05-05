package pl.portfolio.Planner_App.Model.Dto;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import pl.portfolio.Planner_App.Model.Base.Status;

@AllArgsConstructor
@NoArgsConstructor
public class ToDoDto {
    private Long id;
    private String title;
    private String description;
    private String date;
    private Status status;

    public String statusToString() {
        return status.toString();
    }
}
