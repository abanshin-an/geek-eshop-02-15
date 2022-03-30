import { Component, OnInit } from '@angular/core';
import {Product} from "../../model/product";
import {ProductService} from "../../service/product.service";
import {Page} from "../../model/page";

@Component({
  selector: 'app-product-gallery-page',
  templateUrl: './product-gallery-page.component.html',
  styleUrls: ['./product-gallery-page.component.scss']
})
export class ProductGalleryPageComponent implements OnInit {
  products: Product[]= [];
  page? : Page;
  productNameFilter? : string;

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
    });
  }

  applyFilter(productNameFilter: string) {
    this.productService.findAll(1, productNameFilter).subscribe( res => {
      this.page = res;
      this.products = res.content;
      console.log(`Loading products ${productNameFilter}`);
    }, err => {
      console.log(`Error loading products ${err}`);
    });
  }
}
