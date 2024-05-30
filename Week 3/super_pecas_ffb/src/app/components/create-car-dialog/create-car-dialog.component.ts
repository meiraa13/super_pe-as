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
import {MatSnackBarModule, MatSnackBar} from '@angular/material/snack-bar';


@Component({
  selector: 'app-create-car-dialog',
  standalone: true,
  imports: [
    MatDialogModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatInputModule,
    MatFormFieldModule,
    MatSnackBarModule
  ],
  templateUrl: './create-car-dialog.component.html',
  styleUrl: './create-car-dialog.component.css'
})
export class CreateCarDialogComponent implements OnInit {
  inputData:any
  form!: FormGroup

  constructor(
    @Inject(MAT_DIALOG_DATA) public _dialogData:any,
    private _ref:MatDialogRef<CreateCarDialogComponent>,
    private _formBuilder: FormBuilder,
    private _carService:CarService,
    private _snackBar:MatSnackBar
  ){}

  closeDialog(){
    this._ref.close()
  }

  ngOnInit(): void {
    this.inputData = this._dialogData
    this.form = this._formBuilder.group({
      modelName:['', [Validators.required]],
      manufacturer:['', [Validators.required]],
      uniqueCode:['', [Validators.required]]
    })
  }

  createCar(){
    const data = this.form.value as TCarRequest
    this._carService.createCar(data).subscribe({
      next:(res)=>{
        this._snackBar.open("criado com sucesso", 'ok',{
          duration:1000,
          verticalPosition:'top'
        })
        setTimeout(()=>{
          window.location.reload()
        },1000)

      },error:(err)=>{
        console.log(err)
        this._snackBar.open("erro na requisição", 'ok',{
          duration:1000,
          verticalPosition:'top'
        })
      }
    })

  }
}
