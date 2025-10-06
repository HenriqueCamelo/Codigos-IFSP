package database;

import java.sql.ResultSet; 
import java.sql.SQLException;
import java.sql.Statement;

public class DBQuery {
	
	private Statement statement =  null;
	private String    tableName 	= "";
	private String[]  fieldsName 	= new String[]{};
	private String    fieldKey  	= "";
	private int		  keyFieldIndex = -1;
	
	public DBQuery() throws SQLException {
		this.statement = new DBConnection().getConnection().createStatement();
	}
	
	public DBQuery(String tableName, String fieldsName,  String fieldKey) throws SQLException {
		this.setTableName(tableName);
		this.setFieldsName(fieldsName);
		this.setFieldKey(fieldKey); 
		this.statement = new DBConnection().getConnection().createStatement();
	}
	
	public String[] dontInjectionStrings(String[] values) {
		String[] tempValues = values;
		for (int i = 0; i < tempValues.length; i++) {
			// sanitização pode ser feita aqui futuramente
		}
		return null;
	}
	
	private int whereIsKeyField() {
		for (int i = 0; i < this.fieldsName.length; i++) {
			if (this.fieldsName[i].equals(this.fieldKey)) {
				return i;
			}
		}
		return -1;
	}
	
	public ResultSet query(String sql) throws SQLException {
		return statement.executeQuery(sql);
	}
	
	public int execute(String sql) throws SQLException {
		return statement.executeUpdate(sql);
	}

	public ResultSet select(String where) throws SQLException {
		String sql = "SELECT " + this.joinElements(this.fieldsName, ", ") + " FROM " + this.tableName;
		sql += (!where.isEmpty()) ? " WHERE " + where : "";
		System.out.print(sql);
		return this.query(sql);
	}
	
	public int insert(String[] values) throws SQLException {
		if (values.length == this.fieldsName.length) {
			String sql = "INSERT INTO " + this.tableName + " (" + this.joinElements(this.fieldsName, ", ");
			sql += ") VALUES ('" + joinElements(values, "','") + "')";
			System.out.print(sql);
			return this.execute(sql);
		} else {
			throw new SQLException("Número de valores informados não é equivalente aos campos da tabela!");
		}
	}
	
	public int delete(String[] values) throws SQLException {
		if (values.length != this.fieldsName.length) {
			throw new SQLException("A quantidade de campos é diferente da quantidade de valores!");
		}
		
		if (this.keyFieldIndex < 0) {
			throw new SQLException("Campo chave não definido corretamente.");
		}

		String sql = "DELETE FROM " + this.tableName + " WHERE " + this.fieldKey + " = '" + values[this.keyFieldIndex] + "'";
		System.out.print(sql);
		return this.execute(sql);
	}
	
	public int update(String[] values) throws SQLException {
		if (values.length != this.fieldsName.length) {
			throw new SQLException("A quantidade de campos é diferente da quantidade de valores!");
		}

		if (this.keyFieldIndex < 0) {
			throw new SQLException("Campo chave não definido corretamente.");
		}
		
		StringBuilder sql = new StringBuilder("UPDATE " + this.tableName + " SET ");
		for (int i = 0; i < values.length; i++) {
			sql.append(this.fieldsName[i]).append(" = '").append(values[i].trim()).append("'");
			if (i < values.length - 1) {
				sql.append(", ");
			}
		}
		sql.append(" WHERE ").append(this.fieldKey).append(" = '").append(values[this.keyFieldIndex]).append("'");
		
		System.out.print(sql.toString());
		return this.execute(sql.toString());
	}

	public String joinElements(String[] elements, String separator) {
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < elements.length; i++) {
			out.append(elements[i].trim());
			if (i < elements.length - 1) out.append(separator);
		}
		return out.toString();
	}
	
	// Getters e Setters
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String[] getFieldsName() {
		return fieldsName;
	}

	public void setFieldsName(String fieldsName) {
		this.fieldsName = fieldsName.split(",");
		for (int i = 0; i < this.fieldsName.length; i++) {
			this.fieldsName[i] = this.fieldsName[i].trim();
		}
	}

	public String getFieldKey() {
		return fieldKey;
	}

	public void setFieldKey(String fieldKey) {
		this.fieldKey = fieldKey;
		this.keyFieldIndex = whereIsKeyField();
	}

	public int getKeyFieldIndex() {
		return keyFieldIndex;
	}

	public void setKeyFieldIndex(int keyFieldIndex) {
		this.keyFieldIndex = keyFieldIndex;
	}
}
