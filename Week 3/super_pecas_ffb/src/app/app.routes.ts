import { Routes } from '@angular/router';
import { HomeComponent } from './src/app/pages/home/home.component';
import { CarComponent } from './src/app/pages/car/car.component';
import { PieceComponent } from './src/app/pages/piece/piece.component';

export const routes: Routes = [
  { path: "", component: HomeComponent },
  { path: "car", component:CarComponent },
  { path: "piece", component:PieceComponent }
];
