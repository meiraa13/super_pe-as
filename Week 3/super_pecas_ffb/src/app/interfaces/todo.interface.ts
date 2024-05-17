export interface ITodo {
  id:string,
  title:string,
  content:string
}

export type TTodoRequest = Omit<ITodo, "id">
