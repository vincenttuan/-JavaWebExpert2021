# JavaWebExpert2021
JavaWebExpert2021

<pre>
sqlite for java web deploy :
1.pom.xml
&lt;dependency&gt;
	&lt;groupId>org.xerial&lt;/groupId>
	&lt;artifactId>sqlite-jdbc&lt;/artifactId>
	&lt;version>3.36.0.3&lt;/version>
&lt;/dependency>

&lt;dependency>
	&lt;groupId>org.simpleflatmapper&lt;/groupId>
	&lt;artifactId>sfm-jdbc&lt;/artifactId>
	&lt;version>8.2.3&lt;/version>
&lt;/dependency>

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

4.create table
create table Task (
	id integer primary key autoincrement,
	name text,
	work integer,
	eat integer,
	commute integer,
	entertainment integer,
	sleep integer
)

5.insert rows
INSERT INTO Task
(name, "work", eat, commute, entertainment, sleep)
VALUES('Vincent', 11, 2, 2, 2, 7);
INSERT INTO Task
(name, "work", eat, commute, entertainment, sleep)
VALUES('Anita', 12, 1, 2, 3, 6);
INSERT INTO Task
(name, "work", eat, commute, entertainment, sleep)
VALUES('Howard', 10, 1, 1, 4, 8);
INSERT INTO Task
(name, "work", eat, commute, entertainment, sleep)
VALUES('Joanna', 6, 1, 1, 6, 10);

</pre>
