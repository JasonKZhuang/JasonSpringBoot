//Test REST API using Restlet Client adding to Chrome

package com.jasonz.controller.todo;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jasonz.bean.TodoBean;
import com.jasonz.service.TodoService;

@RestController
@RequestMapping("todo")
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
//http://localhost:8080/jasonSpringBoo/todo
public class TodoResource
{
	@Autowired
	private TodoService todoService;

	@GetMapping("/{username}/todos")
	// http://localhost:8080/jasonSpringBoot/todo/jason/todos
	public List<TodoBean> getAllTodos(@PathVariable String username)// throws InterruptedException
	{
		// Thread.sleep(3000);
		return todoService.findAll();
	}

	@GetMapping("/{username}/todos/{id}")
	// http://localhost:8080/jasonSpringBoot/todo/jason/todos/1
	public TodoBean getTodoById(@PathVariable String username, @PathVariable long id)// throws InterruptedException
	{
		// Thread.sleep(3000);
		return todoService.findById(id);
	}

	// http://localhost:8080/jasonSpringBoot/todo/jason/todos/1
	@DeleteMapping("/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable long id)
	{
		TodoBean todo = todoService.deleteById(id);
		if (todo != null)
		{
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{username}/todos/{id}")
	public ResponseEntity<TodoBean> updateTodo(
			@PathVariable String username, @PathVariable long id, @RequestBody TodoBean todo
	)
	{
		TodoBean todoUpdated = todoService.save(todo);
		return new ResponseEntity<TodoBean>(todo, HttpStatus.OK);
	}

	@PostMapping("/{username}/todos")
	public ResponseEntity<Void> createTodo(@PathVariable String username, @RequestBody TodoBean todo)
	{
		TodoBean todoCreated = todoService.save(todo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(todoCreated.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

}
