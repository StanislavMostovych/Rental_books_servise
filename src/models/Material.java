package models;

public abstract class Material {
	private String id;
	private String title;
	private String branch;
	private Customer borrower;
	
	public Material(String id, String title, String branch) {
	
		this.id = id;
		this.title = title;
		this.branch = branch;
	}

	public String getTitle() {
		return title;
	}
	public String getID() {
		return id;
	}
	
	public void recolate(String newBranch) {
		this.branch = newBranch;
	}
	
	public boolean lend(Customer customer) {
		if(borrower == null) {
			borrower = customer;
			return true;
		}else {
			return false;
		}
	}
	
	
	
	
	@Override
	public String toString() {
		return id + " : " + title;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Material other = (Material) obj;
		if (borrower == null) {
			if (other.borrower != null)
				return false;
		} else if (!borrower.equals(other.borrower))
			return false;
		if (branch == null) {
			if (other.branch != null)
				return false;
		} else if (!branch.equals(other.branch))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	
	
	
}
