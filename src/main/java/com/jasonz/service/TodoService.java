package com.jasonz.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jasonz.bean.TodoBean;

@Service
public class TodoService
{
	private static List<TodoBean> todos = new ArrayList<>();
	private static int idCounter = 0;

	static
	{
		todos.add(new TodoBean(++idCounter, "Jason", "React 111", new Date(), false));
		todos.add(new TodoBean(++idCounter, "Jason", "React 222", new Date(), false));
		todos.add(new TodoBean(++idCounter, "Jason", "React 333", new Date(), true));
		todos.add(new TodoBean(++idCounter, "Jason", "React 444", new Date(), true));
		todos.add(new TodoBean(++idCounter, "Peter", "Angular 111", new Date(), true));
		todos.add(new TodoBean(++idCounter, "Peter", "Angular 222", new Date(), true));
		todos.add(new TodoBean(++idCounter, "Peter", "Angular 333", new Date(), true));
		todos.add(new TodoBean(++idCounter, "Bob", "Microservice 111", new Date(), true));
		todos.add(new TodoBean(++idCounter, "Bob", "Microservice 222", new Date(), true));
		todos.add(new TodoBean(++idCounter, "Bob", "Microservice 333", new Date(), true));
	}

	public List<TodoBean> findAll()
	{
		return todos;
	}

	public TodoBean deleteById(long id)
	{
		TodoBean todo = findById(id);
		if (todo == null)
			return null;

		if (todos.remove(todo))
		{
			return todo;
		}
		return null;
	}

	public TodoBean findById(long id)
	{
		for (TodoBean todo : todos)
		{
			if (todo.getId() == id)
			{
				return todo;
			}
		}
		return null;
	}

	public TodoBean save(TodoBean todo)
	{
		if (todo.getId() == -1 || todo.getId() == 0)
		{
			todo.setId(++	idCounter);
			todos.add(todo);
		} else
		{
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}

}
