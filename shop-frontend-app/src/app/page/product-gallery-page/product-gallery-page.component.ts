import { Component, OnInit } from '@angular/core';
import {Product} from "../../model/product";
import {ProductService} from "../../service/product.service";
import {Page} from "../../model/page";
import {Sort} from "../../model/sort";
import {ProductFilter} from "../../model/product-filter";

@Component({
  selector: 'app-product-gallery-page',
  templateUrl: './product-gallery-page.component.html',
  styleUrls: ['./product-gallery-page.component.scss']
})
export class ProductGalleryPageComponent implements OnInit {
  products : Product[] = [];
  page? : Page;
  productNameFilter? : string;
  sort: Sort = new Sort();

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.goToPage(1);
  }

  goToPage(page:number){
    this.productService.findAll(page).subscribe( res => {
      this.page = res;
      this.products = res.content;
      console.log(`Loading products ${page}`);
    }, err => {
      console.log(`Error loading products ${err}`);
    })
  }

  filterApplied($event: ProductFilter) {
    this.productService.findAll(1, $event, this.sort).subscribe( res => {
      this.page = res;
      this.products = res.content;
      console.log(`Loading products ${$event}`);
    }, err => {
      console.log(`Error loading products ${err}`);
    });
  }

  sortProduct($event: Sort) {
  }
}
