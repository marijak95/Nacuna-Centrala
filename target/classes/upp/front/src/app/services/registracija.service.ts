import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {Korisnik} from '../models/korisnik';

@Injectable({
  providedIn: 'root'
})
export class RegistracijaService {

  private formFieldsDto = null;
  private formFields = [];
  private taskId = "";

  constructor(private httpClient: HttpClient) { }

  register(korisnik: Korisnik)
  {
    const body: Korisnik = {
      id: korisnik.id,
      ime: korisnik.ime,
      prezime: korisnik.prezime,
      email: korisnik.email,
      password: korisnik.password,
    }

    return this.httpClient.post('https://localhost:8080/register', body);
  }

  private parseData(res: Response)
  { 
    return res.json() || [];
  }
  
}
