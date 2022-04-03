import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {CartService} from "../../service/cart.service";
import {AllCartDto} from "../../model/all-cart-dto";

export const CART_URL = 'cart'

@Component({
  selector: 'app-cart-page',
  templateUrl: './cart-page.component.html',
  styleUrls: ['./cart-page.component.scss']
})
export class CartPageComponent implements OnInit {

  content?: AllCartDto;
  @Output() updated = new EventEmitter();

  constructor(private cartService: CartService) {
  }

  ngOnInit(): void {
    this.cartUpdated();
  }

  cartUpdated() {
    this.cartService.findAll().subscribe(
      res => {
        this.content = res;
      }
    )
  }

  removeAllLineItems() {
    this.cartService.removeAllLineItems().subscribe(
      res => {
        this.content=undefined;
        this.updated.emit();
      },
      error => {
        console.log(error)
      });
  }
}
