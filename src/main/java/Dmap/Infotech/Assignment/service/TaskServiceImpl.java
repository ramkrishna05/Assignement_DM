package Dmap.Infotech.Assignment.service;


import Dmap.Infotech.Assignment.Dto.RequestDto.Taskrequest;
import Dmap.Infotech.Assignment.Dto.ResponseDto.TaskResponse;
import Dmap.Infotech.Assignment.Ecxeption.TaskNotFound;
import Dmap.Infotech.Assignment.Model.Task;
import Dmap.Infotech.Assignment.reposiotory.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static ch.qos.logback.classic.spi.ThrowableProxyVO.build;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<TaskResponse> getAllTasks() {

        List<Task> tasks= taskRepository.findAll();
        List<TaskResponse>taskResponseList=new ArrayList<>();
        for (Task task:tasks)
        {
            TaskResponse taskResponse=TaskResponse.builder()
                    .title(task.getTitle())
                    .id(task.getId())
                    .description(task.getDescription())
                    .build();
            taskResponseList.add(taskResponse);
        }
        return taskResponseList;
    }

    @Override
    public TaskResponse getTaskById(Long taskId) {

         Optional<Task>optionalTask =taskRepository.findById(taskId);
         if(optionalTask.isEmpty())
         {
             throw new TaskNotFound("id is invalid");
         }
         Task task=optionalTask.get();
         return TaskResponse.builder()
                 .title(task.getTitle())
                 .description(task.getDescription())
                 .id(task.getId())
                 .build();

    }

    @Override
    public TaskResponse createTask(Taskrequest task) {
        Task task1=Task.builder()
                .title(task.getTitle())
                .description(task.getDescription())
                .build();
       Task task2=  taskRepository.save(task1);
       return TaskResponse.builder()
               .title(task2.getTitle())
               .description(task2.getDescription())
               .id(task2.getId())
               .build();
    }

    @Override
    public TaskResponse updateTask(Long taskId, Taskrequest updatedTask) {
        Optional<Task> optionalTask = taskRepository.findById(taskId);
        if (optionalTask.isEmpty())
        {
            throw new TaskNotFound("task id invalide");
        }
        Task task=optionalTask.get();
        task.setDescription(updatedTask.getDescription());
        task.setTitle(updatedTask.getTitle());
        Task task1=taskRepository.save(task);
        return TaskResponse.builder()
                .id(task1.getId())
                .description(task1.getDescription())
                .title(task1.getTitle())
                .build();


    }

    @Override
    public void deleteTask(Long taskId) {
        Optional<Task>optionalTask=taskRepository.findById(taskId);
        if (optionalTask.isEmpty())
        {
            throw new TaskNotFound("task id is invalide");
        }
        taskRepository.deleteById(taskId);
    }
}
