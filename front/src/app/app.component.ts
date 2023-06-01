import { Component } from '@angular/core';
import { ApiService } from './service/api.service';
import { environment } from 'src/environments/environment';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})
export class AppComponent {
  title = 'front';
  date: Date;
  value: string;

  constructor(public apiService: ApiService, public router: Router) {
    this.date = null!;
    this.value = null!;
    this.router.navigate(["medicamento"]);
  }
}
