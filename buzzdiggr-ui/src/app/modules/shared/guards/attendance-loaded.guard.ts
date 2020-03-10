import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router} from '@angular/router';
import { Observable } from 'rxjs';
import {SharedDataService} from '../services/shared-data.service';

@Injectable({
  providedIn: 'root'
})
export class AttendanceLoadedGuard implements CanActivate {

  constructor(private sharedData: SharedDataService, private route: Router) {
  }


  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {

    const buzzdiggrnceExist = this.sharedData.isAttendanceExist();
    const isUserExist = this.sharedData.isUserExist();
    if ( !buzzdiggrnceExist && isUserExist) {
      alert('please upload buzzdiggrnce sheet');
      this.route.navigate(['/upload']);
    }
    return buzzdiggrnceExist;
  }
}
