package task;

public class Company extends Registry 
{
	private String cname;
    private String cadress;
    private FullNumber cphoneNr;

    public Company(String cname, String cadress, FullNumber cphoneNr) 
    {
        this.cname = cname;
        this.cadress = cadress;
        this.cphoneNr = cphoneNr;
    }

    public String getCompanyName() 
    {
        return cname;
    }

    public String getAddress() 
    {
        return cadress;
    }
    
    @Override
    public FullNumber getPhoneNumber() 
    {
        return cphoneNr;
    }

    @Override
    public void showDescription() 
    {
        System.out.println("Company name: " + getCompanyName());
        System.out.println("Address of company: " + getAddress());
        System.out.println("Phone number: +" + getPhoneNumber().partCode(null) + " " + getPhoneNumber().partNumber() + "\n");
    }

}
