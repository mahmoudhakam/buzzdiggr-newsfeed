import { Injectable } from '@angular/core';
import { User } from '../models/user';
import { Subject, BehaviorSubject } from 'rxjs';
import { Router } from '@angular/router';




const USER_LOCAL_STORAGE_KEY = 'USER';
const ATTENDANCE_LOCAL_STORAGE_KEY = 'ATTENDANCE';

@Injectable({
  providedIn: 'root'
})
export class SharedDataService {

  userId: BehaviorSubject<string> = new BehaviorSubject<string>(this.getUserFromLocalStorage());
  buzzdiggrnce: BehaviorSubject<any> = new BehaviorSubject<any>(this.getAttendanceFromLocalStorage());

  constructor(private router: Router) {
    this.userId.subscribe(
      user => {
        this.setUserInLocalStorage(user);
      }
    );


    this.buzzdiggrnce.subscribe(
      data => {
        this.setAttendanceInLocalStorage(data);
      }
    );
  }

  isUserExist(): boolean {

    const userId = this.userId.getValue();
    console.log({userId});
    const isUserExist = !!userId && userId.length > 0;
    console.log('isUserExist', isUserExist);

    return isUserExist;
  }


  isAttendanceExist(): boolean {
    const buzzdiggrnce = this.buzzdiggrnce.getValue();
    const buzzdiggrnceExist = !!buzzdiggrnce;
    return buzzdiggrnceExist;
  }

  logout() {
    localStorage.clear();

    this.userId.next(undefined);
    this.buzzdiggrnce.next(undefined);
    this.router.navigate(['/login']);
  }

  setUserInLocalStorage(userId: string) {
    if ( !userId) {
      localStorage.removeItem(USER_LOCAL_STORAGE_KEY);
    } else {
      localStorage.setItem(USER_LOCAL_STORAGE_KEY, userId);
    }

  }

  getUserFromLocalStorage(): string {
    let userId = null;
    try {
        const text = localStorage.getItem(USER_LOCAL_STORAGE_KEY);
        if (text && text !== '') {
            userId = text;
        }
    } catch (e) {
      console.error(e);
    }
    return userId;
  }

  setAttendanceInLocalStorage(buzzdiggrnce: any) {
    if ( !buzzdiggrnce) {
      localStorage.removeItem(ATTENDANCE_LOCAL_STORAGE_KEY);
    } else {
      localStorage.setItem(ATTENDANCE_LOCAL_STORAGE_KEY, JSON.stringify(buzzdiggrnce));
    }
  }

  getAttendanceFromLocalStorage(): any {
    let buzzdiggrnce = null;
    try {
        const text = localStorage.getItem(ATTENDANCE_LOCAL_STORAGE_KEY);
        if (text && text !== '') {
            const data = JSON.parse(text);
            buzzdiggrnce = data;
        }
    } catch (e) {
      console.error(e);
    }
    return buzzdiggrnce;
  }

}
