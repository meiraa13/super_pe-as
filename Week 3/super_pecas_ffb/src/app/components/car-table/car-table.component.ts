import { Component, OnInit, signal } from '@angular/core';
import {MatIconModule} from '@angular/material/icon';
import { CarService } from '../../services/car.service';
import { ICar } from '../../interfaces/car.interface';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import {MatSnackBarModule, MatSnackBar} from '@angular/material/snack-bar';



@Component({
  selector: 'app-car-table',
  standalone: true,
  imports: [ MatIconModule, CommonModule, MatSnackBarModule],
  templateUrl: './car-table.component.html',
  styleUrl: './car-table.component.css'
})
export class CarTableComponent implements OnInit  {
  readonly carList = signal<ICar[]>([])

  constructor(
    private carService:CarService,
    private router: Router,
    private snackBar:MatSnackBar
  ){}

  ngOnInit(): void {
      this.carService.getCars().subscribe((data)=>{
        this.carList.set(data)
      })
  }

  deleteCar(id:any){
    this.carService.deleteCar(id).subscribe({
      next:(res)=>{
        this.carList.update((currentList)=> currentList.filter((item)=>item.id !== id))
        this.snackBar.open("Deletado com sucesso", 'ok',{
          duration:1000,
          verticalPosition:'top'
        })


      },error:(err)=>{
        console.log(err)
        this.snackBar.open("erro na requisição", 'ok',{
          duration:1000,
          verticalPosition:'top'
        })
      }
    })
  }

  carDetail(productId:number){
    this.router.navigate(['car', productId])
  }
}
