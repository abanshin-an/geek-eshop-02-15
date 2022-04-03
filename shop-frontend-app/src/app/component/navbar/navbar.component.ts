import { Component, OnInit } from '@angular/core';
import {NavigationEnd, Router} from "@angular/router";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {


  isProductGalleryPage: boolean = false;
  isCartPage: boolean = false;

  constructor(private router: Router) {
  }

  ngOnInit(): void {
    this.router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
        this.isProductGalleryPage = event.url === '/' || event.url === '/product';
        this.isCartPage = event.url === '/cart';
      }
    })
  }

}
