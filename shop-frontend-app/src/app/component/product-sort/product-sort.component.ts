import {Component, EventEmitter, Input, OnInit, Output, SimpleChanges} from "@angular/core";

import {Sort} from "../../model/sort";

@Component({
  selector: 'app-product-sort',
  templateUrl: './product-sort.component.html',
  styleUrls: ['./product-sort.component.scss']
})
export class ProductSortComponent implements OnInit {

  @Input() sort: Sort=new Sort();
  orders =  [
    {id: "name",name:"Product"},
    {id: "price",name:"Price"},
    {id: "manufactirer.name",name:"Manufacturer"}
  ];
  @Input() sortField:string="name";
  @Input() orderDir:string="desc";

  @Output() orderEvent = new EventEmitter<Sort>();

  constructor() {
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (this.sort != null) {
      this.sort.sortField=this.sortField;
      this.sort.dir=this.orderDir;
    }
  }

  ngOnInit(): void {
  }

  applySort() {
    console.log(`applySort ${this.sort.sortField}`);
    this.orderEvent.emit(this.sort);
  }

  setDir(dir: string) {
    this.sort.dir=dir;
    console.log(`setDir ${this.sort.dir}`);
    this.orderEvent.emit(this.sort);
  }
}
