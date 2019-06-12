import { Component, OnInit } from '@angular/core';
import { Korisnik } from '../../../models/Korisnik';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { RegistracijaService } from '../../services/registracija.service';

@Component({
  selector: 'app-registracija',
  templateUrl: './registracija.component.html',
  styleUrls: ['./registracija.component.css']
})
export class RegistracijaComponent implements OnInit {

  korisnik: Korisnik;
  constructor(private regser: RegistracijaService, private router: Router) { }

  ngOnInit() {
  }

  OnSubmit(korisnik: Korisnik, form: NgForm)
  {
    this.regser.registrujKorisnika(korisnik)
    .subscribe(
      data => {
        console.log(korisnik);
      },
      error =>{
        alert("Nije uspeo")
        console.log(error);
      }
    );     
    form.reset();
  }
}
