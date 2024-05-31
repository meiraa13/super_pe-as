import { Component, OnInit, signal } from '@angular/core';
import { MatButtonModule } from '@angular/material/button'
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {FormsModule} from '@angular/forms';
import {MatIconModule} from '@angular/material/icon';
import { CarTableComponent } from '../../components/car-table/car-table.component';
import {MatDialog, MatDialogModule} from '@angular/material/dialog';
import { CreateCarDialogComponent } from '../../components/create-car-dialog/create-car-dialog.component';
import { ICar } from '../../interfaces/car.interface';
import { CarService } from '../../services/car.service';



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
export class CarComponent implements OnInit {

  readonly carList = signal<ICar[]>([])

  constructor(
    private _dialog:MatDialog,
    private _carService:CarService
  ){}

  ngOnInit(): void {
    this._carService.getCars().subscribe((data)=>{
      this.carList.set(data)
    })
  }

  openDialog(){
    this._dialog.open(CreateCarDialogComponent,{
      width:"40%",
      data:{
        title:"Cadastro de Carro",
        list:this.carList
      }
    })
  }

}


