package ru.sergeypyzin.springdatajpa.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sergeypyzin.springdatajpa.TaskStatus;
import ru.sergeypyzin.springdatajpa.model.Task;
import ru.sergeypyzin.springdatajpa.service.TaskService;

import java.util.List;


/**
 * Контроллер для управления задачами.
 */
@AllArgsConstructor
@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    /**
     * Создает новую задачу.
     *
     * @param task Новая задача, которую необходимо создать.
     * @return Созданная задача.
     */
    @PostMapping("/create")
    public Task addTask(@RequestBody Task task) {
        return service.createTask(task);
    }

    /**
     * Получение списка всех задач.
     *
     * @return список всех задач
     */
    @GetMapping
    public List<Task> getAllTask() {
        return service.getAllTask();
    }

    /**
     * Получение списка задач по указанному статусу.
     *
     * @param status Статус задачи, по которому нужно получить список.
     * @return Список задач с указанным статусом.
     */
    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status) {
        return service.getAllTasksByStatus(status);
    }

    /**
     * Получение задачи по идентификатору.
     *
     * @param id Идентификатор задачи.
     * @return Объект задачи с указанным идентификатором или null, если задача не найдена.
     */
    @GetMapping("/id/{id}")
    public Task getTaskByID(@PathVariable Long id){
        return service.getTaskByID(id);
    }

    /**
     * Метод для обновления задачи по идентификатору.
     *
     * @param id   идентификатор задачи
     * @param task объект задачи с обновленными данными
     * @return обновленный объект задачи
     */
    @PutMapping("/update/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        return service.updateTask(id, task);
    }

    /**
     * Обновляет статус задачи по идентификатору.
     *
     * @param id   Идентификатор задачи, чей статус нужно обновить.
     * @param task Объект задачи с обновленным статусом.
     * @return Обновленный объект задачи.
     */
    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task) {
        return service.updateTaskStatus(id, task);
    }

    /**
     * Метод для удаления задачи по идентификатору.
     *
     * @param id Идентификатор задачи, которую необходимо удалить.
     * @return Сообщение о результате удаления задачи.
     */
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {
        return service.deletedByID(id);
    }

}
