import {Category} from "./category";
import {Manufacturer} from "./manufacturer";

export class Product {

  constructor(public id: number,
              public name: string,
              public description: string,
              public price: number,
              public category: Category,
              public manufacturer: Manufacturer,
              public pictures: number[]) {
  }

}
