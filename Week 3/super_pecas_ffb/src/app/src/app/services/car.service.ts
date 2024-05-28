import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ICar } from '../interfaces/car.interface';

@Injectable({
  providedIn: 'root'
})
export class CarService {

  private baseUrl = 'http://localhost:8080'
  constructor(private http: HttpClient) { }

  getCars(){
    return this.http.get<ICar[]>(`${this.baseUrl}/carro/listaTodos`)
  }
}
