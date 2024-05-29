import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import {MatTableDataSource, MatTableModule} from '@angular/material/table';
import {MatPaginator, MatPaginatorModule} from '@angular/material/paginator';
import {MatIconModule} from '@angular/material/icon';
import { CarService } from '../../services/car.service';
import { ICar } from '../../interfaces/car.interface';


@Component({
  selector: 'app-car-table',
  standalone: true,
  imports: [MatTableModule, MatPaginatorModule, MatIconModule],
  templateUrl: './car-table.component.html',
  styleUrl: './car-table.component.css'
})
export class CarTableComponent implements OnInit {
  displayedColumns: string[] = ['id', 'name', 'manufacturer', 'code', 'actions'];
  dataSource = new MatTableDataSource<ICar>;

  constructor(private carService:CarService){}

  //@ViewChild(MatPaginator) paginator!: MatPaginator;

  ngOnInit(): void {
      this.carService.getCars()
      .subscribe(cars => {
        this.dataSource = new MatTableDataSource<ICar>(cars)
      })
  }
  // ngAfterViewInit(): void {
  //   this.dataSource.paginator = this.paginator
  // }

}
