import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MatDialogModule, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ReactiveFormsModule } from '@angular/forms';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button'
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import { TCarRequest } from '../../interfaces/car.interface';
import { Validators } from '@angular/forms';
import { CarService } from '../../services/car.service';


@Component({
  selector: 'app-create-car-dialog',
  standalone: true,
  imports: [
    MatDialogModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatInputModule,
    MatFormFieldModule
  ],
  templateUrl: './create-car-dialog.component.html',
  styleUrl: './create-car-dialog.component.css'
})
export class CreateCarDialogComponent implements OnInit {
  inputData:any
  form!: FormGroup

  constructor(
    @Inject(MAT_DIALOG_DATA) public data:any,
    private ref:MatDialogRef<CreateCarDialogComponent>,
    private formBuilder: FormBuilder,
    private carService:CarService
  ){}

  closeDialog(){
    this.ref.close()
  }

  ngOnInit(): void {
    this.inputData = this.data
    this.form = this.formBuilder.group({
      modelName:['', [Validators.required]],
      manufacturer:['', [Validators.required]],
      uniqueCode:['', [Validators.required]]
    })
  }

  createCar(){
    const data = this.form.value as TCarRequest
    this.carService.createCar(data).subscribe((data)=>{
      window.location.reload()
    })

  }
}
