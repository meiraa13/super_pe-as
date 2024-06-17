import { Component, OnInit } from '@angular/core';
import { CarService } from '../../services/car.service';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { ICar } from '../../interfaces/car.interface';
import {MatCardModule} from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button'
import {MatIconModule} from '@angular/material/icon';
import {MatDialog, MatDialogModule} from '@angular/material/dialog';
import { DeleteConfirmationDialogComponent } from '../../components/delete-confirmation-dialog/delete-confirmation-dialog.component';

@Component({
  selector: 'app-car-detail',
  standalone: true,
  imports: [MatCardModule, MatButtonModule,MatIconModule, MatDialogModule, RouterLink],
  templateUrl: './car-detail.component.html',
  styleUrl: './car-detail.component.css'
})
export class CarDetailComponent implements OnInit {
  car!:ICar
  constructor(
    private _carService:CarService, 
    private _activatedRoute:ActivatedRoute,
    private _dialog:MatDialog
  ){}

  ngOnInit(): void {
    //this.id = this.activatedRoute.snapshot.url[1].path)
    //or
    this._activatedRoute.paramMap.subscribe((params)=>{
      this._carService.getCarById(params.get('id')).subscribe({
        next: (data)=>{
          this.car = data
        },
        error:(err)=>{
          console.log(err)
        }
      })
    })
  }

  openDeleteDialog(){
    this._dialog.open(DeleteConfirmationDialogComponent, {
      width:"30%",
      data:{
        id:this.car.id

      }
    })
  }

}
