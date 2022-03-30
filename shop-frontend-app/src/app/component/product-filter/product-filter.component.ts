import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-product-filter',
  templateUrl: './product-filter.component.html',
  styleUrls: ['./product-filter.component.scss']
})
export class ProductFilterComponent implements OnInit {

  @Input() productNameFilter?: string = "";
  @Output() applyFilterEvent = new EventEmitter<string>();
  constructor() { }

  ngOnInit(): void {
  }

  applyFilter() {
    console.log(`applyFilter = ${this.productNameFilter}`);
    this.applyFilterEvent.emit(this.productNameFilter);
  }
}
