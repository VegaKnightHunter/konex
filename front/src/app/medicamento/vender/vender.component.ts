import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { ApiService } from '../../service/api.service';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-vender',
  templateUrl: './vender.component.html'
})
export class VenderComponent {

  cantidadComprar: number;

  constructor(public apiService: ApiService, public router: Router, private route: ActivatedRoute) {
    this.cantidadComprar = 0;
  }

  ngOnInit() {
  }

  public save(): void {
    console.log("hola");
    
    this.apiService.get(environment.baseUrl + 'tienda/api/vender/' + this.apiService.medicamento.id + '/' + this.cantidadComprar).subscribe({
      next: (data) => {
        console.log(data);
        window.location.reload();
        this.router.navigate(["/"]);
      },
      error: (e) => {
        var obj = e.error;
        console.log(e);
        window.location.reload();
      },
      complete: () => window.location.reload(),
    });
  }
}
