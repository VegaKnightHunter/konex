import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { MedicamentoDto } from '../../dto/medicamento.dto';
import { ApiService } from '../../service/api.service';
import { environment } from 'src/environments/environment';
import * as moment from 'moment';

@Component({
  selector: 'app-medicamentoform',
  templateUrl: './medicamento.form.component.html'
})
export class MedicamentoFormComponent {

  title = '';
  request: MedicamentoDto;
  public id: string;

  constructor(public apiService: ApiService, public router: Router, private route: ActivatedRoute) {
    this.request = new MedicamentoDto();
    this.id = this.route.snapshot.paramMap.get('id')!;
  }

  ngOnInit() {
    if(this.id == '0') {
      this.title = 'Crear Persona';
    } else {
      this.title = 'Editar Persona';
      this.apiService.get(environment.baseUrl + 'medicamentos/api/medicamento/'+ this.id, {}).subscribe((data: any) => {
        data.fechaFabricacion = new Date(data.fechaFabricacion);
        data.fechaFabricacion.setDate(data.fechaFabricacion.getDate() + 1);
        data.fechaVencimiento = new Date(data.fechaVencimiento);
        data.fechaVencimiento.setDate(data.fechaVencimiento.getDate() + 1);
        this.request = data;
      });
    }
  }

  public save(): void {
    this.apiService.post(environment.baseUrl + 'medicamentos/api/medicamento', this.request, {}).subscribe({
      next: (data) => {
        console.log(data);
      },
      error: (e) => {
        var obj = e.error;
        console.log(e);
      },
      complete: () => this.router.navigate(["medicamento"]),
    });
  }
}
