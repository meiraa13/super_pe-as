import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormComponent } from './components/form/form.component';
import { UserService } from './services/user.service';
import { TodoCardComponent } from './components/todo-card/todo-card.component';
import { TodoService } from './services/todo.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, CommonModule, FormComponent, TodoCardComponent],
  providers:[TodoService],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'super_pecas_ffb';


  constructor(private todoService:TodoService){}

  get todoList(){
    return this.todoService.getTodo()
  }
}
