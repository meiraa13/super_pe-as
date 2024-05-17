import { Injectable, signal } from "@angular/core";
import { ITodo, TTodoRequest } from "../interfaces/todo.interface";

@Injectable()
export class TodoService {
  readonly todoList = signal<ITodo[]>([])
  // private todoList:ITodo[] = []

  getTodo(){
    return this.todoList()
  }

  setTodo(data: TTodoRequest){
    const newTodo:ITodo = {
      ...data,
      id: crypto.randomUUID()
    }

    this.todoList.update((currentList)=>[...currentList,newTodo])
  }

  removeToDo(id:string){
    this.todoList.update((currentList)=> currentList.filter((item)=> item.id !== id))
  }
}
