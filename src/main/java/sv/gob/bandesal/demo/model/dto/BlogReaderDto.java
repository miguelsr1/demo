package sv.gob.bandesal.demo.model.dto;

public class BlogReaderDto {

	private Integer blogId;
	private Integer readerId;
	
	public Integer getBlogId() {
		return blogId;
	}
	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}
	public Integer getReaderId() {
		return readerId;
	}
	public void setReaderId(Integer readerId) {
		this.readerId = readerId;
	}
	@Override
	public String toString() {
		return "BlogReaderDto [blogId=" + blogId + ", readerId=" + readerId + "]";
	}
	
}
