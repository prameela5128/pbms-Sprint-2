import { Cheque } from './Cheque';

export class Transaction{
    public transAccountId:number; 
	public transaction_id:number;
	public transAmount:number;
	public transOption:string;
	public transDate:Date;
    public transChequeId:number;
    public transClosingBalance:number;
    public chequeList:Cheque;

}