import { Component } from '@angular/core';
import { MatButtonModule } from '@angular/material/button'
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {FormsModule} from '@angular/forms';
import {MatIconModule} from '@angular/material/icon';
import { CarTableComponent } from '../../components/car-table/car-table.component';



@Component({
  selector: 'app-car',
  standalone: true,
  imports: [
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    MatIconModule,
    CarTableComponent
  ],
  templateUrl: './car.component.html',
  styleUrl: './car.component.css'
})
export class CarComponent {




}


