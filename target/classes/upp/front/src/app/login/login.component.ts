import { LoginService } from './../services/login.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [LoginService]
})
export class LoginComponent implements OnInit {

  private role = "autor";
  private email;
  private password;

  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit() {
  }

  onSubmit(){
    this.loginService.login(this.email, this.password, this.role).subscribe((data: any) => {
      localStorage.setItem('email', data.email);
      localStorage.setItem('role', data.role);
      this.router.navigate(['tasks']);
    }, error => {
      alert('Pogresan unos lozinke ili mejla')
    })
  }
}
