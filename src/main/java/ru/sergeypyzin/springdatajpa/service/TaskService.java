package ru.sergeypyzin.springdatajpa.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sergeypyzin.springdatajpa.enums.TaskStatus;
import ru.sergeypyzin.springdatajpa.model.Task;
import ru.sergeypyzin.springdatajpa.repository.TaskRepository;

import java.util.List;
import java.util.Optional;


/**
 *  * Контроллер для управления задачами.
 */
@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    /**
     * Получает все задачи из репозитория.
     *
     * @return список всех задач
     */
    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    /**
     * Получает задачу по её идентификатору.
     *
     * @param id идентификатор задачи
     * @return объект задачи, если найден, в противном случае возвращает null
     */
    public Task getTaskByID(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    /**
     * Создает новую задачу.
     *
     * @param task Задача для создания.
     * @return Созданная задача.
     */
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    /**
     * Метод для обновления задачи по её идентификатору.
     *
     * @param id           идентификатор задачи, которую нужно обновить
     * @param taskToChange объект задачи с новыми данными
     * @return обновленный объект задачи
     * @throws IllegalArgumentException если задача с указанным идентификатором не найдена
     */
    public Task updateTask(Long id, Task taskToChange) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setDescription(taskToChange.getDescription());
            task.setTaskStatus(taskToChange.getTaskStatus());
            task.setCreationTime(taskToChange.getCreationTime());
            return taskRepository.save(task);
        } else {
            throw new IllegalArgumentException("Задача с идентификатором " + id + " не найдена");
        }
    }

    /**
     * Метод для обновления статуса задачи по идентификатору.
     *
     * @param id             идентификатор задачи
     * @param taskForChange  объект задачи с обновленным статусом
     * @return обновленный объект задачи
     * @throws IllegalArgumentException если задача с указанным идентификатором не найдена
     */
    public Task updateTaskStatus(Long id, Task taskForChange) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setTaskStatus(taskForChange.getTaskStatus());
            return taskRepository.save(task);
        } else {
            throw new IllegalArgumentException("Task with id " + id + " not found");
        }
    }

    /**
     * Метод для удаления задачи по идентификатору.
     *
     * @param id идентификатор задачи, которую необходимо удалить
     * @return сообщение о успешном удалении задачи
     */
    public String deletedByID(Long id) {
        taskRepository.deleteById(id);
        return "Задача с идентификатором " + id + " была удалена";
    }

    /**
     * Получение всех задач по указанному статусу.
     *
     * @param status статус задачи, по которому осуществляется фильтрация
     * @return список задач с указанным статусом
     */
    public List<Task> getAllTasksByStatus(TaskStatus status){
        return taskRepository
                .findAll()
                .stream()
                .filter(el -> el.getTaskStatus() == status)
                .toList();
    }

}
