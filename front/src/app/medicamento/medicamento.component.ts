import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { DialogService, DynamicDialogRef } from 'primeng/dynamicdialog';

import { MedicamentoDto } from '../dto/medicamento.dto';
import { ApiService } from '../service/api.service';
import { environment } from 'src/environments/environment';

import { VenderComponent } from './vender/vender.component'

@Component({
  selector: 'app-medicamento',
  templateUrl: './medicamento.component.html',
  providers: [DialogService]
})
export class MedicamentoComponent {

  medicamentos: any[];
  ref: DynamicDialogRef;
  filter: any;

  constructor(public apiService: ApiService, public router: Router, public dialogService: DialogService){
    this.medicamentos = [];
    this.ref = null!;
    this.getList();
    this.filter = '';
  }

  public create(): void {
    this.router.navigate(["medicamento", '0']);
  }

  public getList() {
    this.apiService.get(environment.baseUrl + 'medicamentos/api/medicamento/', {}).subscribe((data: any) => {
      this.medicamentos = data;
    });
  }
  public update(id: any) {
    this.router.navigate(["medicamento", id]);
  }
  public delete(id: any) {
    this.apiService.delete(environment.baseUrl + 'medicamentos/api/medicamento/' + id).subscribe((data: any) => {
      this.getList();
    });
  }
  public vender(obj: any) {
    this.apiService.medicamento = obj;
    this.ref = this.dialogService.open(VenderComponent, { header: 'Vender'});
  }
  public search() {
    this.apiService.get(environment.baseUrl + 'medicamentos/api/medicamento/', {}).subscribe((data: any) => {
      this.medicamentos = data;
    });
  }
}
