import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { take } from 'rxjs';

import { HospitalService } from '../service/hospital.service';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {

  email: string= '';
  isShowChangePassword: boolean = false;
  newPassword: string = '';
  customer: any;
  constructor(
    private service: HospitalService,
    private route: Router
  ) { }

  ngOnInit(): void {
  }

  onSubmit(): void {
    const body = {
      emailID: this.email
    };

  }

  onChangePassword(): void {
    this.customer.password = this.newPassword;

  }

}
