package connor.vm.service.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import connor.vm.service.domain.Category;

public class CategoryDaoImpl {

	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;

	public List<Category> getAllCategories() {
		Properties properties = new Properties();
		List<Category> categories = new ArrayList<Category>();

		try {
			properties.load(this.getClass().getResourceAsStream(
					"/mysql/database.properties"));

			Class.forName(properties.getProperty("driver_class"));

			connection = DriverManager.getConnection(
					properties.getProperty("url"),
					properties.getProperty("username"),
					properties.getProperty("password"));

			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM category");

			while (resultSet.next()) {
				Category category = new Category();
				category.setCategoryId(resultSet.getInt("category_id"));
				category.setCategoryName(resultSet.getString("category_name"));

				categories.add(category);
			}

			return categories;
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

			if (statement != null) {
				statement.close();
			}

			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
