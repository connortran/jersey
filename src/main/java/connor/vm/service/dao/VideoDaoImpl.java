package connor.vm.service.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import connor.vm.service.domain.Video;

public class VideoDaoImpl {
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	public List<Video> getVideosByCategoryId(int categoryId) {
		Properties properties = new Properties();
		List<Video> videos = new ArrayList<Video>();

		try {
			properties.load(this.getClass().getResourceAsStream(
					"/mysql/database.properties"));

			Class.forName(properties.getProperty("driver_class"));

			connection = DriverManager.getConnection(
					properties.getProperty("url"),
					properties.getProperty("username"),
					properties.getProperty("password"));

			preparedStatement = connection
					.prepareStatement("SELECT * FROM video WHERE category_id = ?");

			preparedStatement.setInt(1, categoryId);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Video video = new Video();
				video.setVideoId(resultSet.getInt("video_id"));
				video.setCategoryId(resultSet.getInt("category_id"));
				video.setVideoName(resultSet.getString("video_name"));
				video.setLikeCount(resultSet.getInt("like_count"));
				video.setDislikeCount(resultSet.getInt("dislike_count"));

				videos.add(video);
			}

			return videos;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			this.close();
		}
	}

	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
