export class MedicamentoDto {
    nombre: string;
    laboratorioFabrica: string;
    fechaFabricacion: Date;
    fechaVencimiento: Date;
    cantidadStock: number;
    valor: number;

    constructor() {
        this.nombre = '';
        this.laboratorioFabrica = '';
        this.fechaFabricacion = null!;
        this.fechaVencimiento = null!;
        this.cantidadStock = 0;
        this.valor = 0;
    }
}