import { TestBed, async, inject } from '@angular/core/testing';

import { AttendanceLoadedGuard } from './buzzdiggrnce-loaded.guard';

describe('AttendanceLoadedGuard', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AttendanceLoadedGuard]
    });
  });

  it('should ...', inject([AttendanceLoadedGuard], (guard: AttendanceLoadedGuard) => {
    expect(guard).toBeTruthy();
  }));
});
