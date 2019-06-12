import { Injectable } from '@angular/core';
import { RegistracijaComponent } from '../components/registracija/registracija.component';
import { Korisnik } from '../../models/Korisnik';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegistracijaService {

  constructor(private httpClient: HttpClient) { }

  registrujKorisnika(korisnik: Korisnik)
  {
    const body: Korisnik = {
      Id : "451023",
      Ime: korisnik.Ime,
      Prezime: korisnik.Prezime,
      korisnicko_ime: korisnik.korisnicko_ime,
      Lozinka: korisnik.Lozinka
    }

    return this.httpClient.post('http://localhost:8080/register', body);
  }

  private parseData(res: Response)
  { 
    return res.json() || [];
  }
}
