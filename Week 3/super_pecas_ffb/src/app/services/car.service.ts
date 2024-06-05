import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ICar, TCarRequest } from '../interfaces/car.interface';

@Injectable({
  providedIn: 'root'
})
export class CarService {

  private baseUrl = 'http://localhost:8080'
  constructor(private http: HttpClient) { }

  getCars(){
    return this.http.get<ICar[]>(`${this.baseUrl}/carro/listaTodos`)
  }


  getCarById(id:string | null){
    return this.http.get<ICar>(`${this.baseUrl}/carro/${id}`)
  }


  createCar(data:TCarRequest){
    return this.http.post<ICar>(`${this.baseUrl}/carro`, data)
  }

  deleteCar(id:any){
    return this.http.delete(`${this.baseUrl}/carro/${id}`)
  }
}
