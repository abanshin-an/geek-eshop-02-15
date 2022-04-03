import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {CartService} from "../../service/cart.service";
import {LineItem} from "../../model/line-item";

@Component({
  selector: '[app-cart-item]',
  templateUrl: './cart-item.component.html',
  styleUrls: ['./cart-item.component.scss']
})
export class CartItemComponent implements OnInit {

  @Output() updated = new EventEmitter();

  private _lineItem?: LineItem;

  qty: number = 0;

  constructor(private cartService: CartService) {
  }

  ngOnInit(): void {
  }

  @Input()  set lineItem(value: LineItem | undefined) {
    this._lineItem = value;
    this.qty = value ? value.qty : 1;
  }

  get lineItem(): LineItem | undefined {
    return this._lineItem;
  }

  updateLineItem() {

  }

  deleteLineItem() {
    if (this._lineItem) {
      this.cartService.removeLineItem(this._lineItem)
        .subscribe(
          res => {
            this.updated.emit();
          },
          error => {
            console.log(error)
          }
        )
    }
  }
}
