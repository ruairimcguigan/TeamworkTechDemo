package demo.teamwork.aquidigital.repository.api.tasksmodel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TasksResponse{

	@SerializedName("STATUS")
	private String status;

	@SerializedName("todo-items")
	private List<TodoItemsItem> todoItems;

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	public void setTodoItems(List<TodoItemsItem> todoItems){
		this.todoItems = todoItems;
	}

	public List<TodoItemsItem> getTodoItems(){
		return todoItems;
	}

	@Override
 	public String toString(){
		return 
			"TasksResponse{" + 
			"status = '" + status + '\'' +
			",todo-items = '" + todoItems + '\'' + 
			"}";
		}
}