import { Router } from '@angular/router';
import { LoginService } from './../services/login.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css'],
  providers: [LoginService]
})
export class RegistrationComponent implements OnInit {

  model: any = {};

  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit() {
  }

  onSubmit(){
    this.loginService.register(this.model).subscribe((data: any) => {
      this.router.navigate(['login']);
    }, error => {
      alert('Doslo je do greske')
    })
  }

}
