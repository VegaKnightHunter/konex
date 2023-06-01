import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable, throwError } from 'rxjs';
import { retry, catchError, map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  private headers: HttpHeaders;
  public authenticated: boolean;
  public medicamento: any;

  constructor( private httpClient: HttpClient, private router: Router ) {
    this.authenticated = false;
    this.headers = new HttpHeaders();
    this.headers.append('Content-Type', 'application/json');
    this.medicamento = null;
  }

  public get(url: string, params: any = null) {
    let options = { headers: this.headers, params: params, withCredentials: true }
    return this.httpClient.get(url, options);
  }

  public post(url: string, object: any, params: any = null): Observable<any> {
    let options = { headers: this.headers, params: params, withCredentials: true };
    return this.httpClient.post(url, object, options);
  }

  public put(url: string, id: any, object: any) {
    let options = { headers: this.headers, withCredentials: true };
    return this.httpClient.put(url + "/" + id, object, options)
      .pipe(
        catchError(this.handleError)
      )
  }

  public delete(url: string) {
    let options = { headers: this.headers, withCredentials: true };
    return this.httpClient.delete(url, options);
  }


  handleError(error: any) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      // Get client-side error
      errorMessage = error.error[1];
    } else {
      // Get server-side error
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.error[1]}`;
    }
    if (error.status == 402) {
      window.alert(errorMessage);
    } else {
      console.error(error);
    }
    return throwError(errorMessage);
  }
}