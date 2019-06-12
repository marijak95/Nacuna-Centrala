import { Router } from '@angular/router';
import { ProcessService } from './../services/process.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-theses',
  templateUrl: './theses.component.html',
  styleUrls: ['./theses.component.css'],
  providers: [ProcessService]
})
export class ThesesComponent implements OnInit {

  private theses: any[];

  constructor(private processService: ProcessService, private router: Router) { }

  ngOnInit() {
    this.processService.getTheses().subscribe((data: any) => {
      console.log(data);
      this.theses = data;
    })
  }

  reviewerComments(thesisId){
    this.router.navigate(['reviewer-comments/' + thesisId]);
  }

}
