package bookDatabase;

public class Book {

	// Initiate private variable name and price 
	private String SKU; 
	private String title;
	private String author;
	private String description;
	private double price; 
	
    // method of set and get SKU
    public void setSku(String SKU){
    	this.SKU=SKU;
    }
    
    public String getSku(){
    	return SKU;
    	
    }
    
    // method of set and get title
    public void setTitle(String title){
    	this.title=title;
    }
    
    public String getTitle(){
    	return title;
    	
    }
    
    // method of set and get author
    public void setAuthor(String author){
    	this.author=author;
    }
    
    public String getAuthor(){
    	return author;
    	
    }
    
    
    // method of set and get description
    public void setDescription(String description){
    	this.description = description;
    }
    
    public String getDescription(){
    	return description;
    	
    }
    
    
    // method of set and get price
    public void setPrice(double price){
    	this.price=price;
    	
    }
    
    public double getPrice(){
    	return price;
    	
    }
    
	


}

