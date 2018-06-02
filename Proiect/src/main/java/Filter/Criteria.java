package Filter;
import java.util.List;
import Model.Product;

public interface Criteria {
	public List<Product> meetCriteria(List<Product> products);
}
