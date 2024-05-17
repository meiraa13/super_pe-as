import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { TodoService } from '../../services/todo.service';
import { TTodoRequest } from '../../interfaces/todo.interface';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './form.component.html',
  styleUrl: './form.component.css'
})
export class FormComponent {
  registerForm = new FormGroup({
    title: new FormControl(null, [Validators.required, Validators.minLength(3)]),
    content: new FormControl(null, Validators.required)

  })

  constructor(private todoService:TodoService){}

  get content(){
    return this.registerForm.get('content')
  }

  get title(){
    return this.registerForm.get('title')
  }

  handleSubmit(){
    this.todoService.setTodo(this.registerForm.value)

    this.registerForm.reset()

  }



}
