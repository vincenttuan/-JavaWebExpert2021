# JavaWebExpert2021
JavaWebExpert2021

<pre>
sqlite for java web deploy :
1.pom.xml
<dependency>
	<groupId>org.xerial</groupId>
	<artifactId>sqlite-jdbc</artifactId>
	<version>3.36.0.3</version>
</dependency>

<dependency>
	<groupId>org.simpleflatmapper</groupId>
	<artifactId>sfm-jdbc</artifactId>
	<version>8.2.3</version>
</dependency>

2.在 /WEB-INF 下建立 /db 資料夾

3.java code
try {
	Connection c = null;
	Class.forName("org.sqlite.JDBC");
	String fullPath = getServletContext().getRealPath("/WEB-INF/db/test.db");
	c = DriverManager.getConnection("jdbc:sqlite:" + fullPath);
	out.print(fullPath);
} catch (Exception e) {
	out.print(e);
}
</pre>
