package com.techpalle.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.techpalle.model.Admin;
import com.techpalle.model.Student;

public class DataAccessObject {
	
	private static Connection cn = null;
	private static PreparedStatement ps = null;
	private static Statement s = null;
	private static ResultSet rs = null;
	
	private static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/springmvc","root","Sudeep*123");
		return cn;
	}
	
	public static boolean login(Admin a) {
		boolean b = false;
		try {
			cn = getConnection();
			ps = cn.prepareStatement("select * from admin where email = ? ");
			ps.setString(1,a.getEmail());
			rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getString("email").equals(a.getEmail()) && rs.getString("pwd").equals(a.getPassword())) {
					b =  true;
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(s!=null) {
				try {
					s.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(cn!=null) {
				try {
					cn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		
		return b;
	}

	public static void insert(Student s) {
		try {
			cn = getConnection();
			String query = "insert into student(name,email,pw,phno) values(?,?,?,?)";
			ps = cn.prepareStatement(query);
			ps.setString(1, s.getName());
			ps.setString(2, s.getEmail());
			ps.setString(3, s.getPassword());
			ps.setLong(4, s.getMobile());
			
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(cn!=null) {
				try {
					cn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static ArrayList<Student> getAllStudentDetails(){
		ArrayList<Student> all = new ArrayList<Student>();
		try {
			cn = getConnection();
			s = cn.createStatement();
			rs = s.executeQuery("select * from student");
			
			while(rs.next()) {
				int i = rs.getInt("sno");
				String n = rs.getString("name");
				String e = rs.getString("email");
				String p = rs.getString("pw");
				long ph = rs.getLong("phno");
				
				Student stud = new Student(i,n,e,p,ph);
				
				all.add(stud);
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(s!=null) {
				try {
					s.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(cn!=null) {
				try {
					cn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		return all;
	}
	
	public static void update(Student s) {
		try {
			cn = getConnection();
			String query = "update student set name=?, email=?, pw=?, phno=? where sno=?";
			ps = cn.prepareStatement(query);
			ps.setString(1, s.getName());
			ps.setString(2, s.getEmail());
			ps.setString(3, s.getPassword());
			ps.setLong(4, s.getMobile());
			ps.setInt(5,s.getId());
			
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(cn!=null) {
				try {
					cn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static Student getStudentById(int id) {
		Student stud = new Student();
		try {
			cn = getConnection();
			ps = cn.prepareStatement("select * from student where sno=?");	
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				stud.setId(id);
				stud.setName(rs.getString("name"));
				stud.setEmail(rs.getString("email"));
				stud.setPassword(rs.getString("pw"));
				stud.setMobile(rs.getLong("phno"));
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(cn!=null) {
				try {
					cn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		return stud;
	}
	
	public static void deleteStudent(int id) {
			try {
				cn = getConnection();
				ps = cn.prepareStatement("delete from student where sno=?");
				ps.setInt(1, id);
				ps.executeUpdate();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				if(ps!=null) {
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(cn!=null) {
					try {
						cn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
	}
}
