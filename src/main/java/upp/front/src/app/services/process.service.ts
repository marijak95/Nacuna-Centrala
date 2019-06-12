import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class ProcessService {

  constructor(private http: HttpClient) { }

  startProcess() {
    var token = {
      'email': localStorage.getItem('email'),
      'role': localStorage.getItem('role')
    }
    return this.http.post('api/process/start', token);
  }

  getTasks() {
    var token = {
      'email': localStorage.getItem('email'),
      'role': localStorage.getItem('role')
    }
    return this.http.post('api/process/get/tasks', token);
  }

  getTaskForm(taskId){
    return this.http.get('api/process/get/' + taskId);
  }

  submitTaskForm(taskId, email, form){
    return this.http.post('api/process/submit/' + taskId +'/' + email, form);
  }

  getTheses(){
    return this.http.get('/api/urednik/radovi');
  }

  getThesesByAuthor(email){
    return this.http.post('/api/autor/moji-radovi', {'email': email});
  }

  getReviewerComments(radId){
    return this.http.get('api/process/komentari/' + radId);
  }
}
