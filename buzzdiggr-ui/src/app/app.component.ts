import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PaginateOptions } from 'ngx-paginate';
import { TableLinkComponent } from './table-link/table-link.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'buzzdiggr';
  noDataFound:boolean;
  source:string;
  showLoading: boolean;
  filter: string;
  items = [ { name: 'yallakoraweb' }, { name: 'youmsevenweb' },{ name: 'shroukweb' },{ name: 'All' }];
  logText(i: number) {
    this.source = this.items[i].name;
    console.log(i, this.source);
  }

  settings = {
    actions: false,
    columns: {
      id: {
        title: 'ID',
        filter: false
      },
      url: {
        title: 'url',
        type: 'custom',
        renderComponent: TableLinkComponent,
        filter: false
      },
      source: {
        title: 'source',
        filter: false
      }, 
      articleTitle: {
        title: 'articleTitle',
        filter: false
      }
    }
  };
  
  data = [ ];
  q= 'رياضة';
 
  page=1;
  size=10;
  totalNumber;
  loading =  false;

  constructor( private http: HttpClient){}

  ngOnInit(){
    this.source='All';
    this.load();
    this.showLoading = false;
    this.noDataFound=false;
  }

  load(){
    this.showLoading=true;
    this.noDataFound=false;
    let params = {
      q:this.q,
      page:(this.page -1 ) + '',
      size:this.size + ''
    };
    let url = `http://localhost:8010/api/searchAll`;
    if(this.source != 'All'){
      url = `http://localhost:8010/api/searchSource`;
      params['source']=this.source;
    }
    this.loading =  true;
    this.http.get(url,{params})
    .subscribe(
      (data: any) => {
        console.log('data',data)
        const { result } =  data;
        const {  totalHits, articles } =  result;
        this.data =  articles;
        this.totalNumber =  totalHits;

        this.pageState =  {
          currentPage: this.page,
          pageSize: this.size,
          totalItems: this.totalNumber
        }

        this.loading =  false;
        this.showLoading=false;
      },
      error => {
        this.loading =  false;
        console.error('error',error);
        if(error.error.errorNumber == 1001){
          console.log('No data found');
          this.noDataFound=true;
        }
        this.showLoading=false;
      }
    )

  }

  pageChanged(index) {
    console.log(index);
    this.page =  index.currentPage;
    this.size =  index.pageSize;
    this.load();
  }

  options: PaginateOptions = {
    spanPages : 2,
    previousPage: true,
    nextPage: true,
    firstPage: true,
    lastPage: true,
    pageSizes:[{
      value: 5,
      display: '5'
    },
    {
      value: 10,
      display: '10'
    }]
  };

  pageState =  {
    currentPage: this.page,
    pageSize: this.size,
    totalItems: 0
  }

}
