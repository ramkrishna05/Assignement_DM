package Dmap.Infotech.Assignment.Controller;





import Dmap.Infotech.Assignment.Dto.RequestDto.Taskrequest;
import Dmap.Infotech.Assignment.Dto.ResponseDto.TaskResponse;
import Dmap.Infotech.Assignment.Model.Task;
import Dmap.Infotech.Assignment.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/get-all-task")
    public ResponseEntity<List<TaskResponse>> getAllTasks() {
        List<TaskResponse> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("get-task/{taskId}")
    public ResponseEntity  getTaskById(@PathVariable Long taskId) {
        TaskResponse task = taskService.getTaskById(taskId);

       try {
            return new ResponseEntity<>(task, HttpStatus.OK);
        }
       catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("create-task")
    public ResponseEntity<TaskResponse> createTask(@RequestBody Taskrequest task) {
        TaskResponse  createdTask = taskService.createTask(task);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    @PutMapping("update/{taskId}")
    public ResponseEntity  updateTask(@PathVariable Long taskId, @RequestBody Taskrequest updatedTask) {
        TaskResponse  updated = taskService.updateTask(taskId, updatedTask);

        try {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>( e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("delete/{taskId}")
    public ResponseEntity  deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
       try
       {
        return new ResponseEntity("task Delete Done",HttpStatus.OK)   ;
       }
       catch (Exception e)
       {
           return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
       }
    }
}

