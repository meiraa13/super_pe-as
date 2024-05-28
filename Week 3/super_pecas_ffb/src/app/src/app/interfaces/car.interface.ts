export interface ICar {
  id: number,
  modelName:string,
  manufacturer:string,
  uniqueCode: string,
  pieces:IPiece[]

}


export interface IPiece {
  id:number,
  pieceName:string,
  description:string,
  serialNumber:string,
  pieceManufacturer:string,
  carModel:string
}
