package Dmap.Infotech.Assignment.service;

// Service
// TaskService.java



import Dmap.Infotech.Assignment.Dto.RequestDto.Taskrequest;
import Dmap.Infotech.Assignment.Dto.ResponseDto.TaskResponse;
import Dmap.Infotech.Assignment.Model.Task;

import java.util.List;

public interface TaskService {
    List<TaskResponse> getAllTasks();
    TaskResponse getTaskById(Long taskId);
     TaskResponse createTask(Taskrequest task);
    TaskResponse updateTask(Long taskId, Taskrequest updatedTask);
    void deleteTask(Long taskId);
}

