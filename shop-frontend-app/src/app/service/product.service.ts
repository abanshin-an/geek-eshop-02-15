import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {Page} from "../model/page";
import {Sort} from "../model/sort";
import {ProductFilter} from "../model/product-filter";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) {
  }

  public findAll(page?: number, filter?: ProductFilter, sort?: Sort): Observable<Page> {
    let params = new HttpParams();
    params = params.set("page", page != null ? page : 1);
    params = params.set("size", 3);
    if (filter != null) {
      params = params.set("productNameFilter", filter.name);
      params = params.set("priceMax", filter.priceMax == null ? "" : filter.priceMax);
      params = params.set("priceMin", filter.priceMin == null ? "" : filter.priceMin);
      if (filter.categoryId!=0)
        params = params.set("categoryId", filter.categoryId);
      if (filter.manufacturerIds.length!=0)
        params = params.set("manifacturerIds", filter.manufacturerIds.toString());
    }
    if (sort != null) {
      params = params.set("order", sort.sortField);
      params = params.set("dir", sort.dir);
    }
    else
      console.log("order == null")
    console.log(`api/v1/product/all ${params.toString()}`)
    return this.http.get<Page>('api/v1/product/all', {params});
  }
}
