import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-table-link',
  templateUrl: './table-link.component.html',
  styleUrls: ['./table-link.component.scss']
})
export class TableLinkComponent implements OnInit {

  @Input() value: string | number;
  @Input() rowData: any;

  constructor() { }

  ngOnInit() {
  }

}
