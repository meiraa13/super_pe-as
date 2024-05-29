import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ICar, ICarResponse, TCarRequest } from '../interfaces/car.interface';

@Injectable({
  providedIn: 'root'
})
export class CarService {

  private baseUrl = 'http://localhost:8080'
  constructor(private http: HttpClient) { }

  getCars(){
    return this.http.get<ICar[]>(`${this.baseUrl}/carro/listaTodos`)
  }

  createCar(data:TCarRequest){
    return this.http.post<ICarResponse>(`${this.baseUrl}/carro`, data)
  }

  deleteCar(id:any){
    return this.http.delete(`${this.baseUrl}/carro/${id}`)
  }
}
