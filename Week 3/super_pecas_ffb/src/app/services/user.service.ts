import { Injectable } from "@angular/core";

@Injectable()
export class UserService {
  userList = [
    {
        name: "Computador",
        price: 3000
    },
    {
        name: "Notebook",
        price: 4500
    },
    {
        name: "Mouse",
        price: 200
    }
]
}
