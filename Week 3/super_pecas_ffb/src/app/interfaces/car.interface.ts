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
