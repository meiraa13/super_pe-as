import { AfterViewInit, Component, ViewChild } from '@angular/core';
import {MatTableDataSource, MatTableModule} from '@angular/material/table';
import {MatPaginator, MatPaginatorModule} from '@angular/material/paginator';
import {MatIconModule} from '@angular/material/icon';


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
  selector: 'app-car-table',
  standalone: true,
  imports: [MatTableModule, MatPaginatorModule, MatIconModule],
  templateUrl: './car-table.component.html',
  styleUrl: './car-table.component.css'
})
export class CarTableComponent implements AfterViewInit {
  displayedColumns: string[] = ['id', 'name', 'manufacturer', 'code', 'actions'];
  dataSource = new MatTableDataSource<ITable>(ELEMENT_DATA);

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  ngAfterViewInit(): void {
    this.dataSource.paginator = this.paginator
  }

}
