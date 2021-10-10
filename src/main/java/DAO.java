import java.sql.*;

public class DAO {
    public static String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static String ORACLE_URL = "jdbc:oracle:thin:@13.124.230.151:1521:XE";
    public static String ORACLE_USER = "doldolseo";
    public static String ORACLE_PW = "120100";

    public Connection conn;
    public PreparedStatement pstmt;
    public int result = 0;


    //DB 접속
    public Connection getConnection() throws SQLException {

        try {
            Class.forName(ORACLE_DRIVER);
            System.out.println("ORACLE DRIVER LOADING : SUCCESS");
            conn = DriverManager.getConnection(ORACLE_URL, ORACLE_USER, ORACLE_PW);
            System.out.println("CONNECTING ORACLE : SUCCESS");
        } catch (ClassNotFoundException e) {
            System.out.println("ORACLE DRIVER LOADING : FAIL");
            e.printStackTrace();
        }

        return conn;
    }

    //DB 연결 해제
    protected void closeConnection(Connection c, PreparedStatement p) {
        try {
            if (p != null) p.close();
            closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    protected void closeConnection(Connection c) {
        try {
            if (c != null) c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //insert
    public void insert(DTO dto) {
        try {
            String query = "insert into seoul_area_tbl (NAME,ADDRESS,SIGUNGU,ZIPCODE,TEL, X, Y,IMAGE1, IMAGE2, CONTENTTYPE, CONTENTID) values (?,?,?,?,?,?,?,?,?,?,?)";

            conn = getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, dto.getTitle());
            pstmt.setString(2, dto.getAddr1());
            pstmt.setInt(3, dto.getSigungucode());
            pstmt.setString(4, dto.getZipcode());
            pstmt.setString(5, dto.getTel());
            pstmt.setDouble(6, dto.getMapx());
            pstmt.setDouble(7, dto.getMapy());
            pstmt.setString(8, dto.getFirstimage());
            pstmt.setString(9, dto.getFirstimage2());
            pstmt.setInt(10, dto.getContenttypeid());
            pstmt.setInt(11, dto.getContentid());
            result = pstmt.executeUpdate();
            if(result>0){
                System.out.println("데이터 삽입");
            }else {
                System.out.println("데이터 삽입 실패");
            }

        } catch (SQLException e) {
            System.out.println("insert : FAIL - " + e.getMessage());
        } finally {
            closeConnection(conn, pstmt);
        }

    }

    public void change_sigungu() {
        try {
            String query1 = "SELECT * FROM SEOUL_AREA_TBL";
            String query2 = "UPDATE seoul_area_tbl SET SIGUNGU=? WHERE SIGUNGU=?";

            conn = getConnection();
            pstmt = conn.prepareStatement(query1);
            ResultSet rs = pstmt.executeQuery(query1);
            pstmt = conn.prepareStatement(query2);

            while (rs.next()) {

                int sigungu = rs.getInt("sigungu");

//                if (!(sigungu == 1 || sigungu == 3 || sigungu == 24 || sigungu == 20 || sigungu == 18 || sigungu == 13 || sigungu == 23)) {
//                    pstmt.setInt(1, 0);
//                    pstmt.setInt(2, sigungu);
//                    result = pstmt.executeUpdate();
//                }

//                if (sigungu == 1) {
//                    pstmt.setInt(1, 1);
//                    pstmt.setInt(2, sigungu);
//                    result = pstmt.executeUpdate();
//                }else if (sigungu == 3) {
//                    pstmt.setInt(1, 2);
//                    pstmt.setInt(2, sigungu);
//                    result = pstmt.executeUpdate();
//                }else if (sigungu == 24) {
//                    pstmt.setInt(1, 4);
//                    pstmt.setInt(2, sigungu);
//                    result = pstmt.executeUpdate();
//                }else if (sigungu == 20) {
//                    pstmt.setInt(1, 5);
//                    pstmt.setInt(2, sigungu);
//                    result = pstmt.executeUpdate();
//                }else if (sigungu == 18) {
//                    pstmt.setInt(1, 6);
//                    pstmt.setInt(2, sigungu);
//                    result = pstmt.executeUpdate();
//                }else if (sigungu == 13) {
//                    pstmt.setInt(1, 7);
//                    pstmt.setInt(2, sigungu);
//                    result = pstmt.executeUpdate();
//                }
//                if (sigungu == 23) {
//                    pstmt.setInt(1, 3);
//                    pstmt.setInt(2, sigungu);
//                    result = pstmt.executeUpdate();
//                }


            }

        } catch (SQLException e) {
            System.out.println("select : FAIL - " + e.getMessage());
        } finally {
            closeConnection(conn, pstmt);
        }
    }

    public void change_contenttype() {
        try {
            String query1 = "SELECT * FROM SEOUL_AREA_TBL";
            String query2 = "UPDATE seoul_area_tbl SET CONTENTTYPE=? WHERE CONTENTTYPE=?";

            conn = getConnection();
            pstmt = conn.prepareStatement(query1);
            ResultSet rs = pstmt.executeQuery(query1);
            pstmt = conn.prepareStatement(query2);

            while (rs.next()) {

                int contentType = rs.getInt("CONTENTTYPE");

//                if (!(contentType == 15 || contentType == 39 || contentType == 38 || contentType == 14 || contentType == 12)) {
//                    pstmt.setInt(1, 0);
//                    pstmt.setInt(2, contentType);
//                    result = pstmt.executeUpdate();
//                }

                if (contentType == 15) {
                    pstmt.setInt(1, 1);
                    pstmt.setInt(2, contentType);
                    result = pstmt.executeUpdate();
                }else if (contentType == 39) {
                    pstmt.setInt(1, 2);
                    pstmt.setInt(2, contentType);
                    result = pstmt.executeUpdate();
                }else if (contentType == 38) {
                    pstmt.setInt(1, 3);
                    pstmt.setInt(2, contentType);
                    result = pstmt.executeUpdate();
                }else if (contentType == 14) {
                    pstmt.setInt(1, 4);
                    pstmt.setInt(2, contentType);
                    result = pstmt.executeUpdate();
                }else if (contentType == 12) {
                    pstmt.setInt(1, 4);
                    pstmt.setInt(2, contentType);
                    result = pstmt.executeUpdate();
                }


            }

        } catch (SQLException e) {
            System.out.println("select : FAIL - " + e.getMessage());
        } finally {
            closeConnection(conn, pstmt);
        }
    }


    public int update(int sigungu) {
        try {
            String query = "UPDATE seoul_area_tbl SET SIGUNGU=? WHERE SIGUNGU=?";

            conn = getConnection();
            pstmt = conn.prepareStatement(query);
            if (!(sigungu == 1 || sigungu == 3 || sigungu == 23 || sigungu == 24 || sigungu == 20 || sigungu == 18 || sigungu == 13)) {
                pstmt.setInt(1, sigungu);
                result = pstmt.executeUpdate();
            }

            if (sigungu == 1) {
                pstmt.setInt(1, 1);
                pstmt.setInt(2, sigungu);
                result = pstmt.executeUpdate();
            }

            if (sigungu == 3) {
                pstmt.setInt(1, 2);
                pstmt.setInt(2, sigungu);
                result = pstmt.executeUpdate();
            }

            if (sigungu == 23) {
                pstmt.setInt(1, 3);
                pstmt.setInt(2, sigungu);
                result = pstmt.executeUpdate();
            }

            if (sigungu == 24) {
                pstmt.setInt(1, 4);
                pstmt.setInt(2, sigungu);
                result = pstmt.executeUpdate();
            }

            if (sigungu == 20) {
                pstmt.setInt(1, 5);
                pstmt.setInt(2, sigungu);
                result = pstmt.executeUpdate();
            }

            if (sigungu == 18) {
                pstmt.setInt(1, 6);
                pstmt.setInt(2, sigungu);
                result = pstmt.executeUpdate();
            }

            if (sigungu == 13) {
                pstmt.setInt(1, 7);
                pstmt.setInt(2, sigungu);
                result = pstmt.executeUpdate();
            }


        } catch (SQLException e) {
            System.out.println("update : FAIL - " + e.getMessage());
        } finally {
            closeConnection(conn, pstmt);
        }

        return result;
    }
}
