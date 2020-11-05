package bookmarket;

import bookmarket.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class PublpageViewHandler {


    @Autowired
    private PublpageRepository publpageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenRegRequested_then_CREATE_1 (@Payload RegRequested regRequested) {
        try {
            if (regRequested.isMe()) {
                // view 객체 생성
                Publpage publpage = new Publpage();
                // view 객체에 이벤트의 Value 를 set 함
                publpage.setReqId(regRequested.getId());
                publpage.setPublId(regRequested.getPublId());
                publpage.setReqYn(regRequested.getRegYn());
                publpage.setBookNm(regRequested.getBookNm());
                // view 레파지 토리에 save
                publpageRepository.save(publpage);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenReqCanceled_then_UPDATE_1(@Payload ReqCanceled reqCanceled) {
        try {
            if (reqCanceled.isMe()) {
                // view 객체 조회
                List<Publpage> publpageList = publpageRepository.findByReqId(reqCanceled.getId());
                for(Publpage publpage : publpageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    publpage.setReqYn(reqCanceled.getRegYn());
                    // view 레파지 토리에 save
                    publpageRepository.save(publpage);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenApproved_then_UPDATE_2(@Payload Approved approved) {
        try {
            if (approved.isMe()) {
                // view 객체 조회
                List<Publpage> publpageList = publpageRepository.findByReqId(approved.getReqReqId());
                for(Publpage publpage : publpageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    publpage.setReqYn(approved.getAppYn());
                    // view 레파지 토리에 save
                    publpageRepository.save(publpage);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenAppCanceled_then_UPDATE_3(@Payload AppCanceled appCanceled) {
        try {
            if (appCanceled.isMe()) {
                // view 객체 조회
                List<Publpage> publpageList = publpageRepository.findByReqId(appCanceled.getReqReqId());
                for(Publpage publpage : publpageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    publpage.setReqYn(appCanceled.getAppYn());
                    // view 레파지 토리에 save
                    publpageRepository.save(publpage);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}