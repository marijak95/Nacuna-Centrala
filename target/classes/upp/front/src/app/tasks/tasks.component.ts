import { Router } from '@angular/router';
import { ProcessService } from '../services/process.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.css'],
  providers: [ProcessService]
})
export class TasksComponent implements OnInit {

  private processId;
  private taskId;
  private tasks: any[];
  private formFields: any[];
  private enumValues = [];


  constructor(private processService: ProcessService, private router: Router) { }

  ngOnInit() {
    this.processService.getTasks().subscribe((data: any) => {
      this.tasks = data;

    })

  }

  doTask(taskId) {
    this.processService.getTaskForm(taskId).subscribe((data: any) => {
      this.formFields = data.formFields;
      this.taskId = data.taskId;
      this.formFields.forEach((field) => {

        if (field.type.name == 'enum') {
          this.enumValues = Object.keys(field.type.values);
        }
      });
    })
  }

  onSubmit(value, form) {
    let o = new Array();
    for (var property in value) {
      //console.log(property);
      //console.log(value[property]);
      o.push({ fieldId: property, fieldValue: value[property] });
    }

    console.log(o);

    this.processService.submitTaskForm(this.taskId, localStorage.getItem('email'), o).subscribe(data => {
      console.log(data);
      window.location.reload();
    });
  }

  publish() {
    this.processService.startProcess().subscribe((data: any) => {
      window.location.reload();
    })
  }

  logout() {
    localStorage.clear();
    this.router.navigate(['login']);
  }

  isAutor(): boolean {
    var role = localStorage.getItem('role');
    if (role == 'autor')
      return true;
    else
      return false;
  }

  isUrednik(): boolean {
    var role = localStorage.getItem('role');
    if (role == 'urednik')
      return true;
    else
      return false;
  }

  myTheses() {
    this.router.navigate(['moji-radovi'])
  }

  allTheses() {
    this.router.navigate(['radovi'])
  }
}
