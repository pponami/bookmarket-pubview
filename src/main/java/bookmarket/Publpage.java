package bookmarket;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Publpage_table")
public class Publpage {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private Long reqId;
        private Long publId;
        private String reqYn;
        private String bookNm;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public Long getReqId() {
            return reqId;
        }

        public void setReqId(Long reqId) {
            this.reqId = reqId;
        }
        public Long getPublId() {
            return publId;
        }

        public void setPublId(Long publId) {
            this.publId = publId;
        }
        public String getReqYn() {
            return reqYn;
        }

        public void setReqYn(String reqYn) {
            this.reqYn = reqYn;
        }
        public String getBookNm() {
            return bookNm;
        }

        public void setBookNm(String bookNm) {
            this.bookNm = bookNm;
        }

}
