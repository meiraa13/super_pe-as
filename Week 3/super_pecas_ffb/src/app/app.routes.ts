import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { CarComponent } from './pages/car/car.component';
import { PieceComponent } from './pages/piece/piece.component';

export const routes: Routes = [
  { path: "", component: HomeComponent },
  { path: "car", component:CarComponent },
  { path: "piece", component:PieceComponent }
];
