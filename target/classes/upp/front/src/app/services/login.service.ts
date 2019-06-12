import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class LoginService {

  constructor(private http: HttpClient) { }

  login(email, password, role){
    return this.http.post('api/login/' + role, {"email": email, "password": password});
  }

  register(autor){
    console.log(autor);
    let headers = new Headers();
    headers.append('Access-Control-Allow-Origin','*/*');  
    return this.http.post('http://localhost:8080/api/autor/register', autor);
  }
}
