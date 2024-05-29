import { Component } from '@angular/core';
import { MatButtonModule } from '@angular/material/button'
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {FormsModule} from '@angular/forms';
import {MatIconModule} from '@angular/material/icon';
import { CarTableComponent } from '../../components/car-table/car-table.component';
import {MatDialog, MatDialogModule} from '@angular/material/dialog';
import { CreateCarDialogComponent } from '../../components/create-car-dialog/create-car-dialog.component';



@Component({
  selector: 'app-car',
  standalone: true,
  imports: [
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    MatIconModule,
    CarTableComponent,
    MatDialogModule,

  ],
  templateUrl: './car.component.html',
  styleUrl: './car.component.css'
})
export class CarComponent {


  constructor(private dialog:MatDialog){}

  openDialog(){
    this.dialog.open(CreateCarDialogComponent,{
      width:"40%",
      data:{
        title:"Cadastro de Carro"
      }
    })
  }

}


