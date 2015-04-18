package connor.vm.service.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import connor.vm.service.dao.VideoDaoImpl;
import connor.vm.service.domain.Video;

@Path("/video")
public class VideoResource {

	@GET
	@Path("/getvideosbycategoryid")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Video> getVideosByCategoryId(
			@QueryParam("categoryId") int categoryId) {
		VideoDaoImpl videoDao = new VideoDaoImpl();
		return videoDao.getVideosByCategoryId(categoryId);
	}

}
