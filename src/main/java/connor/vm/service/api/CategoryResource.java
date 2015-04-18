package connor.vm.service.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import connor.vm.service.dao.CategoryDaoImpl;
import connor.vm.service.domain.Category;

@Path("/category")
public class CategoryResource {

	@GET
	@Path("/getallcategories")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Category> getAllCategories() {
		CategoryDaoImpl categoryDao = new CategoryDaoImpl();
		return categoryDao.getAllCategories();
	}

}
