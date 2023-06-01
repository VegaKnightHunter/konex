import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { PanelModule } from 'primeng/panel';
import { CardModule } from 'primeng/card';
import { CalendarModule } from 'primeng/calendar';
import { InputTextModule } from 'primeng/inputtext';
import { TableModule } from 'primeng/table';
import { DynamicDialogModule } from 'primeng/dynamicdialog';

import { routes } from './medicamento.routes';
import { MedicamentoComponent } from './medicamento.component';
import { MedicamentoFormComponent } from './medicamentoform/medicamento.form.component';
import { VenderComponent } from './vender/vender.component';

@NgModule({
    imports: [
        BrowserModule,
        HttpClientModule,
        FormsModule,
        CardModule,
        CalendarModule,
        InputTextModule,
        PanelModule,
        TableModule,
        DynamicDialogModule,
        RouterModule.forChild(routes),
    ],
    declarations: [
        MedicamentoComponent,
        MedicamentoFormComponent,
        VenderComponent
    ],
    exports: [RouterModule]
})

export class MedicamentoModule { }