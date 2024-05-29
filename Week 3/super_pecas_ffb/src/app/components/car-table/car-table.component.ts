import { Component, OnInit, signal } from '@angular/core';
import {MatIconModule} from '@angular/material/icon';
import { CarService } from '../../services/car.service';
import { ICar } from '../../interfaces/car.interface';
import { CommonModule } from '@angular/common';



@Component({
  selector: 'app-car-table',
  standalone: true,
  imports: [ MatIconModule, CommonModule],
  templateUrl: './car-table.component.html',
  styleUrl: './car-table.component.css'
})
export class CarTableComponent implements OnInit  {
  readonly carList = signal<ICar[]>([])

  constructor(private carService:CarService){}

  ngOnInit(): void {
      this.carService.getCars().subscribe((data)=>{
        this.carList.set(data)
      })
  }

  deleteCar(id:any){
    this.carService.deleteCar(id).subscribe((data)=>{
      this.carList.update((currentList)=> currentList.filter((item)=>item.id !== id))
    })
  }
}
