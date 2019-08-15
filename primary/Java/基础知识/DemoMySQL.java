package jdbc;

/**
1��	ʲô��JDBC��
	JDBC��Java DataBase Connectivity,java���ݿ����ӣ���һ������ִ��SQL����Java API��
		����Ϊ���ֹ�ϵ���ݿ��ṩͳһ���ʣ�����һ����Java���Ա�д����ͽӿ���ɡ�
2��	ʹ��JDBC���������������ַ�ʽ��
	��1��JDBC-ODBC�ż�ODBC�������� 
		JavaSoft�Ų�Ʒ����ODBC���������ṩJDBC���ʡ�
	��2������API 
		�������͵���������ѿͻ���API�ϵ�JDBC����ת��ΪOracle��Sybase��Informix��DB2������DBMS�ĵ��á�
	��3��JDBC���紿Java�������� 
		������������JDBCת��Ϊ��DBMS�޹ص�����Э�飬֮������Э���ֱ�ĳ��������ת��Ϊһ��DBMSЭ�顣
	��4������Э�鴿Java�������� 
		�������͵���������JDBC����ֱ��ת��ΪDBMS��ʹ�õ�����Э�顣�⽫����ӿͻ���������ֱ�ӵ���DBMS��������
		��Intranet���ʵ�һ����ʵ�õĽ��������
	
3��	DriverManger����ʲô���ã�
	DriverManager����JDBC�Ĺ���㣬�������û�����������֮�䡣�����ٿ��õ���������
	�������ݿ����Ӧ��������֮�佨�����ӡ�DriverManager ��Ҳ�����������������¼ʱ������
	����¼�͸�����Ϣ����ʾ������DriverManager �����һ�е����������࣬������ͨ�����÷���
	DriverManager.registerDriver( ) ���Լ�������ע�ᣬ�������ǿ���ֱ�Ӽ�����������
	Ȼ�������������Լ�ȥע�ᡣ

4��	ResultSet��λ�ȡ��ѯ�����
	�Ѳ�ѯ�Ľ��������list�����ֱ�ӵ���list.size()�Ϳ����ˡ�
5��	Statement�ӿ���ʲô���ã�
	����ִ�о�̬��sql��� 
		1��int executeUpdate(String sql) �� ִ�о�̬�ĸ���sql��䣨DDL��DML�� 
		2��ResultSet executeQuery(String sql) ��ִ�еľ�̬�Ĳ�ѯsql��䣨DQL��
6��	ʲô������
	������Ӧ�ó�����һϵ�����ܵĲ��������в�������ɹ���ɣ�������ÿ�����������������и��Ķ��ᱻ������
	Ҳ�����������ԭ���ԣ�һ�������е�һϵ�еĲ���Ҫôȫ���ɹ���Ҫôһ����������
	���ݿ����� transanction ��ȷִ�е��ĸ�����Ҫ�ء�ACID,ԭ����(Atomicity)��һ����(Correspondence)��
	������(Isolation)���־���(Durability)��
7��	���ʹ��Transaction������������
	��������Start Transaction
	���������End Transaction
	�ύ����Commit Transaction
	�ع�����Rollback Transaction
 * 	commit:�ύ
	rollback���ع�

 * 
 * 
	JDBC�ӿں��ĵ�API��
	
	1��Driver�ӿڣ� ��ʾjava��������ӿڡ����еľ�������ݿ⳧��Ҫ��ʵ�ִ˽ӿڡ� 
		1��connect(url, properties): �������ݿ�ķ����� 
		url: �������ݿ��URL 
		URL�﷨�� jdbcЭ��:���ݿ���Э��://����:�˿�/���ݿ� 
		user�� ���ݿ���û��� 
		password�� ���ݿ��û�����
	
	2��DriverManager�ࣺ �����������࣬���ڹ�������ע����������� 
		1��registerDriver(driver) : ע����������� 
		2��Connection getConnection(url,user,password); ��ȡ���Ӷ���
	
	3��Connection�ӿڣ� ��ʾjava��������ݿ�����Ӷ��� 
		1��Statement createStatement() �� ����Statement���� 
		2��PreparedStatement prepareStatement(String sql) ����PreparedStatement���� 
		3��CallableStatement prepareCall(String sql) ����CallableStatement����
	
	4��Statement�ӿڣ� ����ִ�о�̬��sql��� 
		1��int executeUpdate(String sql) �� ִ�о�̬�ĸ���sql��䣨DDL��DML�� 
		2��ResultSet executeQuery(String sql) ��ִ�еľ�̬�Ĳ�ѯsql��䣨DQL��
	
	5��PreparedStatement�ӿڣ�Statement�ӿڵ��ӽӿڣ�������ִ��Ԥ����sql��� 
		1�� int executeUpdate() �� ִ��Ԥ����ĸ���sql��䣨DDL��DML�� 
		2��ResultSet executeQuery() �� ִ��Ԥ����Ĳ�ѯsql��䣨DQL��
	
	6��CallableStatement�ӿڣ�PreparedStatement�ӿڵ��ӽӿڣ�������ִ�д洢���̵�sql��䣨call xxx�� 
		1��ResultSet executeQuery() �� ���ô洢���̵ķ���
	
	7��ResultSet�ӿڣ����ڷ�װ��ѯ���������� 
		1��boolean next() �� ������ƶ�����һ�� 
		2��getXX() : ��ȡ�е�ֵ

 *
 * */


public class DemoMySQL {

}
