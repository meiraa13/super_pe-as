import { Component, Input } from '@angular/core';
import { ITodo } from '../../interfaces/todo.interface';
import { TodoService } from '../../services/todo.service';

@Component({
  selector: 'app-todo-card',
  standalone: true,
  imports: [],
  templateUrl: './todo-card.component.html',
  styleUrl: './todo-card.component.css'
})
export class TodoCardComponent {

  @Input() todo!:ITodo

  constructor(private todoService:TodoService){}

  handleClick(id:string){
    this.todoService.removeToDo(id)
  }
}
