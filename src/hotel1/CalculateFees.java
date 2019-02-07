package hotel1;
public class CalculateFees extends Thread
{
private int days;
private double baseCharge;
private double extraCharge;
private double totalFees;

public CalculateFees(String tName, double base_charge, double extra_charges, int days)
{
	super(tName);
        this.days = days;
	this.baseCharge = base_charge;
	this.extraCharge = extra_charges;
        start();
}
//@Override
public void run()
{
    System.out.println(baseCharge+" "+extraCharge+" "+days);
    totalFees = (baseCharge + extraCharge)	*days;
	if(totalFees>=7500)
	  totalFees *= 1.28; //Tax
	else
	  totalFees *=1.18;
        System.out.println("Donezo");
         //return totalFees;
}

public double getTotal()
{
       return totalFees;
}
    }
