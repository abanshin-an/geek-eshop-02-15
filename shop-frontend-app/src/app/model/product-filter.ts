export class ProductFilter {

  constructor(public name: string="",
              public priceMin?: number,
              public priceMax?: number,
              public categoryId: number=0,
              public manufacturerIds: number[]=[]) {
  }
  public toString() {
    return `ProdictFilter { name:${this.name},priceMin:${this.priceMin}, priceMax: ${this.priceMax}, categoryId: ${this.categoryId}, manufacturerIds : ${this.manufacturerIds.toString()} }`
  }

}
