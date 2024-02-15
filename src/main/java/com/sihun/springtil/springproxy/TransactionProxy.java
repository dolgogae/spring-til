package com.sihun.springtil.springproxy;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionProxy {
    @Transactional
    public void performTransactionalOperation(){
        // 트랜잭션 내의 데이터베이스 작업
    }
}
