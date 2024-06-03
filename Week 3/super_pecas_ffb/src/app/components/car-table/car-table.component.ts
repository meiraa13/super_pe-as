import { Component, Input, WritableSignal } from '@angular/core';
import {MatIconModule} from '@angular/material/icon';
import { ICar } from '../../interfaces/car.interface';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import {MatSnackBarModule } from '@angular/material/snack-bar';
import {MatDialog, MatDialogModule} from '@angular/material/dialog';
import { DeleteConfirmationDialogComponent } from '../delete-confirmation-dialog/delete-confirmation-dialog.component';



@Component({
  selector: 'app-car-table',
  standalone: true,
  imports: [ MatIconModule, CommonModule, MatSnackBarModule, MatDialogModule],
  templateUrl: './car-table.component.html',
  styleUrl: './car-table.component.css'
})
export class CarTableComponent   {
  @Input() carList!:WritableSignal<ICar[]>
  //or
  //carList = input.required<ICar[]>()

  constructor(
    private _router: Router,
    private _dialog: MatDialog
  ){}



  carDetail(productId:number){
    this._router.navigate(['car', productId])
  }

  openDialog(id:number){
    this._dialog.open(DeleteConfirmationDialogComponent,{
      width:"30%",
      data:{
        id:id,
        list:this.carList
      }
    })
  }
}
