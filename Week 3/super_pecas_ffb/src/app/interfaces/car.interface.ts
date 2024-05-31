import { WritableSignal } from "@angular/core"

export interface ICar {
  id: number,
  modelName:string,
  manufacturer:string,
  uniqueCode: string,
  pieces:IPiece[]

}

export type TCarRequest = Omit<ICar, "id" | "pieces">

export interface ICarResponse {
  id:number
}

export interface IPiece {
  id:number,
  pieceName:string,
  description:string,
  serialNumber:string,
  pieceManufacturer:string,
  carModel:string
}


export interface IDeleteDialog {
  id:number,
  list:WritableSignal<ICar[]>
}


export interface ICreateDialog {
  title:string,
  list:WritableSignal<ICar[]>
}
