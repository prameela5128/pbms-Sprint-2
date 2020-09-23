import { Address } from './address';



export class Customer{   
    public accountId:number;
    public accountHolderId:string ;
    public accountBranchId:string ;
    public accountType:string ;
	public accountStatus:string ;
    public accountBalance:number;
	public accountIntrest:number;
    public lastUpdated:Date ;
	public customerId:string ;
	public customerName:string ;
	public customerAadhar:string ;
	public customerPan:string ;
	public customerContact:string ;
	public customerGender:string ;
    public customerDob:Date;
	public addressId:string ;
	public customerAddress:Address;
	// public  addressLine1:string;
	// public  addressLine2:string;
	// public  addressCity:string;
	// public  addressState:string;
	// public  addressCountry:string;
	// public  addressZipcode:string;

    
}