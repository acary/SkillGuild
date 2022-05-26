import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Content } from 'src/app/models/content';
import { ContentService } from 'src/app/services/content.service';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css']
})
export class ContentComponent implements OnInit {

  contents: Content[] = [];

  selected: Content | null = null;

  constructor(
    private contentSvc: ContentService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.getAllContents();
  }

  getAllContents() {
    this.contentSvc.index().subscribe(contents => {
      this.contents = contents;
    });
  }

  displayAll(): void {
    this.selected = null;
  }

  getContentById(id: number) {
    this.contentSvc.show(id).subscribe(
      content => {
        return content;
      },
      err => {
        console.log(err);
      }
    )
  }

}