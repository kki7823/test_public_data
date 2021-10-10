import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ParseJSON {
    public static void main(String[] args) {
        String key = "P3TbC5uJmBCIyJ5XyNE96Iggnml%2FE7YpEPLGKNQAG6P1Pg36WbbyZPeOkl%2BjZa9JsjLoIwO0saCVPxy48P5nMQ%3D%3D";
        String result = "";

        try {
            URL url = new URL("http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?ServiceKey=" + key + "&contentTypeId=&areaCode=1&sigunguCode=&cat1=&cat2=&cat3=&listYN=Y&MobileOS=ETC&MobileApp=TourAPI3.0_Guide&arrange=A&numOfRows=3172&_type=json");
            BufferedReader br = null;
            br = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8));

            //URL -> JSON 데이터 String으로 저장
            result = br.readLine();

            ObjectMapper mapper = new ObjectMapper();

            /* 공공데이터 JSON구조
                response:
                    body:
                    items:
                        item: Array(12)
                        0: {areacode: 1, cat1: "C01", cat2: "C0115", cat3: "C01150001", contentid: 2044565, …}
                        1: {addr1: "서울특별시 강서구 곰달래로 247", areacode: 1, cat1: "B02", cat2: "B0201", cat3: "B02010900", …}
                        2: {addr1: "서울특별시 용산구 청파로 74", areacode: 1, cat1: "A05", cat2: "A0502", cat3: "A05020300", …}
                        3: {addr1: "서울특별시 종로구 평창30길 28", addr2: "(평창동)", areacode: 1, cat1: "A02", cat2: "A0206", …}
                        ...
             */

            //API로 가져온 JSON중 item으로 시작되는 데이터 노드 추출
            JsonNode resultNode = mapper.readTree(result).findPath("item");
            //변환한 컬렉션 타입 생성 (List<DTO>)

            System.out.println(result);

            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, DTO.class);
            //사전에 정의 한 DTO로 JSON 데이터 List<DTO>형태로 저장
            List<DTO> list = mapper.readValue(resultNode.toString(), collectionType);

            //DB에 데이터 삽입
            DAO dao = new DAO();

            for (int i = 0; i<list.size(); i++){
                dao.insert(list.get(i));
            }
            System.out.println("데이터 삽입 완료");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
