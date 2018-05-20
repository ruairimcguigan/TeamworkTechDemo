package demo.teamwork.aquidigital.repository.api.tasksmodel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TasksResponse{

	@SerializedName("STATUS")
	private String sTATUS;

	@SerializedName("todo-items")
	private List<TodoItemsItem> todoItems;

	public void setSTATUS(String sTATUS){
		this.sTATUS = sTATUS;
	}

	public String getSTATUS(){
		return sTATUS;
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
			"sTATUS = '" + sTATUS + '\'' + 
			",todo-items = '" + todoItems + '\'' + 
			"}";
		}
}