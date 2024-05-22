import { Component, ViewChild, AfterViewInit} from '@angular/core';
import { MatButtonModule } from '@angular/material/button'
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {FormsModule} from '@angular/forms';
import {MatIconModule} from '@angular/material/icon';
import {MatTableDataSource, MatTableModule} from '@angular/material/table';
import {MatPaginator, MatPaginatorModule} from '@angular/material/paginator';

export interface ITable {
  id: number;
  name: string;
  manufacturer: string;
  code: string;
}

const ELEMENT_DATA: ITable[] = [
  {id: 1, name: 'Civic', manufacturer: 'Honda', code: 'HJQQER424'},
  {id: 2, name: 'A4', manufacturer: 'Audi', code: 'HJQQfaer4'},
  {id: 3, name: 'Polo', manufacturer: 'Volkswagen', code: '1RFQER424'},
  {id: 3, name: 'Polo', manufacturer: 'Volkswagen', code: '1RFQER424'},
  {id: 3, name: 'Polo', manufacturer: 'Volkswagen', code: '1RFQER424'},
  {id: 3, name: 'Polo', manufacturer: 'Volkswagen', code: '1RFQER424'},
  {id: 3, name: 'Polo', manufacturer: 'Volkswagen', code: '1RFQER424'},
  {id: 3, name: 'Polo', manufacturer: 'Volkswagen', code: '1RFQER424'},
  {id: 3, name: 'Polo', manufacturer: 'Volkswagen', code: '1RFQER424'},
  {id: 3, name: 'Polo', manufacturer: 'Volkswagen', code: '1RFQER424'},
  {id: 3, name: 'Polo', manufacturer: 'Volkswagen', code: '1RFQER424'},
  {id: 3, name: 'Polo', manufacturer: 'Volkswagen', code: '1RFQER424'},
  {id: 3, name: 'Polo', manufacturer: 'Volkswagen', code: '1RFQER424'},



];


@Component({
  selector: 'app-car',
  standalone: true,
  imports: [
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    MatIconModule,
    MatTableModule,
    MatPaginatorModule
  ],
  templateUrl: './car.component.html',
  styleUrl: './car.component.css'
})
export class CarComponent implements AfterViewInit {
  displayedColumns: string[] = ['id', 'name', 'manufacturer', 'code', 'actions'];
  dataSource = new MatTableDataSource<ITable>(ELEMENT_DATA);

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  ngAfterViewInit(): void {
    this.dataSource.paginator = this.paginator
  }




}


