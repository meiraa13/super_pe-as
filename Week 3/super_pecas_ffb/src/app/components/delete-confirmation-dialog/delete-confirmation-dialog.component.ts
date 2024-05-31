import { Component, Inject, WritableSignal } from '@angular/core';
import { MatDialogRef, MatDialogModule, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button'
import { CarService } from '../../services/car.service';
import {MatSnackBarModule, MatSnackBar} from '@angular/material/snack-bar';
import { IDeleteDialog, } from '../../interfaces/car.interface';

@Component({
  selector: 'app-delete-confirmation-dialog',
  standalone: true,
  imports: [MatDialogModule, MatButtonModule],
  templateUrl: './delete-confirmation-dialog.component.html',
  styleUrl: './delete-confirmation-dialog.component.css'
})



export class DeleteConfirmationDialogComponent {

  constructor(
    @Inject(MAT_DIALOG_DATA) public _dialogData:IDeleteDialog,
    private _carService:CarService,
    private _snackBar:MatSnackBar
  ){}

  deleteCar(){
    this._carService.deleteCar(this._dialogData.id).subscribe({
      next:(res)=>{
        this._dialogData.list.update((currentList)=> currentList.filter((item)=>item.id !== this._dialogData.id))
        this._snackBar.open("Deletado com sucesso", 'ok',{
          duration:2000,
          verticalPosition:'top'
        })


      },error:(err)=>{
        console.log(err)
        this._snackBar.open("erro na requisição", 'ok',{
          duration:2000,
          verticalPosition:'top'
        })
      }
    })
  }
}
