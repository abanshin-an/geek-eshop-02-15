import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductGalleryPageComponent } from './page/product-gallery-page/product-gallery-page.component';
import { ProductInfoPageComponent } from './page/product-info-page/product-info-page.component';
import { NavbarComponent } from './component/navbar/navbar.component';
import { ProductFilterComponent } from './component/product-filter/product-filter.component';
import { PaginationComponent } from './component/pagination/pagination.component';
import { ProductGalleryComponent } from './component/product-gallery/product-gallery.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { ProductSortComponent } from './component/product-sort/product-sort.component';

@NgModule({
  declarations: [
    AppComponent,
    ProductGalleryPageComponent,
    ProductInfoPageComponent,
    NavbarComponent,
    ProductFilterComponent,
    PaginationComponent,
    ProductGalleryComponent,
    ProductSortComponent
  ],
    imports: [
        BrowserModule,
        HttpClientModule,
        AppRoutingModule,
        FormsModule,
        ReactiveFormsModule,
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
