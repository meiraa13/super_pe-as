import { Component, OnInit } from '@angular/core';
import { CarService } from '../../services/car.service';
import { ActivatedRoute } from '@angular/router';
import { ICar } from '../../interfaces/car.interface';
import {MatCardModule} from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button'
import {MatIconModule} from '@angular/material/icon';

@Component({
  selector: 'app-car-detail',
  standalone: true,
  imports: [MatCardModule, MatButtonModule,MatIconModule],
  templateUrl: './car-detail.component.html',
  styleUrl: './car-detail.component.css'
})
export class CarDetailComponent implements OnInit {
  car!:ICar
  constructor(private carService:CarService, private activatedRoute:ActivatedRoute){}

  ngOnInit(): void {
    //this.id = this.activatedRoute.snapshot.url[1].path)
    //or
    this.activatedRoute.paramMap.subscribe((params)=>{
      this.carService.getCarById(params.get('id')).subscribe((data)=>{
        this.car = data
      })

    })

  }

}
