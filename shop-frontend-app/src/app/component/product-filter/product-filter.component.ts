import {Component, EventEmitter, Output} from '@angular/core';
import {Manufacturer} from "../../model/manufacturer";
import {FormArray, FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {Category} from "../../model/category";
import {ProductFilter} from "../../model/product-filter";
// import {ProductSortComponent} from "../product-sort/product-sort.component";

@Component({
  selector: 'app-product-filter',
  templateUrl: './product-filter.component.html',
  styleUrls: ['./product-filter.component.scss']
})

export class ProductFilterComponent {
  formGroup: FormGroup;
  @Output()   productFilter:ProductFilter = new ProductFilter();
  categoriesData: Array<Category> = [
    {name: "All", id: 0},
    {name: "Smartphones", id: 1},
    {name: "Tablets", id: 2},
    {name: "Notebooks", id: 3},
    {name: "Monitors", id: 4},
    {name: "Printers", id: 5},
    {name: "Computers", id: 6},
  ];

  manufacturersData: Array<Manufacturer> = [
    {name: 'Samsung', id: 3},
    {name: "Apple", id: 2},
    {name: "HP", id: 1},
    {name: "Xerox", id: 4},
    {name: "Dell", id: 5},
    {name: "Lenovo", id: 6}
  ];

  @Output() applyFilterEvent = new EventEmitter<ProductFilter>();

  get manufacturersFormArray() {
    return this.formGroup.controls['manufacturers'] as FormArray;
  }

  get categoriesFormArray() {
    return this.formGroup.controls['categories'] as FormArray;
  }

  constructor(private formBuilder: FormBuilder
              // private  sort     : ProductSortComponent

) {
    this.formGroup = this.formBuilder.group({
      productNameFilter: new FormControl(),
      priceMinFilter   : new FormControl(),
      priceMaxFilter   : new FormControl(),
      categories       : new FormArray([]),
      manufacturers    : new FormArray([])
    });
    this.addManufacturers();
    this.addCategories();
  }

  private addManufacturers() {
    this.manufacturersData.forEach(
      () => this.manufacturersFormArray.push(new FormControl(false)));
  }

  private addCategories() {
    this.manufacturersData.forEach(
      () => this.categoriesFormArray.push(new FormControl(false)));
  }

  private applyFilter() {
    this.applyFilterEvent.emit(this.productFilter);
  }

  applyCategory(categoryId: number) {
    console.log(`applyCategory ${categoryId}`);
    this.productFilter.categoryId=categoryId;
    this.applyFilter();
  }

  applyNameFilter() {
    console.log(`applyNameFilter = ${this.formGroup.value["productNameFilter"]}`);
    this.productFilter.name=this.formGroup.value["productNameFilter"];
    this.applyFilter();
  }

  applyMinPriceFilter() {
    console.log(`filter = ${this.formGroup.value["minPriceFilter"]}`);
    this.productFilter.priceMin=this.formGroup.value["minPriceFilter"];
    this.applyFilter();
  }

  applyMaxPriceFilter() {
    console.log(`filter = ${this.formGroup.value["maxPriceFilter"]}`);
    this.productFilter.priceMax=this.formGroup.value["maxPriceFilter"];
    this.applyFilter();
  }

  applyManufacturerFilter() {
    // this.productFilter.categoryId=this.formGroup.value["categoryId"];
    this.productFilter.name=this.formGroup.value["productNameFilter"];
    this.productFilter.priceMin=this.formGroup.value["minPriceFilter"];
    this.productFilter.priceMax=this.formGroup.value["maxPriceFilter"];
    // this.sort.applySort();
    console.log(`Select Manufacturers`);
    this.productFilter.manufacturerIds = this.formGroup.value["manufacturers"]
      .map((checked: boolean, i: number) => checked ? this.manufacturersData[i].id : null)
      .filter((v: boolean) => v);
    console.log(`Selected Manufacturers ${this.productFilter.manufacturerIds.toString()}`);
    this.applyFilter();
  }

}
