import { Component, OnInit } from '@angular/core';
import { Korisnik } from 'src/app/models/korisnik';
import {NgForm} from '@angular/forms';
import { RegistracijaService } from 'src/app/services/registracija.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registracija',
  templateUrl: './registracija.component.html',
  styleUrls: ['./registracija.component.scss']
})
export class RegistracijaComponent implements OnInit {

  constructor(private regser: RegistracijaService, private router: Router) { }
  korisnik: Korisnik;
  ngOnInit() {
    
  }

  OnSubmit(korisnik: Korisnik, form: NgForm)
  {
    this.regser.register(korisnik)
    .subscribe(
      data => {
        console.log(korisnik);
      },
      error =>{
        console.log(error);
      }
    );     
    form.reset();
  }

}
