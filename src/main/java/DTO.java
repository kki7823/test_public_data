import lombok.Data;

@Data
public class DTO {
    private String addr1;
    private String addr2;
    private int areacode;
    private String cat1;
    private String cat2;
    private String cat3;
    private int contentid;
    private int contenttypeid;
    private long createdtime;
    private String firstimage;
    private String firstimage2;
    private double mapx;
    private double mapy;
    private int mlevel;
    private long modifiedtime;
    private int readcount;
    private int sigungucode;
    private String tel;
    private String title;
    private String zipcode;
}

/* 공공데이터 포맷
    addr1: "서울특별시 강서구 곰달래로 247"
    areacode: 1
    cat1: "B02"
    cat2: "B0201"
    cat3: "B02010900"
    contentid: 1747824
    contenttypeid: 32
    createdtime: 20121105144638
    firstimage: "http://tong.visitkorea.or.kr/cms/resource/22/1744722_image2_1.jpg"
    firstimage2: "http://tong.visitkorea.or.kr/cms/resource/22/1744722_image3_1.jpg"
    mapx: 126.8605382972
    mapy: 37.5322339006
    mlevel: 6
    modifiedtime: 20201109162714
    readcount: 16412
    sigungucode: 4
    tel: "02-2643-8800"
    title: "㈜코스테이"
    zipcode: "07741"
 */
