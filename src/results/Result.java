package results;

public class Result {
	
	private double price;
	private String name;
	private int rating;
	private int rank;
	
	public Result() {
		
	}
	public Result(String name, double price, int rating) {
		this.name = name;
		this.price = price;
		this.rating = rating;
	}
	public Result(Result r) {
		this.name = r.getName();
		this.price = r.getPrice();
		this.rating = r.getRating();
		
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}

}
