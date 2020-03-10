import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NotFoundComponent } from './modules/shared/pages/not-found/not-found.component';
import { SharedModule } from './modules/shared/shared.module';
import { LoginModule } from './modules/login/login.module';
import { ProfileModule } from './modules/profile/profile.module';
import {BrowserModule} from '@angular/platform-browser';
import {UploadModule} from "./modules/upload/upload.module";
import { Ng2SmartTableModule } from 'ng2-smart-table';
import {NgxPaginationModule} from 'ngx-pagination'; // <-- import the module
import { NgxPaginateModule } from 'ngx-paginate';
import { TableLinkComponent } from './table-link/table-link.component';

@NgModule({
  declarations: [
    AppComponent,
    NotFoundComponent,
    TableLinkComponent
  ], 
  entryComponents:[TableLinkComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    Ng2SmartTableModule, NgxPaginateModule,

    SharedModule.forRoot(),
    LoginModule,
    UploadModule,
    ProfileModule
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
