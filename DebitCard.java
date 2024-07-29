
/**
 * Write a description of class DebitCard here.
 *
 * @author (Suhan Maharjan)
 * @version ( 15/01/2023 )
 */
public class DebitCard extends BankCard
{
    private String dateOfWithdrawl;
    private int pinNumber;
    private int withdrawlAmount;
    private boolean hasWithdrawn;

    public DebitCard(String clientName,int balanceAmount,int cardId ,String bankAccount, String issuerBank, int pinNumber)
    {
        super(clientName,balanceAmount, cardId,bankAccount, issuerBank);
        this.pinNumber= pinNumber;
        hasWithdrawn= false; 
    }

    /* Accessor Method of each correspondings*/
    public String getdateOfWithdrawl(){
        return this.dateOfWithdrawl;
    }

    public int getpinNumber(){
        return this.pinNumber;
    }

    public int getwithdrawlAmount(){
        return this.withdrawlAmount;
    }

    public boolean gethasWithdrawn(){

        return this.hasWithdrawn;

    }

    /*Setter Method is being set*/
    public void setdateOfWithdrawl(String newdateOfWithdrawl){
        dateOfWithdrawl = newdateOfWithdrawl;
    }

    public void setpinNumber(int newpinNumber){
        pinNumber= newpinNumber;
    }

    public void setwithdrawlAmount(int newwithdrawlAmount){
        withdrawlAmount = newwithdrawlAmount;

    }

    public void sethasWithdrawn(boolean newhasWithdrawn){
        hasWithdrawn = newhasWithdrawn;
    }
    //following method with draw is for making transaction from bank account.
    public void withDraw(int withdrawlAmount, String dateOfWithdrawl, int pinNumber){
        //below condition checks whether the customer entered pin number and amount is sufficient to withdraw or not
        if(this.pinNumber == pinNumber && super.getbalanceAmount() >= withdrawlAmount ){
            hasWithdrawn = true;
            super.setclientName("");
            this.withdrawlAmount = withdrawlAmount;
            this.dateOfWithdrawl = dateOfWithdrawl;
            this.pinNumber = pinNumber;

        } 

        else {
            System.out.println("Either pin number or amount exceeds!!!");
        }
    }
      //creating a debitCardDetails method 
    public void debitCardDetails(){
          // if the user has not made any transaction yet the following customer balance is displayed.
        if( hasWithdrawn == false){
            System.out.println("No transaction has been done yet");
            System.out.println("Balance Amount: " + super.getbalanceAmount());
        }
        //if the user had made any transaction then the following process is executed.
        else{
            super.display();
            System.out.println("Dislay the details of Debit card details");
            System.out.println("Pin number: " + pinNumber);
            System.out.println("Withdrawl Amount: " + withdrawlAmount);
            int newBalanceAmount = super.getbalanceAmount() - withdrawlAmount; 
            System.out.println("Your new balance is: " + newBalanceAmount);
            System.out.println("Date of withdrawl : " + dateOfWithdrawl);
        }

    }

}
