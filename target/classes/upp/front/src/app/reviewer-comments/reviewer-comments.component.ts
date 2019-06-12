import { ProcessService } from './../services/process.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-reviewer-comments',
  templateUrl: './reviewer-comments.component.html',
  styleUrls: ['./reviewer-comments.component.css'],
  providers: [ProcessService]
})
export class ReviewerCommentsComponent implements OnInit {

  private reviews: any[];

  constructor(private processService: ProcessService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.processService.getReviewerComments(params.thesisId).subscribe((data: any) => {
        console.log(data);
        this.reviews = data;
      })
    })
  }

  isUrednik(): boolean{
    if(localStorage.getItem('role') == 'urednik')
      return true;
    else
      return false;
  }

}
