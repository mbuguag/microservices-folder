
export class Farmer {
    id: number = 0;
    name: string = '';
    phoneNumber: string = '';


    constructor(
        id?: number,
        name?: string,
        phoneNumber?: string
    ) {
        if (id) this.id = id;
        if (name) this.name = name;
        if (phoneNumber) this.phoneNumber = phoneNumber;
    }
}