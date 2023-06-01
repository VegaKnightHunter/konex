import { Route } from '@angular/router';

import { MedicamentoComponent } from './medicamento.component';
import { MedicamentoFormComponent } from './medicamentoform/medicamento.form.component';

export const routes: Route[] = [
    { path: 'medicamento', component: MedicamentoComponent},
    { path: 'medicamento/:id', component: MedicamentoFormComponent},
];