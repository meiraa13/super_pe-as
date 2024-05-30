import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { CarComponent } from './pages/car/car.component';
import { PieceComponent } from './pages/piece/piece.component';
import { CarDetailComponent } from './pages/car-detail/car-detail.component';

export const routes: Routes = [
  { path: "", component: HomeComponent },
  { path: "car", component:CarComponent },
  { path: "piece", component:PieceComponent },
  { path: "car/:id", component:CarDetailComponent }
];
