package pl.portfolio.Planner_App.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.portfolio.Planner_App.Model.Base.ToDo;
import pl.portfolio.Planner_App.Model.Dto.CreateToDoDto;
import pl.portfolio.Planner_App.Model.Dto.ToDoDto;
import pl.portfolio.Planner_App.Model.MyModelMapper;
import pl.portfolio.Planner_App.Repository.ToDoRepository;

import java.util.List;

@Service
public class ToDoService {
    @Autowired
    private ToDoRepository toDoRepository;
    MyModelMapper modelMapper = MyModelMapper.getInstance();

    public List<ToDoDto> getAllToDos() {
        List<ToDo> toDos = toDoRepository.findAll();
        List<ToDoDto> toDosDto = modelMapper.mapAll(toDos, ToDoDto.class);
        return toDosDto;
    }

    public List<ToDoDto> getToDosByStatus(String status) {
        List<ToDo> toDos = toDoRepository.findByStatus(status);
        List<ToDoDto> toDosDto = modelMapper.mapAll(toDos, ToDoDto.class);
        return toDosDto;
    }

    public ToDoDto getToDoById(Long id) {
        ToDo toDo = toDoRepository.findById(id).orElse(null);
        ToDoDto toDoDto = modelMapper.map(toDo, ToDoDto.class);
        return toDoDto;
    }

    public ToDo createToDo (CreateToDoDto toDoDto) {
        ToDo toDoEntity = modelMapper.map(toDoDto, ToDo.class);
        return toDoRepository.save(toDoEntity);
    }

    public ToDo updateToDo (ToDoDto toDoDto) {
        ToDo toDoEntity = modelMapper.map(toDoDto, ToDo.class);
        return toDoRepository.save(toDoEntity);
    }

    public void deleteToDo (Long id) {
        toDoRepository.deleteById(id);
    }
}
